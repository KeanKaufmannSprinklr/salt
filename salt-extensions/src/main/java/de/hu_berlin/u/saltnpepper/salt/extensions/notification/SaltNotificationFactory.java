package de.hu_berlin.u.saltnpepper.salt.extensions.notification;

import java.util.Collection;
import java.util.List;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.IdentifiableElement;
import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.salt.ISaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.SCorpus;
import de.hu_berlin.u.saltnpepper.salt.common.SCorpusDocumentRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.SCorpusRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.SDominanceRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SMedialDS;
import de.hu_berlin.u.saltnpepper.salt.common.SMedialRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SOrderRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SPointingRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SSpan;
import de.hu_berlin.u.saltnpepper.salt.common.SSpanningRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SStructure;
import de.hu_berlin.u.saltnpepper.salt.common.STextualDS;
import de.hu_berlin.u.saltnpepper.salt.common.STextualRelation;
import de.hu_berlin.u.saltnpepper.salt.common.STimeline;
import de.hu_berlin.u.saltnpepper.salt.common.STimelineRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SToken;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.common.impl.SDocumentImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.STokenImpl;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SLayer;
import de.hu_berlin.u.saltnpepper.salt.core.SMetaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SProcessingAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.Notifier;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.impl.NodeNotifierImpl;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.impl.NotifierHelper;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.impl.RelationNotifierImpl;
import de.hu_berlin.u.saltnpepper.salt.impl.SaltFactoryImpl;
import de.hu_berlin.u.saltnpepper.salt.semantics.SCatAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SLemmaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SPOSAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SSentenceAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.STypeAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SWordAnnotation;

public class SaltNotificationFactory extends SaltFactoryImpl implements ISaltFactory, Notifier{

	// ==========================================> listener list
	protected static List<Listener> listenerList = null;

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

	@Override
	public Node createNode() {
		NodeNotifierImpl node= new NodeNotifierImpl();
		node.addListener(getListener());
		return(node);
	}

	@Override
	public Relation<Node, Node> createRelation() {
		RelationNotifierImpl<Node, Node> relation= new RelationNotifierImpl<Node, Node>();
		relation.addListener(relation.getListener());
		return(relation);
	}


	@Override
	public SDocument createSDocument() {
		return(new SDocumentImpl(createNode()));
	}
	
	@Override
	public SToken createSToken() {
		return(new STokenImpl(createNode()));
	}
}