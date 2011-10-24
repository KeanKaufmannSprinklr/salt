/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.xml.sax.SAXException;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SLemmaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SPOSAnnotation;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Salt Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSaltProject(org.eclipse.emf.common.util.URI) <em>Save Salt Project</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject(org.eclipse.emf.common.util.URI) <em>Load Salt Project</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject_GrAF(org.eclipse.emf.common.util.URI, java.util.Properties) <em>Load Salt Project Gr AF</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#differences(java.lang.Object) <em>Differences</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSCorpusGraph_GrAF(org.eclipse.emf.common.util.URI, java.util.Properties) <em>Load SCorpus Graph Gr AF</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSDocumentGraph_GrAF(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument, java.util.Properties) <em>Load SDocument Graph Gr AF</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSCorpusGraph_DOT(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId) <em>Save SCorpus Graph DOT</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSaltProject_DOT(org.eclipse.emf.common.util.URI) <em>Save Salt Project DOT</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSDocumentGraph_DOT(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId) <em>Save SDocument Graph DOT</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SaltProjectTest extends TestCase {

	/**
	 * The fixture for this Salt Project test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaltProject fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SaltProjectTest.class);
	}

	/**
	 * Constructs a new Salt Project test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltProjectTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Salt Project test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SaltProject fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Salt Project test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaltProject getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SaltCommonFactory.eINSTANCE.createSaltProject());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSaltProject(org.eclipse.emf.common.util.URI) <em>Save Salt Project</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSaltProject(org.eclipse.emf.common.util.URI)
	 */
	public void testSaveSaltProject__URI() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject(org.eclipse.emf.common.util.URI) <em>Load Salt Project</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject(org.eclipse.emf.common.util.URI)
	 */
	public void testLoadSaltProject__URI() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	String resourceDir= "./src/test/resources/SaltProjectTest/";
	String tmpDir= "./_TMP/";
	
	
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSaltProject(org.eclipse.emf.common.util.URI) <em>Save Salt Project</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws SAXException 
	 * @throws IOException 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSaltProject(org.eclipse.emf.common.util.URI)
	 */
	//TODO fixme
//	public void testSaveSaltProject__URI() throws IOException, SAXException 
//	{
//		this.testSaveSaltProject_CorpusGraph();
//		this.testSaveSaltProject_DocumentGraph();
//	}
	
	/**
	 * Tests following structure:
	 * 
	 * 				rootCorpus
	 * 		/					\
	 * 	subCorp1				subCorp2
	 * 	/		\				/		\
	 * doc1		doc2		doc3		doc4
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public void testSaveSaltProject_CorpusGraph() throws IOException, SAXException 
	{
		String saltProjectPathResource= resourceDir+"case1/";
		String saltProjectPathTMP= tmpDir+ "case1/";
		
		this.createCorpusStructure(this.getFixture());
		
		this.getFixture().saveSaltProject(URI.createFileURI(new File(saltProjectPathTMP).getAbsolutePath()));
		
		//compare directories via XMLUnit
		this.compareDirectories(new File(saltProjectPathTMP), new File(saltProjectPathResource));
	}
	
	
	/**
	 * This method creates the content of a document (the primary text, the tokenization and all structures and annotations above them) for 
	 * the given SDocument object.
	 * 
	 * primary text: 		Is this example more complicated than it appears to be?
	 * tokens:				{"Is", "this", "example", "more", "complicated", "than", "it", "appears", "to", "be"}
	 * anaphoric relation:	{"it"} --> {"this", "example"}
	 * 
	 * @param sDocument the document for which the structure has to be created.
	 */
	//TODO fixme
