package de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.impl;

import java.util.Collection;
import java.util.List;

import de.hu_berlin.u.saltnpepper.graph.GRAPH_ATTRIBUTES;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.graph.impl.RelationImpl;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.Listener;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.Notifier;

@SuppressWarnings("serial")
public class RelationNotifierImpl<S extends Node, T extends Node> extends RelationImpl<S, T> implements Relation<S, T>, Notifier {

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
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.RELATION_LABELS, null, label, this);
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
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.RELATION_LABELS, oldValue, null, this);
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
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE_ALL, GRAPH_ATTRIBUTES.RELATION_LABELS, oldValue, null, this);
		}
	}

	// ==========================================< label handling

	// ==========================================> relation handling
	@Override
	public void setSource(S source) {
		S oldValue = getSource();
		super.setSource(source);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.RELATION_SOURCE, oldValue, getSource(), this);
		}
	}

	@Override
	public void setTarget(T target) {
		T oldValue = getTarget();
		super.setTarget(target);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.RELATION_TARGET, oldValue, getTarget(), this);
		}
	}
	// ==========================================< relation handling
}