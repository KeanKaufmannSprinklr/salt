package de.hu_berlin.u.saltnpepper.salt.impl;

import de.hu_berlin.u.saltnpepper.salt.ISaltFactory;
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

public class SaltFactoryImpl implements ISaltFactory{
	/**
	 * Creates a new {@link SGraph} object of type {@link SGraphImpl}.
	 * 
	 * @return new {@link SGraph} object
	 */
	public  SGraph createSGraph() {
		return (new SGraphImpl());
	}

	/**
	 * Creates a new {@link SNode} object of type {@link SNodeImpl}.
	 * 
	 * @return new {@link SNode} object
	 */
	public  SNode createSNode() {
		return (new SNodeImpl());
	}

	/**
	 * Creates a new {@link SRelation} object of type {@link SRelationImpl}.
	 * 
	 * @return new {@link SRelation} object
	 */
	public  SRelation<SNode, SNode> createSRelation() {
		return (new SRelationImpl<SNode, SNode>());
	}

	/**
	 * Creates a new {@link SAnnotation} object of type {@link SAnnotationImpl}.
	 * 
	 * @return new {@link SAnnotation} object
	 */
	public  SAnnotation createSAnnotation() {
		return (new SAnnotationImpl());
	}

	/**
	 * Creates a new {@link SMetaAnnotation} object of type
	 * {@link SMetaAnnotationImpl}.
	 * 
	 * @return new {@link SMetaAnnotation} object
	 */
	public  SMetaAnnotation createSMetaAnnotation() {
		return (new SMetaAnnotationImpl());
	}

	/**
	 * Creates a new {@link SProcessingAnnotation} object of type
	 * {@link SProcessingAnnotationImpl}.
	 * 
	 * @return new {@link SProcessingAnnotation} object
	 */
	public  SProcessingAnnotation createSProcessingAnnotation() {
		return (new SProcessingAnnotationImpl());
	}

	/**
	 * Creates a new {@link SFeature} object of type {@link SFeatureImpl}.
	 * 
	 * @return new {@link SFeature} object
	 */
	public  SFeature createSFeature() {
		return (new SFeatureImpl());
	}
	/**
	 * Creates a new {@link SLayer} object of type {@link SLayerImpl}.
	 * 
	 * @return new {@link SLayer} object
	 */
	public  SLayer createSLayer() {
		return (new SLayerImpl());
	}
}