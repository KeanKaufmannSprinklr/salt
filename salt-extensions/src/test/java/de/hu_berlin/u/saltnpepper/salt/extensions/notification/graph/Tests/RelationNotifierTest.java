package de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.Tests;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.impl.RelationNotifierImpl;

public class RelationNotifierTest {

	private RelationNotifierImpl fixture = null;

	public RelationNotifierImpl getFixture() {
		return fixture;
	}

	public void setFixture(RelationNotifierImpl fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(new RelationNotifierImpl());
	}

	/** Checks whether the notification about name change is correct. **/
	@Test
	public void testNotificationAddRemoveValue() {
		Helper.testNotificationAddRemoveValue(fixture);
	}
}