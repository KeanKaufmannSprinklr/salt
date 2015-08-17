package de.hu_berlin.u.saltnpepper.salt.core.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import de.hu_berlin.u.saltnpepper.graph.impl.GraphImpl;
import de.hu_berlin.u.saltnpepper.salt.core.GraphTraverseHandler;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SMetaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SProcessingAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.util.SAnnotationContainerHelper;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

@SuppressWarnings("serial")
public class SGraphImpl extends GraphImpl<SNode, SRelation<SNode, SNode>> implements SGraph {

	/** {@inheritDoc} */
	@Override
	public List<SNode> getRoots() {
		List<SNode> retList = new ArrayList<>();
		if (this.getNodes().size() == 1) {
			// if corpusGraph only contains one corpus it shall not need to be
			// traversed
			retList.add(this.getNodes().get(0));
		} else {
			for (SNode node : Collections.synchronizedCollection(this.getNodes())) {
				// checking if node has incoming edges
				List<SRelation<SNode, SNode>> inEdges = getInRelations(node.getId());
				if ((inEdges == null) || (inEdges.size() == 0)) {
					retList.add(node);
				}
			}
		}
		if (retList.size() == 0)
			retList = null;
		return (retList);
	}

	/** {@inheritDoc} */
	@Override
	public List<SNode> getLeafs() {
		List<SNode> retList = new ArrayList<>();
		if (this.getNodes().size() == 1) {
			// if corpusGraph only contains one corpus it shall not need to
			// be traversed
			retList.add(this.getNodes().get(0));
		} else {
			for (SNode node : Collections.synchronizedCollection(this.getNodes())) {
				// checking if node has outgoing edges
				List<SRelation<SNode, SNode>> outEdges = getOutRelations(node.getId());
				if ((outEdges == null) || (outEdges.size() == 0)) {
					retList.add(node);
				}
			}
		}
		if (retList.size() == 0)
			retList = null;
		return (retList);
	}

	/** {@inheritDoc} */
	@Override
	public void traverse(List<SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, GraphTraverseHandler traverseHandler) {
		this.traverse(startNodes, traverseType, traverseId, traverseHandler, true);
	}

	/** {@inheritDoc} */
	@Override
	public void traverse(List<SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, GraphTraverseHandler traverseHandler, boolean isCycleSafe) {
		GraphTraverserModule traverserModule = new GraphTraverserModule();
		traverserModule.setGraph(this);
		traverserModule.traverse(startNodes, traverseType, traverseId, traverseHandler, isCycleSafe);
	}

	// =======================================> SNamedElement
	@Override
	public void removeLabel(String qName) {
		if (SaltUtil.KW_QNAME_NAME.equals(qName)) {
			name = null;
		}
		super.removeLabel(qName);
	}

	/** The feature object containing the name of the node **/
	protected SFeature name = null;

	/** {@inheritDoc} **/
	@Override
	public String getName() {
		if (name == null) {
			SFeature feature = getFeature(SaltUtil.KW_QNAME_NAME);
			if (feature != null) {
				name = feature;
			}
			if (name == null) {
				return (null);
			}
		}
		return (name.getValue_STEXT());
	}

	/** {@inheritDoc} **/
	@Override
	public void setName(String name) {
		if (this.name == null) {
			this.name = createFeature(SaltUtil.SALT_NAMESPACE, SaltUtil.KW_NAME, null);
		}
		this.name.setValue(name);
	}

	// =======================================< SNamedElement

	// =======================================> SAnnotation
	/** {@inheritDoc} **/
	@Override
	public SAnnotation createAnnotation(String namespace, String name, Object value) {
		return (SAnnotationContainerHelper.createAnnotation(this, namespace, name, value));
	}

	/** {@inheritDoc} **/
	@Override
	public Set<SAnnotation> createAnnotations(String annotationString) {
		return (SAnnotationContainerHelper.createAnnotations(this, annotationString));
	}

	/** {@inheritDoc} **/
	@Override
	public void addAnnotation(SAnnotation annotation) {
		SAnnotationContainerHelper.addAnnotation(this, annotation);
	}

	/** {@inheritDoc} **/
	@Override
	public <A extends SAnnotation> Set<A> getAnnotations() {
		return (SAnnotationContainerHelper.getAnnotations(this));
	}

