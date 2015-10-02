package de.hu_berlin.u.saltnpepper.salt.extensions.notification;

import java.util.Collection;
import java.util.List;

import de.hu_berlin.u.saltnpepper.graph.Graph;
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
import de.hu_berlin.u.saltnpepper.salt.common.impl.SCorpusDocumentRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.SCorpusGraphImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.SCorpusImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.SCorpusRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.SDocumentGraphImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.SDocumentImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.SDominanceRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.SMedialDSImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.SMedialRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.SOrderRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.SPointingRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.SSpanImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.SSpanningRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.SStructureImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.STextualDSImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.STextualRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.STimelineImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.STimelineRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.STokenImpl;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SLayer;
import de.hu_berlin.u.saltnpepper.salt.core.SMetaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SProcessingAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SFeatureImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SGraphImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SLayerImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SMetaAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SNodeImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SProcessingAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.Notifier;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.impl.GraphNotifierImpl;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.impl.LabelNotifierImpl;
import de.hu_berlin.u.saltnpepper.salt.extensions.notification.graph.impl.LayerNotifierImpl;
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
import de.hu_berlin.u.saltnpepper.salt.semantics.impl.SCatAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.semantics.impl.SLemmaAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.semantics.impl.SPOSAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.semantics.impl.SSentenceAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.semantics.impl.STypeAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.semantics.impl.SWordAnnotationImpl;

public class SaltNotificationFactory extends SaltFactoryImpl implements ISaltFactory, Notifier {

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

	// ==========================================> salt graph

	@Override
	public Node createNode() {
		NodeNotifierImpl node = new NodeNotifierImpl();
		node.addListener(getListener());
		return (node);
	}

	@Override
	public Relation<Node, Node> createRelation() {
		RelationNotifierImpl<Node, Node> relation = new RelationNotifierImpl<Node, Node>();
		relation.addListener(relation.getListener());
		return (relation);
	}

	@Override
	public Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> createGraph() {
		GraphNotifierImpl<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> graph = new GraphNotifierImpl();
		graph.addListener(getListener());
		return (graph);
	}

	@Override
	public Label createLabel() {
		LabelNotifierImpl label = new LabelNotifierImpl();
		label.addListener(getListener());
		return (label);
	}

	@Override
	public Layer<Node, Relation<Node, Node>> createLayer() {
		LayerNotifierImpl<Node, Relation<Node, Node>> node = new LayerNotifierImpl();
		node.addListener(getListener());
		return (node);
	}

	// ==========================================< salt graph
	// ==========================================> salt core
	@Override
	public SGraph createSGraph() {
		return (new SGraphImpl(createGraph()));
	}

	@Override
	public SNode createSNode() {
		return (new SNodeImpl(createNode()));
	}

	@Override
	public SRelation<SNode, SNode> createSRelation() {
		return (new SRelationImpl<SNode, SNode>(createRelation()));
	}

	@Override
	public SAnnotation createSAnnotation() {
		return (new SAnnotationImpl(createLabel()));
	}

	@Override
	public SMetaAnnotation createSMetaAnnotation() {
		return (new SMetaAnnotationImpl(createLabel()));
	}

	@Override
	public SProcessingAnnotation createSProcessingAnnotation() {
		return (new SProcessingAnnotationImpl(createLabel()));
	}

	@Override
	public SFeature createSFeature() {
		return (new SFeatureImpl(createLabel()));
	}

	@Override
	public SLayer createSLayer() {
		return (new SLayerImpl(createLayer()));
	}

	// ==========================================< salt core
	// ==========================================> salt common
	@Override
	public SCorpus createSCorpus() {
		return (new SCorpusImpl(createNode()));
	}

	@Override
	public SCorpusRelation createSCorpusRelation() {
		return (new SCorpusRelationImpl(createRelation()));
	}

	@Override
	public SCorpusDocumentRelation createSCorpusDocumentRelation() {
		return (new SCorpusDocumentRelationImpl(createRelation()));
	}

	@Override
	public SCorpusGraph createSCorpusGraph() {
		return (new SCorpusGraphImpl(createGraph()));
	}

	@Override
	public SDocumentGraph createSDocumentGraph() {
		return (new SDocumentGraphImpl(createGraph()));
	}

	@Override
	public SDocument createSDocument() {
		return (new SDocumentImpl(createNode()));
	}

	@Override
	public SToken createSToken() {
		return (new STokenImpl(createNode()));
	}

	@Override
	public SSpanningRelation createSSpanningRelation() {
		return (new SSpanningRelationImpl(createRelation()));
	}

	@Override
	public SDominanceRelation createSDominanceRelation() {
		return (new SDominanceRelationImpl(createRelation()));
	}

	@Override
	public SPointingRelation createSPointingRelation() {
		return (new SPointingRelationImpl(createRelation()));
	}

	@Override
	public SOrderRelation createSOrderRelation() {
		return (new SOrderRelationImpl(createRelation()));
	}

	@Override
	public STextualRelation createSTextualRelation() {
		return (new STextualRelationImpl(createRelation()));
	}

	@Override
	public STimelineRelation createSTimelineRelation() {
		return (new STimelineRelationImpl(createRelation()));
	}

	@Override
	public SMedialRelation createSMedialRelation() {
		return (new SMedialRelationImpl(createRelation()));
	}

	@Override
	public SSpan createSSpan() {
		return (new SSpanImpl(createNode()));
	}

	@Override
	public SStructure createSStructure() {
		return (new SStructureImpl(createNode()));
	}

	@Override
	public STextualDS createSTextualDS() {
		return (new STextualDSImpl(createNode()));
	}

	@Override
	public SMedialDS createSMedialDS() {
		return (new SMedialDSImpl(createNode()));
	}

	@Override
	public STimeline createSTimeline() {
		return (new STimelineImpl(createNode()));
	}

	// ==========================================< salt common
	// ==========================================> salt semantics

	@Override
	public SCatAnnotation createSCatAnnotation() {
		return (new SCatAnnotationImpl(createLabel()));
	}

	@Override
	public SPOSAnnotation createSPOSAnnotation() {
		return (new SPOSAnnotationImpl(createLabel()));
	}

	@Override
	public SLemmaAnnotation createSLemmaAnnotation() {
		return (new SLemmaAnnotationImpl(createLabel()));
	}

	@Override
	public STypeAnnotation createSTypeAnnotation() {
		return (new STypeAnnotationImpl(createLabel()));
	}

	@Override
	public SWordAnnotation createSWordAnnotation() {
		return (new SWordAnnotationImpl(createLabel()));
	}

	@Override
	public SSentenceAnnotation createSSentenceAnnotation() {
		return (new SSentenceAnnotationImpl(createLabel()));
	}
	// ==========================================< salt semantics
}