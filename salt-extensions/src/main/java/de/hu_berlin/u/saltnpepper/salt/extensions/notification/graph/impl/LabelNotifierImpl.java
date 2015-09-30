package de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.impl;

import java.util.Collection;
import java.util.List;

import de.hu_berlin.u.saltnpepper.graph.GRAPH_ATTRIBUTES;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.impl.LabelImpl;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.Listener;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.Notifier;

@SuppressWarnings("serial")
public class LabelNotifierImpl extends LabelImpl implements Label, Notifier {

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
	
	// ==========================================> handling contained label
	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void addLabel(Label label) {
		super.addLabel(label);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.LABEL_LABELS, null, label, this);
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
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.LABEL_LABELS, oldValue, null, this);
		}
	}

	@Override
	public void removeLabel(String namespace, String name) {
		Label oldValue = getLabel(namespace, name);
		super.removeLabel(namespace, name);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.LABEL_LABELS, oldValue, null, this);
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
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE_ALL, GRAPH_ATTRIBUTES.LABEL_LABELS, oldValue, null, this);
		}
	}
	// ==========================================< handling contained label

	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void setNamespace(String namespace) {
		String oldValue = getNamespace();
		super.setNamespace(namespace);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAMESPACE, oldValue, namespace, this);
		}
	}

	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void setName(String name) {
		String oldValue = getName();
		super.setName(name);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAME, oldValue, name, this);
		}
	}

	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void setQName(String qName) {
		String oldNamespace = getNamespace();
		String oldName = getName();
		super.setNamespace(namespace);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAMESPACE, oldNamespace, getNamespace(), this);
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAME, oldName, getName(), this);
		}
	}

	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void setValue(Object value) {
		Object oldValue = getValue();
		super.setValue(value);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_VALUE, oldValue, value, this);
		}
	}
}
