package de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.GRAPH_ATTRIBUTES;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.Listener;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.impl.NotifierHelper;

public class NotifierHelperTest {

	@Test
	public void testAddRemoveGetListener() {
		Listener listener1 = new Listener() {
			@Override
			public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue, Object container) {
			}
		};
		Listener listener2 = new Listener() {
			@Override
			public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue, Object container) {
			}
		};

		assertNotNull(NotifierHelper.getListener(null));
		assertEquals(0, NotifierHelper.getListener(null).size());

		ArrayList<Listener> listenerList = new ArrayList<>();
		assertEquals(0, NotifierHelper.getListener(listenerList).size());

		NotifierHelper.addListener(listenerList, null);
		assertEquals(0, NotifierHelper.getListener(listenerList).size());

		NotifierHelper.addListener(listenerList, listener1);
		assertEquals(1, NotifierHelper.getListener(listenerList).size());

		NotifierHelper.addListener(listenerList, listener2);
		assertEquals(2, NotifierHelper.getListener(listenerList).size());
	}

}
