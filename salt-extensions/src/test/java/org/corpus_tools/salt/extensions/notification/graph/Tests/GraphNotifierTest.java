package org.corpus_tools.salt.extensions.notification.graph.Tests;

import static org.junit.Assert.assertEquals;

import org.corpus_tools.salt.extensions.notification.Listener.NOTIFICATION_TYPE;
import org.corpus_tools.salt.extensions.notification.graph.Tests.Helper.MyListener;
import org.corpus_tools.salt.extensions.notification.graph.impl.GraphNotifierImpl;
import org.corpus_tools.salt.extensions.notification.graph.impl.RelationNotifierImpl;
import org.junit.Before;
import org.junit.Test;

import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.SaltFactory;

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

	/** Checks whether the notification about name change is correct. **/
	@Test
	public void testNotificationAddRemoveValue() {
		Helper.testNotificationAddRemoveValue(fixture, GRAPH_ATTRIBUTES.GRAPH_LABELS);
	}
	/** Checks whether the graph sends a notification when a node was added.  **/
	@Test
	public void testNotificationAddNode(){
		MyListener listener = new MyListener();
		fixture.addListener(listener);
		Node node= GraphFactory.createNode();
		
		fixture.addNode(node);
		assertEquals(NOTIFICATION_TYPE.ADD, listener.lastEvent.type);
		assertEquals(GRAPH_ATTRIBUTES.GRAPH_NODES, listener.lastEvent.attribute);
		assertEquals(null, listener.lastEvent.oldValue);
		assertEquals(node, listener.lastEvent.newValue);
		assertEquals(fixture, listener.lastEvent.container);
	}
	/** Checks whether the graph sends a notification when a relation was added.  **/
	@Test
	public void testNotificationRelationNode(){
		MyListener listener = new MyListener();
		fixture.addListener(listener);
		Relation relation= GraphFactory.createRelation();
		Node node= GraphFactory.createNode();
		getFixture().addNode(node);
		relation.setSource(node);
		relation.setTarget(node);
		
		fixture.addRelation(relation);
		assertEquals(NOTIFICATION_TYPE.ADD, listener.lastEvent.type);
		assertEquals(GRAPH_ATTRIBUTES.GRAPH_RELATIONS, listener.lastEvent.attribute);
		assertEquals(null, listener.lastEvent.oldValue);
		assertEquals(relation, listener.lastEvent.newValue);
		assertEquals(fixture, listener.lastEvent.container);
	}
	/** Checks whether the graph sends a notification when a layer was added.  **/
	@Test
	public void testNotificationAddLayer(){
		MyListener listener = new MyListener();
		fixture.addListener(listener);
		Layer layer= GraphFactory.createLayer();
		
		fixture.addLayer(layer);
		assertEquals(NOTIFICATION_TYPE.ADD, listener.lastEvent.type);
		assertEquals(GRAPH_ATTRIBUTES.GRAPH_LAYERS, listener.lastEvent.attribute);
		assertEquals(null, listener.lastEvent.oldValue);
		assertEquals(layer, listener.lastEvent.newValue);
		assertEquals(fixture, listener.lastEvent.container);
	}
}