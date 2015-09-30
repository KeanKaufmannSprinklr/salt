package de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import de.hu_berlin.u.saltnpepper.graph.GRAPH_ATTRIBUTES;
import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphImpl;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.Listener;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.Notifier;

@SuppressWarnings("serial")
public class GraphNotifierImpl<N extends Node, R extends Relation<N, N>, L extends Layer<N, R>> extends GraphImpl<N, R, L> implements Graph<N, R, L>, Notifier {
	// ==========================================> listener list
	protected List<Listener> listenerList = null;

	/** {@inheritDoc} **/
	@Override
	public List<Listener> getListener() {
		return (NotifierHelper.getListener(listenerList));
	}

	/** {@inheritDoc} **/
	@Override
	public synchronized void addListener(Listener listener) {
		listenerList = NotifierHelper.addListener(listenerList, listener);
	}

	/** {@inheritDoc} **/
	@Override
	public synchronized void removeListener(Listener listener) {
		listenerList = NotifierHelper.removeListener(listenerList, listener);
	}

	// ==========================================< listener list

	// ==========================================> label handling
	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void addLabel(Label label) {
		super.addLabel(label);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_LABELS, null, label, this);
		}
	}

	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void removeLabel(String qName) {
		Label oldValue = getLabel(qName);
		super.removeLabel(qName);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.GRAPH_LABELS, oldValue, null, this);
		}
	}

	@Override
	public void removeLabel(String namespace, String name) {
		Label oldValue = getLabel(namespace, name);
		super.removeLabel(namespace, name);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.GRAPH_LABELS, oldValue, null, this);
		}
	}

	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void removeAll() {
		Collection<Label> oldValue = getLabels();
		super.removeAll();
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE_ALL, GRAPH_ATTRIBUTES.GRAPH_LABELS, oldValue, null, this);
		}
	}

	// ==========================================< label handling

	@Override
	public void addNode(N node) {
		super.addNode(node);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_NODES, null, node, this);
		}
	}

	@Override
	public void removeNode(N node) {
		super.removeNode(node);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.GRAPH_NODES, node, null, this);
		}
	}

	@Override
	public void addRelation(Relation<? extends Node, ? extends Node> relation) {
		super.addRelation(relation);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_RELATIONS, null, relation, this);
		}
	}

	@Override
	public void removeRelation(R relation) {
		super.removeRelation(relation);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.GRAPH_RELATIONS, relation, null, this);
		}
	}

	@Override
	public void removeRelations() {
		List<R> oldValue = getRelations();
		super.removeRelations();
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE_ALL, GRAPH_ATTRIBUTES.GRAPH_RELATIONS, oldValue, null, this);
		}
	}

	@Override
	public void addLayer(L layer) {
		super.addLayer(layer);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_LAYERS, null, layer, this);
		}
	}

	@Override
	public void removeLayer(L layer) {
		Set<L> oldValue = getLayers();
		super.removeLayer(layer);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.GRAPH_LAYERS, oldValue, null, this);
		}
	}
}
