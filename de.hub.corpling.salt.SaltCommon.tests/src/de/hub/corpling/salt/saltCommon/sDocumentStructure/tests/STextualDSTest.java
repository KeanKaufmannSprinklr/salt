/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.tests;

import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>STextual DS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#getSText() <em>SText</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#getSDocumentGraph() <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class STextualDSTest extends SSequentialDSTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(STextualDSTest.class);
	}

	/**
	 * Constructs a new STextual DS test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STextualDSTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this STextual DS test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected STextualDS getFixture() {
		return (STextualDS)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SDocumentStructureFactory.eINSTANCE.createSTextualDS());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#getSText() <em>SText</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#getSText()
	 */
	public void testGetSText() 
	{
		String text= "text";
		this.getFixture().setSText(text);
		assertEquals(text, this.getFixture().getSText());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#setSText(java.lang.String) <em>SText</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#setSText(java.lang.String)
	 */
	public void testSetSText() 
	{
		this.testGetSText();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph() <em>SDocument Graph</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph()
	 */
	public void testGetSDocumentGraph() 
	{
		SDocumentGraph sSDocumentGraph= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		this.getFixture().setSDocumentGraph(sSDocumentGraph);
		assertEquals(sSDocumentGraph, this.getFixture().getSDocumentGraph());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#setSDocumentGraph(de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph) <em>SDocument Graph</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#setSDocumentGraph(de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph)
	 */
	public void testSetSDocumentGraph() 
	{
		this.testGetSDocumentGraph();
	}

} //STextualDSTest