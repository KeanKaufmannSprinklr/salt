/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.u.saltnpepper.graph.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltException;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Mgr</b></em>'. <!-- end-user-doc -->
 * 
 */
public class IndexImpl implements Index {
	private final ReadWriteLock L = new ReentrantReadWriteLock();

	private Map<String, Multimap<Object, Object>> indexes;
	private Map<String, Class<?>> indexKeyTypes;
	private Map<String, Class<?>> indexValueTypes;

	private final boolean threadSafe;

	public IndexImpl() {
		this(false);
	}

	public IndexImpl(boolean threadSafe) {
		this.threadSafe = threadSafe;

		indexes = Maps.newHashMap();
		indexKeyTypes = Maps.newHashMap();
		indexValueTypes = Maps.newHashMap();
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public <K, V> void addIndex(String indexId, Class<K> keyType, Class<V> valueType) {
		if (threadSafe) {
			L.writeLock().lock();
		}
		try {
			if (this.hasIndex(indexId))
				throw new SaltException("Cannot add the given index, because an index with this id already exists: " + indexId);

			indexes.put(indexId, LinkedHashMultimap.create());
			indexKeyTypes.put(indexId, keyType);
			indexValueTypes.put(indexId, valueType);
		} finally {
			if (threadSafe) {
				L.writeLock().unlock();
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public boolean hasIndex(String indexId) {
		if (threadSafe) {
			L.readLock().lock();
		}
		try {
			return indexes.containsKey(indexId);
		} finally {
			if (threadSafe) {
				L.readLock().unlock();
			}
		}
	}

	public <K, V> boolean put(String indexId, K key, V value) {
		if (threadSafe) {
			L.writeLock().lock();
		}

		try {
			if (indexId != null && key != null && value != null) {
				Class<?> keyClass = indexKeyTypes.get(indexId);
				Class<?> valueClass = indexValueTypes.get(indexId);

				if (keyClass != null && valueClass != null && keyClass.isAssignableFrom(key.getClass()) && valueClass.isAssignableFrom(value.getClass())) {
					return indexes.get(indexId).put(key, value);
				}
			}
			return false;
		} finally {
			if (threadSafe) {
				L.writeLock().unlock();
			}
		}
	}

	public <K, V> boolean putAll(String indexId, K key, Collection<V> values) {
		if (threadSafe) {
			L.writeLock().lock();
		}

		try {
			if (indexId != null && key != null && values != null && !values.isEmpty()) {
				Class<?> keyClass = indexKeyTypes.get(indexId);
				Class<?> valueClass = indexValueTypes.get(indexId);

				if (keyClass.isAssignableFrom(key.getClass()) && valueClass.isAssignableFrom(values.iterator().next().getClass())) {
					return indexes.get(indexId).putAll(key, values);
				}
			}
			return false;
		} finally {
			if (threadSafe) {
				L.writeLock().unlock();
			}
		}
	}

	public <K, V> V get(String indexId, K key) {
		List<V> result = getAll(indexId, key);
		if (result.isEmpty()) {
			return null;
		} else {
			return result.iterator().next();
		}
	}

	public <K, V> List<V> getAll(String indexId, K key) {
		if (indexId != null && key != null) {
			if (threadSafe) {
				L.readLock().lock();
			}
			
			try {
				return Collections.unmodifiableList((List<V>) indexes.get(indexId).get(key));
			} finally {
				if (threadSafe) {
					L.readLock().unlock();
				}
			}
		}
		// return ImmutableList.copyOf(new LinkedList<V>());
		return Collections.synchronizedList(new ArrayList<V>());
	}

	public <K> boolean containsKey(String indexId, K key) {
		return !getAll(indexId, key).isEmpty();
	}

	public <K> boolean remove(String indexId, K key) {
		if (indexId != null && key != null) {
			if (threadSafe) {
				L.writeLock().lock();
			}

			try {
				Class<?> keyClass = indexKeyTypes.get(indexId);
				if (keyClass != null && keyClass.isAssignableFrom(key.getClass())) {
					return !indexes.get(indexId).removeAll(key).isEmpty();
				}
			} finally {
				if (threadSafe) {
					L.writeLock().unlock();
				}
			}
		}
		return false;
	}

	public <K, V> boolean remove(String indexId, K key, V value) {
		if (indexId != null && key != null && value != null) {
			if (threadSafe) {
				L.writeLock().lock();
			}

			try {
				Class<?> keyClass = indexKeyTypes.get(indexId);
				Class<?> valueClass = indexValueTypes.get(indexId);
				if (keyClass != null && valueClass != null && keyClass.isAssignableFrom(key.getClass()) && valueClass.isAssignableFrom(value.getClass())) {
					return indexes.get(indexId).remove(key, value);
				}

			} finally {
				if (threadSafe) {
					L.writeLock().unlock();
				}
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public boolean removeIndex(String indexId) {
		if (threadSafe) {
			L.writeLock().lock();
		}

		try {
			if (indexes.remove(indexId) == null) {
				indexKeyTypes.remove(indexId);
				indexValueTypes.remove(indexId);
				return true;
			}
			return false;
		} finally {
			if (threadSafe) {
				L.writeLock().unlock();
			}
		}
	}

	public void clearIndex(String indexId) {
		if (threadSafe) {
			L.writeLock().lock();
		}

		try {
			Multimap<Object, Object> idx = indexes.get(indexId);
			if (idx != null) {
				idx.clear();
			}
		} finally {
			if (threadSafe) {
				L.writeLock().unlock();
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public void removeAll() {
		if (threadSafe) {
			L.writeLock().lock();
		}

		try {
			indexes.clear();
			indexKeyTypes.clear();
			indexValueTypes.clear();
		} finally {
			if (threadSafe) {
				L.writeLock().unlock();
			}
		}
	}

	/**
	 * Removes the given element from all indexes.
	 * 
	 * @param element
	 *            - the element which shall be removed
	 * @return true, if removing was successful
	 */
	public <V> boolean removeElement(V element) {
		boolean result = false;

		if (element != null) {
			if (threadSafe) {
				L.writeLock().lock();
			}

			try {
				for (Entry<String, Multimap<Object, Object>> e : indexes.entrySet()) {
					// only search for the value if it is possible to store this
					// type of data in the index
					if (indexValueTypes.get(e.getKey()).isAssignableFrom(element.getClass())) {
						result = e.getValue().values().remove(element) || result;
					}
				}
			} finally {
				if (threadSafe) {
					L.writeLock().unlock();
				}
			}
		}
		return result;
	}

	public <V> boolean removeElement(String indexId, V element) {
		boolean result = false;

		if (indexId != null && element != null) {
			if (threadSafe) {
				L.writeLock().lock();
			}

			try {
				Multimap<Object, Object> idx = indexes.get(indexId);
				Class<?> valueClass = indexValueTypes.get(indexId);

				if (idx != null && valueClass != null && valueClass.isAssignableFrom(element.getClass())) {
					result = idx.values().remove(element);
				}
			} finally {
				if (threadSafe) {
					L.writeLock().unlock();
				}
			}
		}

		return result;
	}

	public boolean removeAllElements(Collection<?> element) {
		boolean result = false;
		if (threadSafe) {
			L.writeLock().lock();
		}

		try {
			for (Multimap<?, ?> index : indexes.values()) {
				result = index.values().removeAll(element) || result;
			}
		} finally {
			if (threadSafe) {
				L.writeLock().unlock();
			}
		}
		return result;
	}

} // IndexMgrImpl