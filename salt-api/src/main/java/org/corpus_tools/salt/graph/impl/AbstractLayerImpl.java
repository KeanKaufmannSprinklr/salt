/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
package org.corpus_tools.salt.graph.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.corpus_tools.salt.exceptions.SaltInsertionException;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;

@SuppressWarnings("serial")
public abstract class AbstractLayerImpl<N extends Node, R extends Relation<N, N>> extends IdentifiableElementImpl implements Layer<N, R> {

	private Set<N> nodes = null;
	private Set<R> relations = null;

	public AbstractLayerImpl() {
		nodes = new HashSet<N>();
		relations = new HashSet<R>();
	}

	/**
	 * Initializes an object of type {@link Layer}. If {@link #delegate} is not
	 * null, all functions of this method are delegated to the delegate object.
	 * Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public AbstractLayerImpl(Layer<N, R> delegate) {
		super(delegate);
		nodes = new HashSet<N>();
		relations = new HashSet<R>();
	}

	@SuppressWarnings("unchecked") // in sync with constructor (and delegate is final)
	@Override
	protected Layer<N, R> getDelegate() {
		return (Layer<N,R>) super.getDelegate();
	}

	/** container graph **/
	protected Graph<?,?,?> graph = null;

	/** {@inheritDoc Relation#getGraph()} **/
	@Override
	public Graph getGraph() {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return (getDelegate().getGraph());
		}
		return (graph);
	}

	/** {@inheritDoc Relation#setGraph(Graph)} **/
	@Override
	public void setGraph(Graph graph) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			getDelegate().setGraph(graph);
			return;
		}
		if (graph != null) {
			if (graph instanceof AbstractGraphImpl<?,?,?>) {
				((AbstractGraphImpl<?,?,?>) graph).basicAddLayer(this);
			}
		} else {
			if (getGraph() instanceof AbstractGraphImpl<?,?,?>) {
				((AbstractGraphImpl<?,?,?>) getGraph()).basicRemoveLayer(this);
			}
		}
		basicSetGraph(graph);
	}

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link Graph} and {@link Layer} object when an layer is inserted into
	 * this graph and to avoid an endless invocation the insertion of an layer
	 * is splited into the two methods {@link #setGraph(Graph)} and
	 * {@link #basicSetGraph(Graph)}. The invocation of methods is implement as
	 * follows:
	 * 
	 * <pre>
	 * {@link Graph#addLayer(Layer)}                      {@link Layer#setGraph(Graph)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link Graph#basicAddLayer(Layer)}            {@link Layer#basicSetGraph(Graph)}
	 * </pre>
	 * 
	 * That means method {@link #setGraph(Graph)} calls
	 * {@link #basicSetGraph(Graph)} and {@link Graph#basicAddLayer(Layer)}. And
	 * method {@link #setGraph(Graph)} calls {@link Graph#basicAddLayer(Layer)}
	 * and {@link Layer#basicSetGraph(Graph)}.
	 * 
	 * @param graph
	 *            graph which contains this layer
	 */
	protected void basicSetGraph(Graph graph) {
		if (getDelegate() != null && getDelegate() instanceof AbstractLayerImpl<?,?>) {
			((AbstractLayerImpl<?,?>) getDelegate()).basicSetGraph(graph);
			return;
		}
		// remove from old graph if it was changed
		if (this.graph != graph && this.graph instanceof AbstractGraphImpl<?,?,?>) {
			((AbstractGraphImpl<?,?,?>) this.graph).basicRemoveLayer(this);
		}
		this.graph = graph;
	}

	/**
	 * Same as {@link #basicSetGraph(Graph)} but does not remove this layer from
	 * old graph, if it was not equal to the passed graph.
	 * 
	 * @param graph
	 */
	protected void basicSetGraph_WithoutRemoving(Graph graph) {
		this.graph = graph;
	}

	/** {@inheritDoc Layer#getNodes()} **/
	@Override
	public Set<N> getNodes() {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().getNodes();
		}
		return (Collections.unmodifiableSet(nodes));
	}

	/** {@inheritDoc Layer#addNode(Node)} **/
	@Override
	public void addNode(N node) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			getDelegate().addNode(node);
			return;
		}
		if ((getGraph() != null) && (!getGraph().containsNode(node.getId()))) {
			getGraph().addNode(node);
		}
		nodes.add(node);
	}

	/** {@inheritDoc Layer#removeNode(Node)} **/
	@Override
	public void removeNode(N node) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			getDelegate().removeNode(node);
			return;
		}

		if (nodes != null) {
			nodes.remove(node);
		}
	}

	/** {@inheritDoc Layer#getRelations()} **/
	@Override
	public Set<R> getRelations() {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().getRelations();
		}

		return (Collections.unmodifiableSet(relations));
	}
	
	/**
	 * Makes sure that the argument has the correct sub-type or return {@code null} if not.
	 * @param relation Either the casted original value
	 * @return Either the casted original value or {@code null} if not valid.
	 */
	protected abstract R cast(Relation<? extends Node, ? extends Node> relation);

	/** {@inheritDoc Layer#addRelation(Relation)} **/
	@Override
	public void addRelation(Relation<? extends N, ? extends N> relationRaw) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			getDelegate().addRelation(relationRaw);
			return;
		}
		
		if (relationRaw == null) {
			throw new SaltParameterException("relation", "basicAddRelation", GraphImpl.class, "A null value is not allowed. ");
		}
		R relation = cast(relationRaw);
		if (relation == null) {
		  throw new SaltInsertionException(this, relation, "Cannot insert an edge, which is does not have expected type. ");
		}

		if ((getGraph() != null) && (!getGraph().containsRelation(relation.getId()))) {
			getGraph().addRelation(relation);
		}
		relations.add(relation);
	}

	/** {@inheritDoc Layer#removeRelation(Relation)} **/
	@Override
	public void removeRelation(Relation<? extends N, ? extends N> relation) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			getDelegate().removeRelation(relation);
			return;
		}

		if (relation != null) {
			relations.remove(relation);
		}
	}
}