//	public void testSaveSaltProject_DocumentGraph() throws IOException, SAXException 
//	{
//		String saltProjectPathResource= resourceDir+"case2/";
//		String saltProjectPathTMP= tmpDir+ "case2/";
//		
//		//the object, which contains the primary data, the tokenization and all structures and annotations above them
//		SDocument sDoc= null;
//		
//		sDoc= this.createSimpleCorpusStructure(this.getFixture());
//		
////		{//creating the corpus-structure
////			SCorpusGraph sCorpGraph= SaltFactory.eINSTANCE.createSCorpusGraph();
////			this.getFixture().getSCorpusGraphs().add(sCorpGraph);
////			SCorpus sCorpus1= SaltFactory.eINSTANCE.createSCorpus();
////			sCorpus1.setSName("rootCorpus");
////			sCorpGraph.addSNode(sCorpus1);
////			
////			sDoc= SaltFactory.eINSTANCE.createSDocument();
////			sDoc.setSName("doc1");
////			sCorpGraph.addSDocument(sCorpus1, sDoc);
////			
////			//creating a graph containing the tokenization and all structures and annotations above them 
////			sDoc.setSDocumentGraph(SaltFactory.eINSTANCE.createSDocumentGraph());
////		}//creating the corpus-structure
//		
//		this.createSDocumentStructure(sDoc);
//		
//		{//storing the document
//			this.getFixture().saveSaltProject(URI.createFileURI(new File(saltProjectPathTMP).getAbsolutePath()));
//		}//storing the document
//		
//		//compare directories via XMLUnit
//		this.compareDirectories(new File(saltProjectPathTMP), new File(saltProjectPathResource));
//	}
	
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject(org.eclipse.emf.common.util.URI) <em>Load Salt Project</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject(org.eclipse.emf.common.util.URI)
	 */
	//TODO fixme
