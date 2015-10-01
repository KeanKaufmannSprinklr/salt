package de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.Tests;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.GRAPH_ATTRIBUTES;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.impl.LayerNotifierImpl;

public class LayerNotifierTest {

	private LayerNotifierImpl fixture = null;

	public LayerNotifierImpl getFixture() {
		return fixture;
	}

	public void setFixture(LayerNotifierImpl fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(new LayerNotifierImpl());
	}

	/** Checks whether the notification about name change is correct. **/
	@Test
	public void testNotificationAddRemoveValue() {
		Helper.testNotificationAddRemoveValue(fixture, GRAPH_ATTRIBUTES.LAYER_LABELS);
	}
}