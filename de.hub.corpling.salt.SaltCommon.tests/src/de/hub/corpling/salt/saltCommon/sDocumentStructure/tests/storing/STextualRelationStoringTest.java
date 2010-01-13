/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.tests.storing;

import java.io.IOException;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hub.corpling.graph.Label;
import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline;
import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SFeature;
import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SDocument Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs() <em>STextual DSs</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations() <em>STextual Relations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens() <em>STokens</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class STextualRelationStoringTest extends TestCase {

	/**
	 * The fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STextualRelation fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(STextualRelationStoringTest.class);
	}

	/**
	 * Constructs a new SDocument Graph test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STextualRelationStoringTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void setFixture(STextualRelation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected STextualRelation getFixture() {
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
		setFixture(SDocumentStructureFactory.eINSTANCE.createSTextualRelation());
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

	public void testStoring1() throws IOException
	{
		assertTrue(this.getFixture().isSTextOverlapping());
		STextualRelation sTextualRel2= SaltCommonFactory.eINSTANCE.createSTextualRelation();
		String tmpFileName= "_TMP/STextualRelation.saltCommon";
		{//adding id
			String id= "salt:/graph1#textualRelation1";
			this.getFixture().setSId(id);
		}
		
		{//save and reload
			// create resource set and resource 
			ResourceSet resourceSet = new ResourceSetImpl();

			// Register XML resource factory
			resourceSet.getPackageRegistry().put(SaltCorePackage.eINSTANCE.getNsURI(), SaltCorePackage.eINSTANCE);
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saltCommon",new XMIResourceFactoryImpl());
			
			URI outURI= URI.createFileURI(tmpFileName);
			
			//save resources
			XMLResource resourceOut = (XMLResource)resourceSet.createResource(outURI);
			resourceOut.getContents().add(this.getFixture());
			resourceOut.setEncoding("UTF-8");
			resourceOut.save(null);
			
			
			//load resource 
			Resource resource = resourceSet.createResource(URI.createFileURI(tmpFileName));
			
			if (resource== null)
				throw new NullPointerException("The resource is null.");
			resource.load(null);
			sTextualRel2= (STextualRelation) resource.getContents().get(0);
		}
		
		{//check if equals
			assertEquals(this.getFixture(), sTextualRel2);
		}
	}
	
	/**
	 * Test storing with some attributes: id, sstart, send
	 * @throws IOException
	 */
	public void testStoring2() throws IOException
	{
		assertTrue(this.getFixture().isSTextOverlapping());
		STextualRelation sTextualRel2= SaltCommonFactory.eINSTANCE.createSTextualRelation();
		String tmpFileName= "_TMP/STextualRelation.saltCommon";
		{//adding values
			String id= "salt:/graph1#textualRelation1";
			this.getFixture().setSId(id);
			this.getFixture().setSStart(0);
			this.getFixture().setSEnd(4);
		}//adding values
		
		{//save and reload
			// create resource set and resource 
			ResourceSet resourceSet = new ResourceSetImpl();

			// Register XML resource factory
			resourceSet.getPackageRegistry().put(SaltCorePackage.eINSTANCE.getNsURI(), SaltCorePackage.eINSTANCE);
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saltCommon",new XMIResourceFactoryImpl());
			
			URI outURI= URI.createFileURI(tmpFileName);
			
			//save resources
			XMLResource resourceOut = (XMLResource)resourceSet.createResource(outURI);
			resourceOut.getContents().add(this.getFixture());
			resourceOut.setEncoding("UTF-8");
			resourceOut.save(null);
			
			
			//load resource 
			Resource resource = resourceSet.createResource(URI.createFileURI(tmpFileName));
			
			if (resource== null)
				throw new NullPointerException("The resource is null.");
			resource.load(null);
			sTextualRel2= (STextualRelation) resource.getContents().get(0);
		}
		
		{//check if equals
			assertEquals(this.getFixture(), sTextualRel2);
		}
	}
	
	/**
	 * Test storing STextualRelation with attributes:
	 * id
	 * and two nodes.
	 * @throws IOException
	 */
	public void testStoring3() throws IOException
	{
		assertTrue(this.getFixture().isSTextOverlapping());
		STextualRelation sTextualRel2= SaltCommonFactory.eINSTANCE.createSTextualRelation();
		
		String tmpFileName= "_TMP/STextualRelation.saltCommon";
		// resource location to store target and source node
		String tmpSNodeFileName= "_TMP/SNode.saltCommon";
		{//adding values
			String id= "salt:/graph1#textualRelation1";
			this.getFixture().setSId(id);
		}//adding values
		
		{//adding nodes
			SNode node1= SaltCommonFactory.eINSTANCE.createSNode();
			this.getFixture().setSSource(node1);
			this.getFixture().setSTarget(node1);
			
			{//using resource for source and target node
				ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getPackageRegistry().put(SaltCorePackage.eINSTANCE.getNsURI(), SaltCorePackage.eINSTANCE);
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saltCommon",new XMIResourceFactoryImpl());
				
				URI outURI= URI.createFileURI(tmpSNodeFileName);
				
				//save resources
				XMLResource resourceOut = (XMLResource)resourceSet.createResource(outURI);
				resourceOut.getContents().add(node1);
			}//using resource for source and target node
			
		}//adding nodes
		
		{//save and reload
			// create resource set and resource 
			ResourceSet resourceSet = new ResourceSetImpl();

			// Register XML resource factory
			resourceSet.getPackageRegistry().put(SaltCorePackage.eINSTANCE.getNsURI(), SaltCorePackage.eINSTANCE);
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saltCommon",new XMIResourceFactoryImpl());
			
			URI outURI= URI.createFileURI(tmpFileName);
			
			//save resources
			XMLResource resourceOut = (XMLResource)resourceSet.createResource(outURI);
			resourceOut.getContents().add(this.getFixture());
			resourceOut.setEncoding("UTF-8");
			resourceOut.save(null);
			
			
			//load resource 
			Resource resource = resourceSet.createResource(URI.createFileURI(tmpFileName));
			
			if (resource== null)
				throw new NullPointerException("The resource is null.");
			resource.load(null);
			sTextualRel2= (STextualRelation) resource.getContents().get(0);
		}
		
		{//check if equals
			assertEquals(this.getFixture(), sTextualRel2);
		}
	}

} //SDocumentGraphTest
