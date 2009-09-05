/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.impl;

import de.hub.corpling.salt.saltCore.SAnnotatableElement;
import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SGraph;
import de.hub.corpling.salt.saltCore.SIdentifiableElement;
import de.hub.corpling.salt.saltCore.SNamedElement;
import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SRelation;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SaltCorePackageImpl extends EPackageImpl implements SaltCorePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sAnnotatableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sIdentifiableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sElementIdEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SaltCorePackageImpl() {
		super(eNS_URI, SaltCoreFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SaltCorePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SaltCorePackage init() {
		if (isInited) return (SaltCorePackage)EPackage.Registry.INSTANCE.getEPackage(SaltCorePackage.eNS_URI);

		// Obtain or create and register package
		SaltCorePackageImpl theSaltCorePackage = (SaltCorePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SaltCorePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SaltCorePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theSaltCorePackage.createPackageContents();

		// Initialize created meta-data
		theSaltCorePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSaltCorePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SaltCorePackage.eNS_URI, theSaltCorePackage);
		return theSaltCorePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSNode() {
		return sNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSNode_SGraph() {
		return (EReference)sNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSRelation() {
		return sRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSRelation_SourceSNode() {
		return (EReference)sRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSRelation_TargetSNode() {
		return (EReference)sRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSRelation_SGraph() {
		return (EReference)sRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSAnnotatableElement() {
		return sAnnotatableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSAnnotatableElement_SAnnotations() {
		return (EReference)sAnnotatableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSAnnotation() {
		return sAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSAnnotation_SName() {
		return (EAttribute)sAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSAnnotation_SValue() {
		return (EAttribute)sAnnotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSAnnotation_SAnnotatbaleElement() {
		return (EReference)sAnnotationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSGraph() {
		return sGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSGraph_SRelations() {
		return (EReference)sGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSGraph_SNodes() {
		return (EReference)sGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSNamedElement() {
		return sNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSNamedElement_Name() {
		return (EAttribute)sNamedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSIdentifiableElement() {
		return sIdentifiableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSIdentifiableElement_SElementId() {
		return (EReference)sIdentifiableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSElementId() {
		return sElementIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSElementId_SId() {
		return (EAttribute)sElementIdEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSElementId_SIdentifiableElement() {
		return (EReference)sElementIdEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSElementId_SElementPath() {
		return (EAttribute)sElementIdEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltCoreFactory getSaltCoreFactory() {
		return (SaltCoreFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		sNodeEClass = createEClass(SNODE);
		createEReference(sNodeEClass, SNODE__SGRAPH);

		sRelationEClass = createEClass(SRELATION);
		createEReference(sRelationEClass, SRELATION__SOURCE_SNODE);
		createEReference(sRelationEClass, SRELATION__TARGET_SNODE);
		createEReference(sRelationEClass, SRELATION__SGRAPH);

		sAnnotatableElementEClass = createEClass(SANNOTATABLE_ELEMENT);
		createEReference(sAnnotatableElementEClass, SANNOTATABLE_ELEMENT__SANNOTATIONS);

		sAnnotationEClass = createEClass(SANNOTATION);
		createEAttribute(sAnnotationEClass, SANNOTATION__SNAME);
		createEAttribute(sAnnotationEClass, SANNOTATION__SVALUE);
		createEReference(sAnnotationEClass, SANNOTATION__SANNOTATBALE_ELEMENT);

		sGraphEClass = createEClass(SGRAPH);
		createEReference(sGraphEClass, SGRAPH__SRELATIONS);
		createEReference(sGraphEClass, SGRAPH__SNODES);

		sNamedElementEClass = createEClass(SNAMED_ELEMENT);
		createEAttribute(sNamedElementEClass, SNAMED_ELEMENT__NAME);

		sIdentifiableElementEClass = createEClass(SIDENTIFIABLE_ELEMENT);
		createEReference(sIdentifiableElementEClass, SIDENTIFIABLE_ELEMENT__SELEMENT_ID);

		sElementIdEClass = createEClass(SELEMENT_ID);
		createEAttribute(sElementIdEClass, SELEMENT_ID__SID);
		createEReference(sElementIdEClass, SELEMENT_ID__SIDENTIFIABLE_ELEMENT);
		createEAttribute(sElementIdEClass, SELEMENT_ID__SELEMENT_PATH);

		// Create data types
		uriEDataType = createEDataType(URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sNodeEClass.getESuperTypes().add(this.getSAnnotatableElement());
		sNodeEClass.getESuperTypes().add(this.getSNamedElement());
		sNodeEClass.getESuperTypes().add(this.getSIdentifiableElement());
		sRelationEClass.getESuperTypes().add(this.getSAnnotatableElement());
		sRelationEClass.getESuperTypes().add(this.getSNamedElement());
		sRelationEClass.getESuperTypes().add(this.getSIdentifiableElement());
		sGraphEClass.getESuperTypes().add(this.getSNamedElement());
		sGraphEClass.getESuperTypes().add(this.getSAnnotatableElement());
		sGraphEClass.getESuperTypes().add(this.getSIdentifiableElement());

		// Initialize classes and features; add operations and parameters
		initEClass(sNodeEClass, SNode.class, "SNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSNode_SGraph(), this.getSGraph(), this.getSGraph_SNodes(), "sGraph", null, 0, 1, SNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sRelationEClass, SRelation.class, "SRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSRelation_SourceSNode(), this.getSNode(), null, "sourceSNode", null, 0, 1, SRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSRelation_TargetSNode(), this.getSNode(), null, "targetSNode", null, 0, 1, SRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSRelation_SGraph(), this.getSGraph(), this.getSGraph_SRelations(), "sGraph", null, 0, 1, SRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sAnnotatableElementEClass, SAnnotatableElement.class, "SAnnotatableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSAnnotatableElement_SAnnotations(), this.getSAnnotation(), this.getSAnnotation_SAnnotatbaleElement(), "sAnnotations", null, 0, -1, SAnnotatableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sAnnotationEClass, SAnnotation.class, "SAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSAnnotation_SName(), ecorePackage.getEString(), "SName", null, 0, 1, SAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSAnnotation_SValue(), ecorePackage.getEString(), "SValue", null, 0, 1, SAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSAnnotation_SAnnotatbaleElement(), this.getSAnnotatableElement(), this.getSAnnotatableElement_SAnnotations(), "sAnnotatbaleElement", null, 0, 1, SAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sGraphEClass, SGraph.class, "SGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSGraph_SRelations(), this.getSRelation(), this.getSRelation_SGraph(), "sRelations", null, 0, -1, SGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSGraph_SNodes(), this.getSNode(), this.getSNode_SGraph(), "sNodes", null, 0, -1, SGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sNamedElementEClass, SNamedElement.class, "SNamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, SNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sIdentifiableElementEClass, SIdentifiableElement.class, "SIdentifiableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSIdentifiableElement_SElementId(), this.getSElementId(), this.getSElementId_SIdentifiableElement(), "sElementId", null, 0, 1, SIdentifiableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sElementIdEClass, SElementId.class, "SElementId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSElementId_SId(), ecorePackage.getEString(), "sId", null, 0, 1, SElementId.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSElementId_SIdentifiableElement(), this.getSIdentifiableElement(), this.getSIdentifiableElement_SElementId(), "sIdentifiableElement", null, 0, 1, SElementId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSElementId_SElementPath(), this.getURI(), "sElementPath", null, 0, 1, SElementId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SaltCorePackageImpl
