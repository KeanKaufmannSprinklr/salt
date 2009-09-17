/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure;

import de.hub.corpling.salt.saltCore.SaltCorePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory
 * @model kind="package"
 * @generated
 */
public interface SDocumentStructurePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sDocumentStructure";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "sDocumentStructure";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sDocumentStructure";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SDocumentStructurePackage eINSTANCE = de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl <em>SDocument Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSDocumentGraph()
	 * @generated
	 */
	int SDOCUMENT_GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__LABELS = SaltCorePackage.SGRAPH__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__ID = SaltCorePackage.SGRAPH__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__IDENTIFIER = SaltCorePackage.SGRAPH__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Index Mgr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__INDEX_MGR = SaltCorePackage.SGRAPH__INDEX_MGR;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__NODES = SaltCorePackage.SGRAPH__NODES;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__EDGES = SaltCorePackage.SGRAPH__EDGES;

	/**
	 * The feature id for the '<em><b>Num Of Nodes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__NUM_OF_NODES = SaltCorePackage.SGRAPH__NUM_OF_NODES;

	/**
	 * The feature id for the '<em><b>Num Of Edges</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__NUM_OF_EDGES = SaltCorePackage.SGRAPH__NUM_OF_EDGES;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SNAME = SaltCorePackage.SGRAPH__SNAME;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SANNOTATIONS = SaltCorePackage.SGRAPH__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SELEMENT_ID = SaltCorePackage.SGRAPH__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SID = SaltCorePackage.SGRAPH__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SELEMENT_PATH = SaltCorePackage.SGRAPH__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SPROCESSING_ANNOTATIONS = SaltCorePackage.SGRAPH__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SFEATURES = SaltCorePackage.SGRAPH__SFEATURES;

	/**
	 * The feature id for the '<em><b>SRelations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SRELATIONS = SaltCorePackage.SGRAPH__SRELATIONS;

	/**
	 * The feature id for the '<em><b>SNodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SNODES = SaltCorePackage.SGRAPH__SNODES;

	/**
	 * The feature id for the '<em><b>SDocument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SDOCUMENT = SaltCorePackage.SGRAPH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>STextual DSs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__STEXTUAL_DSS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>STextual Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__STEXTUAL_RELATIONS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>STokens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__STOKENS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>STimeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__STIMELINE = SaltCorePackage.SGRAPH_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>SDocument Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH_FEATURE_COUNT = SaltCorePackage.SGRAPH_FEATURE_COUNT + 5;


	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl <em>SSequential DS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSequentialDS()
	 * @generated
	 */
	int SSEQUENTIAL_DS = 5;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__LABELS = SaltCorePackage.SNODE__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__ID = SaltCorePackage.SNODE__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__IDENTIFIER = SaltCorePackage.SNODE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__GRAPH = SaltCorePackage.SNODE__GRAPH;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SANNOTATIONS = SaltCorePackage.SNODE__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SNAME = SaltCorePackage.SNODE__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SELEMENT_ID = SaltCorePackage.SNODE__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SID = SaltCorePackage.SNODE__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SELEMENT_PATH = SaltCorePackage.SNODE__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SPROCESSING_ANNOTATIONS = SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SFEATURES = SaltCorePackage.SNODE__SFEATURES;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SGRAPH = SaltCorePackage.SNODE__SGRAPH;

	/**
	 * The feature id for the '<em><b>SData</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SDATA = SaltCorePackage.SNODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SSequential DS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS_FEATURE_COUNT = SaltCorePackage.SNODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl <em>STextual DS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTextualDS()
	 * @generated
	 */
	int STEXTUAL_DS = 1;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__LABELS = SSEQUENTIAL_DS__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__ID = SSEQUENTIAL_DS__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__IDENTIFIER = SSEQUENTIAL_DS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__GRAPH = SSEQUENTIAL_DS__GRAPH;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SANNOTATIONS = SSEQUENTIAL_DS__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SNAME = SSEQUENTIAL_DS__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SELEMENT_ID = SSEQUENTIAL_DS__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SID = SSEQUENTIAL_DS__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SELEMENT_PATH = SSEQUENTIAL_DS__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SPROCESSING_ANNOTATIONS = SSEQUENTIAL_DS__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SFEATURES = SSEQUENTIAL_DS__SFEATURES;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SGRAPH = SSEQUENTIAL_DS__SGRAPH;

	/**
	 * The feature id for the '<em><b>SData</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SDATA = SSEQUENTIAL_DS__SDATA;

	/**
	 * The feature id for the '<em><b>SText</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__STEXT = SSEQUENTIAL_DS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SDOCUMENT_GRAPH = SSEQUENTIAL_DS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>STextual DS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS_FEATURE_COUNT = SSEQUENTIAL_DS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STokenImpl <em>SToken</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STokenImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSToken()
	 * @generated
	 */
	int STOKEN = 2;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__LABELS = SaltCorePackage.SNODE__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__ID = SaltCorePackage.SNODE__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__IDENTIFIER = SaltCorePackage.SNODE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__GRAPH = SaltCorePackage.SNODE__GRAPH;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SANNOTATIONS = SaltCorePackage.SNODE__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SNAME = SaltCorePackage.SNODE__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SELEMENT_ID = SaltCorePackage.SNODE__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SID = SaltCorePackage.SNODE__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SELEMENT_PATH = SaltCorePackage.SNODE__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SPROCESSING_ANNOTATIONS = SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SFEATURES = SaltCorePackage.SNODE__SFEATURES;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SGRAPH = SaltCorePackage.SNODE__SGRAPH;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SDOCUMENT_GRAPH = SaltCorePackage.SNODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SToken</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN_FEATURE_COUNT = SaltCorePackage.SNODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialRelationImpl <em>SSequential Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialRelationImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSequentialRelation()
	 * @generated
	 */
	int SSEQUENTIAL_RELATION = 4;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl <em>STextual Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTextualRelation()
	 * @generated
	 */
	int STEXTUAL_RELATION = 3;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__LABELS = SaltCorePackage.SRELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__ID = SaltCorePackage.SRELATION__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__IDENTIFIER = SaltCorePackage.SRELATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__GRAPH = SaltCorePackage.SRELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SOURCE = SaltCorePackage.SRELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__TARGET = SaltCorePackage.SRELATION__TARGET;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SNAME = SaltCorePackage.SRELATION__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SELEMENT_ID = SaltCorePackage.SRELATION__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SID = SaltCorePackage.SRELATION__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SELEMENT_PATH = SaltCorePackage.SRELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SPROCESSING_ANNOTATIONS = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SSOURCE = SaltCorePackage.SRELATION__SSOURCE;

	/**
	 * The feature id for the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__STARGET = SaltCorePackage.SRELATION__STARGET;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>SStart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SSTART = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SEnd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SEND = SaltCorePackage.SRELATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SSequential Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__LABELS = SSEQUENTIAL_RELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__ID = SSEQUENTIAL_RELATION__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__IDENTIFIER = SSEQUENTIAL_RELATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__GRAPH = SSEQUENTIAL_RELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SOURCE = SSEQUENTIAL_RELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__TARGET = SSEQUENTIAL_RELATION__TARGET;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SANNOTATIONS = SSEQUENTIAL_RELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SNAME = SSEQUENTIAL_RELATION__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SELEMENT_ID = SSEQUENTIAL_RELATION__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SID = SSEQUENTIAL_RELATION__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SELEMENT_PATH = SSEQUENTIAL_RELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SPROCESSING_ANNOTATIONS = SSEQUENTIAL_RELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SFEATURES = SSEQUENTIAL_RELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SSOURCE = SSEQUENTIAL_RELATION__SSOURCE;

	/**
	 * The feature id for the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__STARGET = SSEQUENTIAL_RELATION__STARGET;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SGRAPH = SSEQUENTIAL_RELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>SStart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SSTART = SSEQUENTIAL_RELATION__SSTART;

	/**
	 * The feature id for the '<em><b>SEnd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SEND = SSEQUENTIAL_RELATION__SEND;

	/**
	 * The feature id for the '<em><b>SToken</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__STOKEN = SSEQUENTIAL_RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>STextual DS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__STEXTUAL_DS = SSEQUENTIAL_RELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SDOCUMENT_GRAPH = SSEQUENTIAL_RELATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>STextual Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION_FEATURE_COUNT = SSEQUENTIAL_RELATION_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineImpl <em>STimeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTimeline()
	 * @generated
	 */
	int STIMELINE = 6;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__LABELS = SSEQUENTIAL_DS__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__ID = SSEQUENTIAL_DS__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__IDENTIFIER = SSEQUENTIAL_DS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__GRAPH = SSEQUENTIAL_DS__GRAPH;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SANNOTATIONS = SSEQUENTIAL_DS__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SNAME = SSEQUENTIAL_DS__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SELEMENT_ID = SSEQUENTIAL_DS__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SID = SSEQUENTIAL_DS__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SELEMENT_PATH = SSEQUENTIAL_DS__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SPROCESSING_ANNOTATIONS = SSEQUENTIAL_DS__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SFEATURES = SSEQUENTIAL_DS__SFEATURES;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SGRAPH = SSEQUENTIAL_DS__SGRAPH;

	/**
	 * The feature id for the '<em><b>SData</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SDATA = SSEQUENTIAL_DS__SDATA;

	/**
	 * The feature id for the '<em><b>SPoints Of Time</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SPOINTS_OF_TIME = SSEQUENTIAL_DS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SDOCUMENT_GRAPH = SSEQUENTIAL_DS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>STimeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_FEATURE_COUNT = SSEQUENTIAL_DS_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SDocument Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph
	 * @generated
	 */
	EClass getSDocumentGraph();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDocument <em>SDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SDocument</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDocument()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_SDocument();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs <em>STextual DSs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>STextual DSs</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STextualDSs();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations <em>STextual Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>STextual Relations</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STextualRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens <em>STokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>STokens</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STokens();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline <em>STimeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>STimeline</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STimeline();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS <em>STextual DS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STextual DS</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS
	 * @generated
	 */
	EClass getSTextualDS();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#getSText <em>SText</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SText</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#getSText()
	 * @see #getSTextualDS()
	 * @generated
	 */
	EAttribute getSTextualDS_SText();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#getSDocumentGraph()
	 * @see #getSTextualDS()
	 * @generated
	 */
	EReference getSTextualDS_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken <em>SToken</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SToken</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken
	 * @generated
	 */
	EClass getSToken();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken#getSDocumentGraph()
	 * @see #getSToken()
	 * @generated
	 */
	EReference getSToken_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation <em>STextual Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STextual Relation</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation
	 * @generated
	 */
	EClass getSTextualRelation();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSToken <em>SToken</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SToken</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSToken()
	 * @see #getSTextualRelation()
	 * @generated
	 */
	EReference getSTextualRelation_SToken();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSTextualDS <em>STextual DS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>STextual DS</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSTextualDS()
	 * @see #getSTextualRelation()
	 * @generated
	 */
	EReference getSTextualRelation_STextualDS();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph()
	 * @see #getSTextualRelation()
	 * @generated
	 */
	EReference getSTextualRelation_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation <em>SSequential Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SSequential Relation</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation
	 * @generated
	 */
	EClass getSSequentialRelation();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSStart <em>SStart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SStart</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSStart()
	 * @see #getSSequentialRelation()
	 * @generated
	 */
	EAttribute getSSequentialRelation_SStart();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSEnd <em>SEnd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SEnd</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSEnd()
	 * @see #getSSequentialRelation()
	 * @generated
	 */
	EAttribute getSSequentialRelation_SEnd();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS <em>SSequential DS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SSequential DS</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS
	 * @generated
	 */
	EClass getSSequentialDS();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS#getSData <em>SData</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SData</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS#getSData()
	 * @see #getSSequentialDS()
	 * @generated
	 */
	EAttribute getSSequentialDS_SData();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline <em>STimeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STimeline</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline
	 * @generated
	 */
	EClass getSTimeline();

	/**
	 * Returns the meta object for the attribute list '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline#getSPointsOfTime <em>SPoints Of Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>SPoints Of Time</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline#getSPointsOfTime()
	 * @see #getSTimeline()
	 * @generated
	 */
	EAttribute getSTimeline_SPointsOfTime();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SDocument Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline#getSDocumentGraph()
	 * @see #getSTimeline()
	 * @generated
	 */
	EReference getSTimeline_SDocumentGraph();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SDocumentStructureFactory getSDocumentStructureFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl <em>SDocument Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSDocumentGraph()
		 * @generated
		 */
		EClass SDOCUMENT_GRAPH = eINSTANCE.getSDocumentGraph();

		/**
		 * The meta object literal for the '<em><b>SDocument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__SDOCUMENT = eINSTANCE.getSDocumentGraph_SDocument();

		/**
		 * The meta object literal for the '<em><b>STextual DSs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__STEXTUAL_DSS = eINSTANCE.getSDocumentGraph_STextualDSs();

		/**
		 * The meta object literal for the '<em><b>STextual Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__STEXTUAL_RELATIONS = eINSTANCE.getSDocumentGraph_STextualRelations();

		/**
		 * The meta object literal for the '<em><b>STokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__STOKENS = eINSTANCE.getSDocumentGraph_STokens();

		/**
		 * The meta object literal for the '<em><b>STimeline</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__STIMELINE = eINSTANCE.getSDocumentGraph_STimeline();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl <em>STextual DS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTextualDS()
		 * @generated
		 */
		EClass STEXTUAL_DS = eINSTANCE.getSTextualDS();

		/**
		 * The meta object literal for the '<em><b>SText</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEXTUAL_DS__STEXT = eINSTANCE.getSTextualDS_SText();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEXTUAL_DS__SDOCUMENT_GRAPH = eINSTANCE.getSTextualDS_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STokenImpl <em>SToken</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STokenImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSToken()
		 * @generated
		 */
		EClass STOKEN = eINSTANCE.getSToken();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STOKEN__SDOCUMENT_GRAPH = eINSTANCE.getSToken_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl <em>STextual Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTextualRelation()
		 * @generated
		 */
		EClass STEXTUAL_RELATION = eINSTANCE.getSTextualRelation();

		/**
		 * The meta object literal for the '<em><b>SToken</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEXTUAL_RELATION__STOKEN = eINSTANCE.getSTextualRelation_SToken();

		/**
		 * The meta object literal for the '<em><b>STextual DS</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEXTUAL_RELATION__STEXTUAL_DS = eINSTANCE.getSTextualRelation_STextualDS();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEXTUAL_RELATION__SDOCUMENT_GRAPH = eINSTANCE.getSTextualRelation_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialRelationImpl <em>SSequential Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialRelationImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSequentialRelation()
		 * @generated
		 */
		EClass SSEQUENTIAL_RELATION = eINSTANCE.getSSequentialRelation();

		/**
		 * The meta object literal for the '<em><b>SStart</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SSEQUENTIAL_RELATION__SSTART = eINSTANCE.getSSequentialRelation_SStart();

		/**
		 * The meta object literal for the '<em><b>SEnd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SSEQUENTIAL_RELATION__SEND = eINSTANCE.getSSequentialRelation_SEnd();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl <em>SSequential DS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSequentialDS()
		 * @generated
		 */
		EClass SSEQUENTIAL_DS = eINSTANCE.getSSequentialDS();

		/**
		 * The meta object literal for the '<em><b>SData</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SSEQUENTIAL_DS__SDATA = eINSTANCE.getSSequentialDS_SData();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineImpl <em>STimeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTimeline()
		 * @generated
		 */
		EClass STIMELINE = eINSTANCE.getSTimeline();

		/**
		 * The meta object literal for the '<em><b>SPoints Of Time</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STIMELINE__SPOINTS_OF_TIME = eINSTANCE.getSTimeline_SPointsOfTime();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STIMELINE__SDOCUMENT_GRAPH = eINSTANCE.getSTimeline_SDocumentGraph();

	}

} //SDocumentStructurePackage
