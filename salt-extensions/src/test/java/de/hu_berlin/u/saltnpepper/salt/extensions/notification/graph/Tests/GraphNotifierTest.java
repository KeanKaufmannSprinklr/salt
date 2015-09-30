package de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.Tests;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.impl.GraphNotifierImpl;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.impl.RelationNotifierImpl;

public class GraphNotifierTest {

	private GraphNotifierImpl fixture = null;

	public GraphNotifierImpl getFixture() {
		return fixture;
	}

	public void setFixture(GraphNotifierImpl fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(new GraphNotifierImpl());
	}

//	/** Checks whether the notification about name change is correct. **/
//	@Test
//	public void testNotificationAddRemoveValue() {
//		Helper.testNotificationAddRemoveValue(fixture);
//	}
}