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
package de.hu_berlin.u.saltnpepper.salt.util.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDominanceRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SPointingRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SStructure;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SToken;
import de.hu_berlin.u.saltnpepper.salt.core.SLayer;
import de.hu_berlin.u.saltnpepper.salt.samples.SampleGenerator;
import de.hu_berlin.u.saltnpepper.salt.util.Difference;
import de.hu_berlin.u.saltnpepper.salt.util.internal.Diff2;

/**
 * This class tests the isomorphy check of the {@link SDocumentGraph}.
 * 
 * @author André Röhrig
 */
public class Diff2Test {

	protected Diff2 fixture = null;

	protected void setFixture(Diff2 fixture) {
		this.fixture = fixture;
	}

	protected Diff2 getFixture() {
		return fixture;
	}

	private SDocumentGraph template = null;
	private SDocumentGraph other = null;

	@Before
	public void setUp() throws Exception {
		template = SaltFactory.createSDocumentGraph();
		template.setDocument(SaltFactory.createSDocument());

		other = SaltFactory.createSDocumentGraph();
		other.setDocument(SaltFactory.createSDocument());

		setFixture(new Diff2(template, other));
	}

	/**
	 * Tests two graphs containing
	 * <ul>
	 * <li>same primary date</li>
	 * <li>different primary date</li>
	 * <li>two primary data</li>
	 * </ul>
	 **/
	@Test
	public void testNumbers() {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());

		assertTrue(getFixture().isIsomorph());

