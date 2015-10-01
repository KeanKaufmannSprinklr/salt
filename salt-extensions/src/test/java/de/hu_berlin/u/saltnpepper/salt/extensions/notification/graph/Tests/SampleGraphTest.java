package de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.GRAPH_ATTRIBUTES;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.SToken;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.Listener;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.SaltNotificationFactory;
import de.hu_berlin.u.saltnpepper.salt.samples.SampleGenerator;

public class SampleGraphTest implements Listener {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		SaltNotificationFactory factory= new SaltNotificationFactory();
		SaltFactory.setFactory(new SaltNotificationFactory());
		factory.addListener(this);
		SDocument doc= SaltFactory.createSDocument();
		SampleGenerator.createSyntaxStructure(doc);
		
		System.out.println("------------------------------- HALLO");
		for (SToken tok: doc.getDocumentGraph().getTokens()){
			System.out.println(tok.getId());
		}
	}

	@Override
	public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue, Object container) {
		System.out.println(type + ", " + attribute + ", " + oldValue + ", " + newValue + ", " + container);
	}

}
