package de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import de.hu_berlin.u.saltnpepper.graph.GRAPH_ATTRIBUTES;
import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.graph.impl.LayerImpl;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.Listener;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.Notifier;

@SuppressWarnings("serial")
public class LayerNotifierImpl<N extends Node, R extends Relation<N, N>> extends LayerImpl<N, R> implements Layer<N, R>, Notifier {
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
	public void addListener(Collection<Listener> listener) {
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
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.LAYER_LABELS, null, label, this);
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
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.LAYER_LABELS, oldValue, null, this);
		}
	}

	@Override
	public void removeLabel(String namespace, String name) {
		Label oldValue = getLabel(namespace, name);
		super.removeLabel(namespace, name);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.LAYER_LABELS, oldValue, null, this);
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
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE_ALL, GRAPH_ATTRIBUTES.LAYER_LABELS, oldValue, null, this);
		}
	}
	// ==========================================< label handling

	@Override
	public void addNode(N node) {
		super.removeAll();
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.LAYER_NODES, null, node, this);
		}
	}

	@Override
	public void removeNode(N node) {
		super.removeAll();
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.LAYER_NODES, node, null, this);
		}
	}

	@Override
	public void addRelation(Relation<? extends Node, ? extends Node> relation) {
		super.removeAll();
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.LAYER_RELATIONS, null, relation, this);
		}
	}

	@Override
	public void removeRelation(R relation) {
		super.removeAll();
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.LAYER_RELATIONS, relation, null, this);
		}
	}
}