		other.createToken(other.getTextualDSs().get(0), 1, 20);
		assertFalse(getFixture().isIsomorph());
	}

	/**
	 * Tests same and different textual data sources
	 */
	@Test
	public void testTextualDS_iso() {
		STextualDS templateText= SampleGenerator.createPrimaryData(template.getDocument());
		STextualDS otherText= SampleGenerator.createPrimaryData(other.getDocument());
		assertTrue(getFixture().isIsomorph());
		
		otherText.setText("a template text");
		assertFalse(getFixture().isIsomorph());
	}
	
	/**
	 * Tests same and different textual data sources
	 */
	@Test
	public void testTextualDS_diff() {
		STextualDS templateText= SampleGenerator.createPrimaryData(template.getDocument());
		STextualDS otherText= SampleGenerator.createPrimaryData(other.getDocument());
		Set<Difference> diffs= getFixture().findDiffs();
		assertEquals(""+diffs, 0, diffs.size());
		
		otherText.setText("a template text");
		diffs= getFixture().findDiffs();
		assertEquals(""+diffs, 2, diffs.size());
	}
	/**
	 * Tests for two tokens whether their annotations are isomorph.
	 */
	@Test
	public void testCompareAnnotationContainer(){
		STextualDS text1= template.createTextualDS("Test");
		SToken templateTok= template.createToken(text1, 0, 5);
		
		STextualDS otherText= other.createTextualDS("Test");
		SToken otherTok= other.createToken(text1, 0, 5);
		
		//no annotations
		Set<Difference> diffs= new HashSet<>();
		getFixture().compareAnnotationContainers(templateTok, otherTok, diffs);
		assertEquals(""+diffs, 0, diffs.size());
		
		// template has one annotation, other none
		templateTok.createAnnotation(null, "anno", "annoVal");
		diffs= new HashSet<>();
		getFixture().compareAnnotationContainers(templateTok, otherTok, diffs);
		assertEquals(""+diffs, 1, diffs.size());
		
		// both have one annotation
		otherTok.createAnnotation(null, "anno", "annoVal");
		diffs= new HashSet<>();
		getFixture().compareAnnotationContainers(templateTok, otherTok, diffs);
		assertEquals(""+diffs, 0, diffs.size());
		
		// template has two annotation, other has one
		templateTok.createAnnotation("namespace", "anno", "annoVal");
		diffs= new HashSet<>();
		getFixture().compareAnnotationContainers(templateTok, otherTok, diffs);
		assertEquals(""+diffs, 1, diffs.size());
	}
	
	/**
	 * Tests same and different tokens
	 */
	@Test
	public void testSTokenCompare() {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());

		template.createToken(template.getTextualDSs().get(0), 0, 1);
		other.createToken(other.getTextualDSs().get(0), 0, 1);
		template.createToken(template.getTextualDSs().get(0), 2, 11);
		other.createToken(other.getTextualDSs().get(0), 2, 11);

		assertTrue(getFixture().isIsomorph());

		template.createToken(template.getTextualDSs().get(0), 12, 20);
		other.createToken(other.getTextualDSs().get(0), 12, 15);

		assertFalse(getFixture().isIsomorph());
		assertEquals(3, getFixture().getIsoObjects().size());
	}

	@Test
	public void testSNodeCompare() {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());

		template.createToken(template.getTextualDSs().get(0), 0, 1);
		other.createToken(other.getTextualDSs().get(0), 0, 1);
		template.createToken(template.getTextualDSs().get(0), 2, 5);
		other.createToken(other.getTextualDSs().get(0), 2, 5);
		template.createToken(template.getTextualDSs().get(0), 6, 8);
		other.createToken(other.getTextualDSs().get(0), 6, 8);
		template.createToken(template.getTextualDSs().get(0), 9, 11);
		other.createToken(other.getTextualDSs().get(0), 9, 11);

		SDominanceRelation sDominatingRelation = SaltFactory.createSDominanceRelation();
		SStructure templ_struc = SaltFactory.createSStructure();
		sDominatingRelation.setSource(templ_struc);
		sDominatingRelation.setTarget(template.getTokens().get(0));
		template.addNode(templ_struc);
		template.addRelation(sDominatingRelation);

		SDominanceRelation sDominatingRelation2 = SaltFactory.createSDominanceRelation();
		SStructure other_struc = SaltFactory.createSStructure();
		sDominatingRelation2.setSource(other_struc);
		sDominatingRelation2.setTarget(other.getTokens().get(0));
		other.addNode(other_struc);
		other.addRelation(sDominatingRelation2);

		assertTrue("" + getFixture().getDifferences(), getFixture().isIsomorph());

		SDominanceRelation sDominatingRelation3 = SaltFactory.createSDominanceRelation();
		sDominatingRelation3.setSource(templ_struc);
		sDominatingRelation3.setTarget(template.getTokens().get(1));
		template.addRelation(sDominatingRelation3);

		SDominanceRelation sDominatingRelation4 = SaltFactory.createSDominanceRelation();
		sDominatingRelation4.setSource(other_struc);
		sDominatingRelation4.setTarget(other.getTokens().get(2));
		other.addRelation(sDominatingRelation4);

		assertFalse(getFixture().isIsomorph());

	}

	@Test
	public void testPrimaryData() {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());

		// same primary date
		assertTrue(getFixture().isIsomorph());

		LinkedHashSet<Difference> noDifferences = new LinkedHashSet<Difference>();
		assertEquals(0, getFixture().getDifferences().size());

		// different primary date
		SampleGenerator.createPrimaryData(other.getDocument());
		other.getTextualDSs().get(0).setText("a different text");
		assertFalse(getFixture().isIsomorph());

		// two primary date
		SampleGenerator.createPrimaryData(other.getDocument());
		assertFalse(getFixture().isIsomorph());
	}

	/**
	 * Tests two graphs containing
	 * <ul>
	 * <li>same tokenization</li>
	 * <li>different tokenization - number of tokens</li>
	 * <li>different tokenization - different offsets</li>
	 * </ul>
	 */
	@Test
	public void testToken() {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createTokens(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());
		SampleGenerator.createTokens(other.getDocument());

		// same tokenization
		assertTrue(getFixture().isIsomorph());

		// different tokenization - number of tokens
		other.createToken(other.getTextualDSs().get(0), 1, 3);
		assertFalse(getFixture().isIsomorph());

		// different tokenization - different offsets
		SampleGenerator.createPrimaryData(other.getDocument());
		SampleGenerator.createTokens(other.getDocument());
		other.removeNode(other.getTokens().get(other.getTokens().size() - 1));
		other.createToken(other.getTextualDSs().get(0), 1, 20);
		assertFalse(getFixture().isIsomorph());
	}

	/**
	 * Checks the isomorphie for token annotation for listed cases:
	 * <ul>
	 * <li>same annotations</li>
	 * <li>different annotations - one additional annotation</li>
	 * <li>different annotations - different annotation names</li>
	 * </ul>
	 */
	@Test
	public void testTokenAnnotation() {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createTokens(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());
		SampleGenerator.createTokens(other.getDocument());

		for (SToken tok : template.getTokens()) {
			tok.createAnnotation(null, "annoName", "annoVal");
		}

		for (SToken tok : other.getTokens()) {
			tok.createAnnotation(null, "annoName", "annoVal");
		}
		// same annotations
		assertTrue(getFixture().isIsomorph());

		// different annotations - one additional annotation
		other.getTokens().get(0).createAnnotation(null, "annoName2", "annoVal");
		assertFalse(getFixture().isIsomorph());

		// different annotations - different annotation names
		SampleGenerator.createPrimaryData(other.getDocument());
		SampleGenerator.createTokens(other.getDocument());
		for (SToken tok : other.getTokens()) {
			tok.createAnnotation(null, "otherName", "annoVal");
		}
		assertFalse(getFixture().isIsomorph());
	}

	@Test
	public void testCheckAnno() throws FileNotFoundException {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());

		template.createToken(template.getTextualDSs().get(0), 0, 1);
		other.createToken(other.getTextualDSs().get(0), 0, 1);
		template.createToken(template.getTextualDSs().get(0), 2, 11);
		other.createToken(other.getTextualDSs().get(0), 2, 11);

		assertTrue(getFixture().isIsomorph());

		template.getTokens().get(0).createAnnotation(null, "A", "B");

		assertFalse(getFixture().isIsomorph());

		Diff2 newerDiff = new Diff2(template, other);
		Set<Difference> diffs = newerDiff.findDiffs();
		Iterator<Difference> diffIt = diffs.iterator();
	}

	@Test
	public void testSPointing() {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());

		template.createToken(template.getTextualDSs().get(0), 0, 1);
		other.createToken(other.getTextualDSs().get(0), 0, 1);
		template.createToken(template.getTextualDSs().get(0), 2, 11);
		other.createToken(other.getTextualDSs().get(0), 2, 11);

		assertTrue(getFixture().isIsomorph());
		SPointingRelation pr1 = SaltFactory.createSPointingRelation();
		pr1.setSource((SToken) template.getNodes().get(1));
		pr1.setTarget((SToken) template.getNodes().get(2));
		pr1.setGraph(template);
		getFixture().checkPointingRelations(template, other, true);

		assertFalse(getFixture().isIsomorph());

	}

	@Test
	public void testTwoLayers() {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());

		template.createToken(template.getTextualDSs().get(0), 0, 1);
		other.createToken(other.getTextualDSs().get(0), 0, 1);
		template.createToken(template.getTextualDSs().get(0), 2, 11);
		other.createToken(other.getTextualDSs().get(0), 2, 11);

		SLayer tempLayer = SaltFactory.createSLayer();
		SLayer otherLayer = SaltFactory.createSLayer();

		template.getTokens().get(0).addLayer(tempLayer);
		other.getTokens().get(0).addLayer(otherLayer);

		assertTrue(getFixture().isIsomorph());
		assertTrue(getFixture().checkTwoLayers(tempLayer, otherLayer));

		template.getTokens().get(1).addLayer(tempLayer);
		assertFalse(getFixture().checkTwoLayers(tempLayer, otherLayer));
	}

	// @Test
	// public void testRealData() throws FileNotFoundException {
	// File inFile1 = new
	// File("TCF-Test/SaltXML-Corpus/TCF-Corpus/parser_a.salt");
	// URI uri1 = URI.createFileURI(inFile1.getAbsolutePath());
	// SDocumentGraph graphA = SaltFactory.loadSDocumentGraph(uri1);
	//
	// File inFile2 = new
	// File("TCF-Test/SaltXML-Corpus/TCF-Corpus/parser_b.salt");
	// URI uri2 = URI.createFileURI(inFile2.getAbsolutePath());
	// SDocumentGraph graphB = SaltFactory.loadSDocumentGraph(uri2);
	//
	// Diff newDiff = new Diff(graphA, graphB);
	// boolean iso = newDiff.isIsomorph();
	//
	// Diff newerDiff = new Diff(graphA, graphB);
	// Set<Difference> diffs = newerDiff.findDiffs();
	// Iterator<Difference> diffIt = diffs.iterator();
	//
	// PrintWriter out = new PrintWriter("filename.txt");
	// while (diffIt.hasNext()) {
	// out.println(diffIt.next().toString());
	//
	// }
	// out.flush();
	// out.close();
	//
	// }
}