//	public void testLoadSaltProject__URI() 
//	{
//		this.testLoadSaltProject_CorpusGraph();
//		this.testLoadSaltProject_DocumentGraph();
//	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject_GrAF(org.eclipse.emf.common.util.URI, java.util.Properties) <em>Load Salt Project Gr AF</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject_GrAF(org.eclipse.emf.common.util.URI, java.util.Properties)
	 */
	public void testLoadSaltProject_GrAF__URI_Properties() {
//		// TODO: implement this operation test method
//		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject_GrAF(org.eclipse.emf.common.util.URI, java.util.Properties) <em>Load Salt Project From Gr AF</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws FileNotFoundException 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject_GrAF(org.eclipse.emf.common.util.URI, java.util.Properties)
	 */
	//TODO fixme
//	public void testLoadSaltProjectFromGrAF__URI_Properties() throws FileNotFoundException 
//	{
//		String saltProjectPathResource= resourceDir+"case3/";
//		File file= new File(saltProjectPathResource);
//		if (!file.exists())
//			throw new FileNotFoundException("Cannot run test, because file does not exists: "+ file.getAbsolutePath());
//		Properties props= new Properties();
//		props.put(GrAFResource.PROP_GRAF_HEADER_FILE_ENDING, "pdh");
//		props.put(GrAFResource.PROP_GRAF_LAYER_TO_TYPE+".is", GRAF_MAPPING_TYPE.POINTER);
//		props.put(GrAFResource.PROP_GRAF_LAYER_TO_TYPE+".xle", GRAF_MAPPING_TYPE.HIERARCHIE);
//		props.put(GrAFResource.PROP_GRAF_LAYER_TO_TYPE+".prosody", GRAF_MAPPING_TYPE.HIERARCHIE);
//
//		this.getFixture().loadSaltProject_GrAF(URI.createFileURI(file.getAbsolutePath()),props);
//		
//		assertEquals(1, this.getFixture().getSCorpusGraphs().size());
//		assertEquals(4, this.getFixture().getSCorpusGraphs().get(0).getSCorpora().size());
//		assertEquals(1, this.getFixture().getSCorpusGraphs().get(0).getSDocuments().size());
//		assertEquals(2, this.getFixture().getSCorpusGraphs().get(0).getSDocuments().get(0).getSDocumentGraph().getSTextualDSs().size());
//		assertNotNull(this.getFixture().getSCorpusGraphs().get(0).getSDocuments().get(0).getSDocumentGraph().getSTokens().size());
//		assertNotNull(this.getFixture().getSCorpusGraphs().get(0).getSDocuments().get(0).getSDocumentGraph().getSStructures().size());
//		assertNotNull(this.getFixture().getSCorpusGraphs().get(0).getSDocuments().get(0).getSDocumentGraph().getSPointingRelations().size());
//	}

		/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#differences(java.lang.Object) <em>Differences</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#differences(java.lang.Object)
	 */
	public void testDifferences__Object() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSCorpusGraph_GrAF(org.eclipse.emf.common.util.URI, java.util.Properties) <em>Load SCorpus Graph Gr AF</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSCorpusGraph_GrAF(org.eclipse.emf.common.util.URI, java.util.Properties)
	 */
	public void testLoadSCorpusGraph_GrAF__URI_Properties() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

		/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSDocumentGraph_GrAF(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument, java.util.Properties) <em>Load SDocument Graph Gr AF</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSDocumentGraph_GrAF(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument, java.util.Properties)
	 */
	public void testLoadSDocumentGraph_GrAF__URI_SDocument_Properties() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSCorpusGraph_DOT(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId) <em>Save SCorpus Graph DOT</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSCorpusGraph_DOT(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId)
	 */
	public void testSaveSCorpusGraph_DOT__URI_SElementId() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

		/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSaltProject_DOT(org.eclipse.emf.common.util.URI) <em>Save Salt Project DOT</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSaltProject_DOT(org.eclipse.emf.common.util.URI)
	 */
	public void testSaveSaltProject_DOT__URI() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

		/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSDocumentGraph_DOT(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId) <em>Save SDocument Graph DOT</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSDocumentGraph_DOT(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId)
	 */
	public void testSaveSDocumentGraph_DOT__URI_SElementId() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests following structure:
	 * 
	 * 				rootCorpus
	 * 		/					\
	 * 	subCorp1				subCorp2
	 * 	/		\				/		\
	 * doc1		doc2		doc3		doc4
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public void testLoadSaltProject_CorpusGraph() 
	{
		String saltProjectPathResource= resourceDir+"case1/";
		
		SaltProject saltProject2= SaltFactory.eINSTANCE.createSaltProject();
		this.createCorpusStructure(saltProject2);
				
		this.getFixture().loadSaltProject(URI.createFileURI(new File(saltProjectPathResource).getAbsolutePath()));
		
		assertEquals(saltProject2, this.getFixture());
	}

	/**
	 * This method creates the content of a document (the primary text, the tokenization and all structures and annotations above them) for 
	 * the given SDocument object.
	 * 
	 * primary text: 		Is this example more complicated than it appears to be?
	 * tokens:				{"Is", "this", "example", "more", "complicated", "than", "it", "appears", "to", "be"}
	 * anaphoric relation:	{"it"} --> {"this", "example"}
	 * 
	 * @param sDocument the document for which the structure has to be created.
	 */
	//TODO fixme
//	public void testLoadSaltProject_DocumentGraph() 
//	{
//		String saltProjectPathResource= resourceDir+"case2/";
//		
//		//the object, which contains the primary data, the tokenization and all structures and annotations above them
//		SDocument sDoc= null;
//		
//		SaltProject saltProject2= SaltFactory.eINSTANCE.createSaltProject();
//		sDoc= this.createSimpleCorpusStructure(saltProject2);
//		this.createSDocumentStructure(sDoc);
//		
//		System.out.println("Hello");
//		
//		for (SCorpusGraph sCorpusGraph: saltProject2.getSCorpusGraphs())
//		{
//			System.out.println(sCorpusGraph);
//			for (SCorpus sCorpus: sCorpusGraph.getSCorpora())
//			{
//				System.out.println(sCorpus);
//			}
//			for (SDocument sDocument: sCorpusGraph.getSDocuments())
//			{
//				System.out.println(sDocument.getSDocumentGraph());
//			}
//		}
//		
//		this.getFixture().loadSaltProject(URI.createFileURI(new File(saltProjectPathResource).getAbsolutePath()));
//		
//		System.out.println("------------- fixture");
//		for (SCorpusGraph sCorpusGraph: this.getFixture().getSCorpusGraphs())
//		{
//			System.out.println(sCorpusGraph);
//			for (SCorpus sCorpus: sCorpusGraph.getSCorpora())
//			{
//				System.out.println(sCorpus);
//			}
//			for (SDocument sDocument: sCorpusGraph.getSDocuments())
//			{
//				System.out.println(sDocument.getSDocumentGraph());
//			}
//		}
//		System.out.println("------------- go on");
//		System.out.println(this.getFixture().getSCorpusGraphs().get(0));
//		System.out.println(this.getFixture().getSCorpusGraphs().get(0).getSDocuments().get(0));
//		
//		System.out.println("tokens: "+ this.getFixture().getSCorpusGraphs().get(0).getSDocuments().get(0).getSDocumentGraph().getSTokens());
//		//TODO go on with implementing method differences until the difference between both SaltProjects is found
//		System.out.println("----------------------- start differences -----------------------");
//		System.out.println(saltProject2.differences(this.getFixture()));
//		System.out.println("----------------------- end differences -----------------------");
//		System.out.println("assertEquals");
//		
//		assertEquals(saltProject2, this.getFixture());
//	}

	public void testSCorpusGraphs()
	{
		EList<SCorpusGraph> corpGraphs= new BasicEList<SCorpusGraph>();
		for (int i= 0; i < 10; i++)
		{
			SCorpusGraph corpGraph= SaltCommonFactory.eINSTANCE.createSCorpusGraph();
			corpGraphs.add(corpGraph);
			this.getFixture().getSCorpusGraphs().add(corpGraph);
		}
		
		assertTrue(corpGraphs.containsAll(this.getFixture().getSCorpusGraphs()));
		assertTrue(this.getFixture().getSCorpusGraphs().containsAll(corpGraphs));
	}
	
	/**
	 * Tests following structure:
	 * 
	 * 	rootCorpus
	 * 		|
	 * 		doc1
	 * 	
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public SDocument createSimpleCorpusStructure(SaltProject saltProject) 
	{
		SCorpusGraph sCorpGraph= SaltFactory.eINSTANCE.createSCorpusGraph();
		saltProject.getSCorpusGraphs().add(sCorpGraph);
		SCorpus sCorpus1= SaltFactory.eINSTANCE.createSCorpus();
		sCorpus1.setSName("rootCorpus");
		sCorpGraph.addSNode(sCorpus1);
		
		SDocument sDoc= null;
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc1");
		sCorpGraph.addSDocument(sCorpus1, sDoc);
		
		//creating a graph containing the tokenization and all structures and annotations above them 
		sDoc.setSDocumentGraph(SaltFactory.eINSTANCE.createSDocumentGraph());
		
		return(sDoc);
	}
	
	/**
	 * Tests following structure:
	 * 
	 * 				rootCorpus
	 * 		/					\
	 * 	subCorp1				subCorp2
	 * 	/		\				/		\
	 * doc1		doc2		doc3		doc4
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public SCorpusGraph createCorpusStructure(SaltProject saltProject) 
	{
		SCorpusGraph sCorpGraph= SaltFactory.eINSTANCE.createSCorpusGraph();
		saltProject.getSCorpusGraphs().add(sCorpGraph);
		SCorpus sCorpus1= SaltFactory.eINSTANCE.createSCorpus();
		sCorpus1.setSName("rootCorpus");
		sCorpGraph.addSNode(sCorpus1);
		SCorpus sCorpus2= SaltFactory.eINSTANCE.createSCorpus();
		sCorpus2.setSName("subCorpus1");
		SCorpus sCorpus3= SaltFactory.eINSTANCE.createSCorpus();
		sCorpus3.setSName("subCorpus2");
		
		sCorpGraph.addSSubCorpus(sCorpus1, sCorpus2);
		sCorpGraph.addSSubCorpus(sCorpus1, sCorpus3);
		
		SDocument sDoc= null;
		
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc1");
		sCorpGraph.addSDocument(sCorpus2, sDoc);
		
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc2");
		sCorpGraph.addSDocument(sCorpus2, sDoc);
		
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc3");
		sCorpGraph.addSDocument(sCorpus2, sDoc);
		
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc4");
		sCorpGraph.addSDocument(sCorpus2, sDoc);
		
		return(sCorpGraph);
	}
	
	/**
	 * This method creates the content of a document (the primary text, the tokenization and all structures and annotations above them) for 
	 * the given SDocument object.
	 * 
	 * primary text: 		Is this example more complicated than it appears to be?
	 * tokens:				{"Is", "this", "example", "more", "complicated", "than", "it", "appears", "to", "be"}
	 * anaphoric relation:	{"it"} --> {"this", "example"}
	 * 
	 * @param sDocument the document for which the structure has to be created.
	 */
	public void createSDocumentStructure(SDocument sDocument)
	{
		{//creating the document structure
			//an object for the primary text
			STextualDS sTextualDS= null;
			
			{//creating the primary text
				sTextualDS= SaltFactory.eINSTANCE.createSTextualDS();
				sTextualDS.setSText("Is this example more complicated than it appears to be?");
//				sTextualDS.setSText("This is a sample text, which is very short.");
				//adding the text to the document-graph
				sDocument.getSDocumentGraph().addSNode(sTextualDS);
			}//creating the primary text
			
			{//creating tokenization (token objects and relations between tokens and the primary data object)
				//placeholder object representing a token
				SToken sToken= null;
				//object to connect a token to a primary text
				STextualRelation sTextRel= null;
				
				//adding the created token to the document-graph
				sToken= SaltFactory.eINSTANCE.createSToken();
				sDocument.getSDocumentGraph().addSNode(sToken);
				
				sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
				//adding the token as source of this relation
				sTextRel.setSToken(sToken);
				//adding the primary text as target of this relation
				sTextRel.setSTextualDS(sTextualDS);
				//adding the start-position of the token in the primary text 
				sTextRel.setSStart(0);
				//adding the end-position of the token in the primary text (start-position of the token + length of the token) 
				sTextRel.setSEnd(2);
				//adding the textual relation between token and primary text to document graph
				sDocument.getSDocumentGraph().addSRelation(sTextRel);
				
				{//creating the rest of the tokenization, this can also be done automatically
					//creating tokenization for the token 'this'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(3);
					sTextRel.setSEnd(7);	
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
					
					//creating tokenization for the token 'example'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(8);
					sTextRel.setSEnd(15);
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
					
					//creating tokenization for the token 'more'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(16);
					sTextRel.setSEnd(20);
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
					
					//creating tokenization for the token 'complicated'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(21);
					sTextRel.setSEnd(32);
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
					
					//creating tokenization for the token 'than'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(33);
					sTextRel.setSEnd(37);
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
					
					//creating tokenization for the token 'it'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(38);
					sTextRel.setSEnd(40);
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
					
					//creating tokenization for the token 'appears'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(41);
					sTextRel.setSEnd(48);
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
					
					//creating tokenization for the token 'to'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(49);
					sTextRel.setSEnd(51);
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
					
					//creating tokenization for the token 'be'
					sToken= SaltFactory.eINSTANCE.createSToken();
					sDocument.getSDocumentGraph().addSNode(sToken);
					sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
					sTextRel.setSToken(sToken);
					sTextRel.setSTextualDS(sTextualDS);
					sTextRel.setSStart(52);
					sTextRel.setSEnd(54);
					sDocument.getSDocumentGraph().addSRelation(sTextRel);
				}//creating the rest of the tokenization, this can also be done automatically
			}//creating tokenization (token objects and relations between tokens and the primary data object)
			
			// a synchronized list of all tokens to walk through
			List<SToken> sTokens= Collections.synchronizedList(sDocument.getSDocumentGraph().getSTokens());
			
			{//adding some annotations, part-of-speech and lemma (for part-of speech and lemma annotations a special annotation in Salt exists)
				{//adding part-of speech annotations
					SPOSAnnotation sPOSAnno= null;
					
					
					//a list of all part-of-speech annotations for the words Is (VBZ), this (DT) ... be (VB)
					String[] posAnnotations={"VBZ", "DT", "NN", "ABR", "JJ", "IN", "PRP", "VBZ", "TO", "VB"}; 
					for (int i= 0; i< sTokens.size();i++)
					{
						sPOSAnno= SaltFactory.eINSTANCE.createSPOSAnnotation();
						sPOSAnno.setSValue(posAnnotations[i]);
						sTokens.get(i).addSAnnotation(sPOSAnno);
					}
				}//adding part-of speech annotations
				
				{//adding lemma annotations
					SLemmaAnnotation sLemmaAnno= null;
					
					
					//a list of all lemma annotations for the words Is (be), this (this) ... be (be)
					String[] posAnnotations={"be", "this", "example", "more", "complicated", "than", "it", "appears", "to", "be"}; 
					for (int i= 0; i< sTokens.size();i++)
					{
						sLemmaAnno= SaltFactory.eINSTANCE.createSLemmaAnnotation();
						sLemmaAnno.setSValue(posAnnotations[i]);
						sTokens.get(i).addSAnnotation(sLemmaAnno);
					}
				}//adding lemma annotations
				
				{//creating annotations for information structure with the use of spans: "Is"= contrast-focus,"this example more complicated than it appears to be"= Topic 
					SSpan sSpan= null;
					SSpanningRelation sSpanRel= null;
					SAnnotation sAnno= null;
					
					//creating a span node as placeholder for information-structure annotation
					sSpan= SaltFactory.eINSTANCE.createSSpan();
					//adding the created span to the document-graph
					sDocument.getSDocumentGraph().addSNode(sSpan);
					//creating an annottaion for information-structure
					sAnno= SaltFactory.eINSTANCE.createSAnnotation();
					//setting the name of the annotation
					sAnno.setSName("Inf-Struct");
					//setting the value of the annotation
					sAnno.setSValue("contrast-focus");
					//adding the annotation to the placeholder span
					sSpan.addSAnnotation(sAnno);
					
					//creating a relation to connect a token with the span
					sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
					//setting the span as source of the relation
					sSpanRel.setSSpan(sSpan);
					//setting the first token as target of the relation
					sSpanRel.setSToken(sTokens.get(0));
					//adding the created relation to the document-graph
					sDocument.getSDocumentGraph().addSRelation(sSpanRel);
					
					{//creating the second span
						sSpan= SaltFactory.eINSTANCE.createSSpan();
						sDocument.getSDocumentGraph().addSNode(sSpan);
						sAnno= SaltFactory.eINSTANCE.createSAnnotation();
						sAnno.setSName("Inf-Struct");
						sAnno.setSValue("topic");
						sSpan.addSAnnotation(sAnno);
						for (int i= 1; i< sTokens.size(); i++)
						{
							sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
							sSpanRel.setSSpan(sSpan);
							sSpanRel.setSToken(sTokens.get(i));
							sDocument.getSDocumentGraph().addSRelation(sSpanRel);
						}
					}//creating the second span
					
				}//creating annotations for information structure with the use of spans
				
			}//adding some annotations, part-of-speech and lemma (for part-of speech and lemma annotations a special annotation in Salt exists)
			
			{//creating an anaphoric relation with the use of pointing relations between the Tokens {"it"} and {"this", "example"}
				//creating a span as placeholder, which contains the tokens for "this" and "example"
				SSpan sSpan= SaltFactory.eINSTANCE.createSSpan();
				//adding the created span to the document-graph
				sDocument.getSDocumentGraph().addSNode(sSpan);
				
				//creating a relation between the span and the tokens
				SSpanningRelation sSpanRel= null;
				sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
				sSpanRel.setSSpan(sSpan);
				sSpanRel.setSToken(sTokens.get(1));
				sDocument.getSDocumentGraph().addSRelation(sSpanRel);
				sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
				sSpanRel.setSSpan(sSpan);
				sSpanRel.setSToken(sTokens.get(2));
				sDocument.getSDocumentGraph().addSRelation(sSpanRel);
				
				//creating a pointing relations
				SPointingRelation sPointingRelation= SaltFactory.eINSTANCE.createSPointingRelation();
				//setting token "it" as source of this relation
				sPointingRelation.setSStructuredSource(sTokens.get(6));
				//setting span "this example" as target of this relation
				sPointingRelation.setSStructuredTarget(sSpan);
				//adding the created relation to the document-graph
				sDocument.getSDocumentGraph().addSRelation(sPointingRelation);
				//creating an annotation
				SAnnotation sAnno= SaltFactory.eINSTANCE.createSAnnotation();
				sAnno.setSName("anaphoric");
				sAnno.setSValue("antecedent");
				//adding the annotation to the relation
				sPointingRelation.addSAnnotation(sAnno);
			}//creating an anaphoric relation with the use of pointing relations between the Tokens {"it"} and {"this", "example"}
			//TODO more to do
		}//creating the document structure
	}
	
	/**
	 * Compares two directories and their content recursive. All conteined XML files will be checked for equality (via XMLUnit).
	 * @param dir1
	 * @param dir2
	 * @return
	 * @throws IOException 
	 * @throws SAXException 
	 */
	private boolean compareDirectories(File dir1, File dir2) throws IOException, SAXException
	{
		assertNotNull("The given directory dir1 must not be null", dir1);
		assertNotNull("The given directory dir2 must not be null", dir2);
		
		assertTrue("Directory dir1 ("+dir1.getAbsolutePath()+") does not exist.", dir1.exists());
		assertTrue("Directory dir2 ("+dir2.getAbsolutePath()+") does not exist.", dir2.exists());
		assertTrue("Directory dir1 ("+dir1.getAbsolutePath()+") is not a directory.", dir1.isDirectory());
		assertTrue("Directory dir2 ("+dir2.getAbsolutePath()+") is not a directory.", dir2.isDirectory());
		
		//if neccessary, a list of files and directories to ignore are used, in our case ".svn"
		ArrayList<String> ignoredFilenames = new ArrayList<String>();  
		ignoredFilenames.add(".svn");

		ArrayList<File> dir1List = new ArrayList<File>();
		ArrayList<File> dir2List = new ArrayList<File>();		
		
		for (File file : dir1.listFiles())
			if (!ignoredFilenames.contains(file.getName())) 
				dir1List.add(file);
		
		for (File file : dir2.listFiles())
			if (!ignoredFilenames.contains(file.getName())) 
				dir2List.add(file);
		
		assertEquals("Directories do not contain the same number of files and sub directories.", dir1List.size(), dir2List.size());
		
		//compare all files and subdirectories except for those in ignoredFilenames
		for (int i=0; i<dir1List.size(); i++) {
			File file1 = dir1List.get(i);
			File file2 = dir2List.get(i);
			
			assertEquals("The files do not have the same name.", file1.getName(), file2.getName());
			if (file1.isDirectory())
				compareDirectories(file1, file2);
			else
			{//compare salt files
				if (file1.getName().endsWith("salt"))
				{
					BufferedReader in = null;
					StringBuffer controlSequence =new StringBuffer();
					StringBuffer testSequence=new StringBuffer();
					try {
						String line = null;
						
						in = new BufferedReader(new FileReader(file1));
						line = null;
						while ((line = in.readLine()) != null) {
							testSequence.append(line);
						}
						in = new BufferedReader(new FileReader(file2));
						line = null;
						while ((line = in.readLine()) != null) {
							controlSequence.append(line);
						}
					} finally
					{
						if (in!= null)
						{
							in.close();
						}
					}
	
					DifferenceListener myDifferenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
				    Diff myDiff = new Diff(controlSequence.toString().replace("\r", "").replace("\n", "").replace("\t", ""), testSequence.toString().replace("\r", "").replace("\n", "").replace("\t", "")); 
				    myDiff.overrideDifferenceListener(myDifferenceListener);
				    assertTrue("XML does not matches control skeleton XML", myDiff.similar());
				}//compare salt files
			}
		}//compare all files and subdirectories
		return(true);
	}
} //SaltProjectTest