	/** {@inheritDoc} **/
	@Override
	public SAnnotation getAnnotation(String qName) {
		return (SAnnotationContainerHelper.getAnnotation(this, qName));
	}

	/** {@inheritDoc} **/
	@Override
	public Iterator<SAnnotation> iterator_SAnnotation() {
		return (SAnnotationContainerHelper.iterator_SAnnotation(this));
	}

	// =======================================< SAnnotation

	// =======================================> SMetaAnnotation
	/** {@inheritDoc} **/
	@Override
	public void addMetaAnnotation(SMetaAnnotation metaAnnotation) {
		SAnnotationContainerHelper.addMetaAnnotation(this, metaAnnotation);
	}

	/** {@inheritDoc} **/
	@Override
	public SMetaAnnotation createMetaAnnotation(String namespace, String name, Object value) {
		return (SAnnotationContainerHelper.createMetaAnnotation(this, namespace, name, value));
	}

	/** {@inheritDoc} **/
	@Override
	public Set<SMetaAnnotation> createMetaAnnotations(String annotationString) {
		return (SAnnotationContainerHelper.createMetaAnnotations(this, annotationString));
	}

	@Override
	public <A extends SMetaAnnotation> Set<A> getMetaAnnotations() {
		return (SAnnotationContainerHelper.getMetaAnnotations(this));
	}

	@Override
	public SMetaAnnotation getMetaAnnotation(String qName) {
		return (SAnnotationContainerHelper.getMetaAnnotation(this, qName));
	}

	@Override
	public Iterator<SMetaAnnotation> iterator_SMetaAnnotation() {
		return (SAnnotationContainerHelper.iterator_SMetaAnnotation(this));
	}

	// =======================================< SMetaAnnotation
	// =======================================> SProcessingAnnotation
	/** {@inheritDoc} **/
	@Override
	public SProcessingAnnotation createProcessingAnnotation(String namespace, String name, Object value) {
		return (SAnnotationContainerHelper.createProcessingAnnotation(this, namespace, name, value));
	}

	/** {@inheritDoc} **/
	@Override
	public Set<SProcessingAnnotation> createProcessingAnnotations(String annotationString) {
		return (SAnnotationContainerHelper.createProcessingAnnotations(this, annotationString));
	}

	/** {@inheritDoc} **/
	@Override
	public void addProcessingAnnotation(SProcessingAnnotation annotation) {
		SAnnotationContainerHelper.addProcessingAnnotation(this, annotation);
	}

	/** {@inheritDoc} **/
	@Override
	public <A extends SProcessingAnnotation> Set<A> getProcessingAnnotations() {
		return (SAnnotationContainerHelper.getProcessingAnnotations(this));
	}

	/** {@inheritDoc} **/
	@Override
	public SProcessingAnnotation getProcessingAnnotation(String qName) {
		return (SAnnotationContainerHelper.getProcessingAnnotation(this, qName));
	}

	/** {@inheritDoc} **/
	@Override
	public Iterator<SProcessingAnnotation> iterator_SProcessingAnnotation() {
		return (SAnnotationContainerHelper.iterator_SProcessingAnnotation(this));
	}

	// =======================================< SProcessingAnnotation
	// =======================================> SFeature
	/** {@inheritDoc} **/
	@Override
	public SFeature createFeature(String namespace, String name, Object value) {
		return (SAnnotationContainerHelper.createFeature(this, namespace, name, value));
	}

	/** {@inheritDoc} **/
	@Override
	public Set<SFeature> createFeatures(String featureString) {
		return (SAnnotationContainerHelper.createFeatures(this, featureString));
	}

	/** {@inheritDoc} **/
	@Override
	public void addFeature(SFeature feature) {
		SAnnotationContainerHelper.addFeature(this, feature);
	}

	/** {@inheritDoc} **/
	@Override
	public <A extends SFeature> Set<A> getFeatures() {
		return (SAnnotationContainerHelper.getFeatures(this));
	}

	/** {@inheritDoc} **/
	@Override
	public SFeature getFeature(String qName) {
		return (SAnnotationContainerHelper.getFeature(this, qName));
	}

	/** {@inheritDoc} **/
	@Override
	public Iterator<SFeature> iterator_SFeature() {
		return (SAnnotationContainerHelper.iterator_SFeature(this));
	}

	// =======================================< SFeature
}
