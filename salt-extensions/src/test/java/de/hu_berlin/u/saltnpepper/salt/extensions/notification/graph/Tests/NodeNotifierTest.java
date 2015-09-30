package de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.Tests;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.impl.NodeNotifierImpl;

public class NodeNotifierTest {

	private NodeNotifierImpl fixture = null;

	public NodeNotifierImpl getFixture() {
		return fixture;
	}

	public void setFixture(NodeNotifierImpl fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(new NodeNotifierImpl());
	}

	/** Checks whether the notification about name change is correct. **/
	@Test
	public void testNotificationAddRemoveValue() {
		Helper.testNotificationAddRemoveValue(fixture);
	}
}