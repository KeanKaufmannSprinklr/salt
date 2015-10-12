/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
package org.corpus_tools.salt.util.persistence.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.tests.SaltTestsUtil;
import org.corpus_tools.salt.util.SaltUtil;
import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;

public class Persist_SaltXML10_Test {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Tests the loading and storing of primary data.
	 */
	@Test
	public void testLoadStore_DocumentGraph_text() {
		// create template
		SDocument template = SaltFactory.createSDocument();
		SampleGenerator.createPrimaryData(template);
		// create other
		SDocument other = SaltFactory.createSDocument();
		SampleGenerator.createPrimaryData(other);

		// store other document
		File tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/DocumentGraph_text.salt");
		URI path = URI.createFileURI(tmpFile.getAbsolutePath());
		SaltUtil.saveDocumentGraph(other.getDocumentGraph(), path);

		// compare both document graphs
		SDocumentGraph graph = SaltUtil.loadDocumentGraph(path);
		assertTrue(template.getDocumentGraph().isIsomorph(graph));
	}

	/**
	 * Tests the loading and storing of primary data.
	 */
	@Test
	public void testLoadStore_DocumentGraph_text_specialCharacters() {
		// create template
		SDocument template = SaltFactory.createSDocument();
		template.setDocumentGraph(SaltFactory.createSDocumentGraph());
		template.getDocumentGraph().createTextualDS("This is a text with linebreaks\n and tabs\t.");
		// test attributes
		template.getDocumentGraph().createAnnotation("mnys", "myname", "This is a \"text\" with linebreaks\n and tabs\t.");
		
		// create other
		SDocument other = SaltFactory.createSDocument();
		other.setDocumentGraph(SaltFactory.createSDocumentGraph());
		other.getDocumentGraph().createTextualDS("This is a text with linebreaks\n and tabs\t.");
		other.getDocumentGraph().createAnnotation("mnys", "myname", "This is a \"text\" with linebreaks\n and tabs\t.");

		// store other document
		File tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/DocumentGraph_text_specialCharacters.salt");
		URI path = URI.createFileURI(tmpFile.getAbsolutePath());
		SaltUtil.saveDocumentGraph(other.getDocumentGraph(), path);

		// compare both document graphs
		SDocumentGraph graph = SaltUtil.loadDocumentGraph(path);
		assertTrue(template.getDocumentGraph().isIsomorph(graph));
	}

	/**
	 * Tests the loading and storing of tokenization
	 */
	@Test
	public void testLoadStore_DocumentGraph_tokenization() {
		// create template
		SDocument template = SaltFactory.createSDocument();
		SampleGenerator.createTokens(template);
		// create other
		SDocument other = SaltFactory.createSDocument();
		SampleGenerator.createTokens(other);

		// store other document
		File tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/DocumentGraph_tokenization.salt");
		URI path = URI.createFileURI(tmpFile.getAbsolutePath());
		SaltUtil.saveDocumentGraph(other.getDocumentGraph(), path);

		// compare both document graphs
		SDocumentGraph graph = SaltUtil.loadDocumentGraph(path);
		assertTrue(template.getDocumentGraph().isIsomorph(graph));
	}

	/**
	 * Tests the loading and storing of:
	 * <ul>
	 * <li>{@link SampleGenerator#createTokens(SDocument)}</li>
	 * <li>{@link SampleGenerator#createMorphologyAnnotations(SDocument)}</li>
	 * <li>{@link SampleGenerator#createAnaphoricAnnotations(SDocument)}</li>
	 * <li>{@link SampleGenerator#createDependencies(SDocument)}</li>
	 * <li>
	 * {@link SampleGenerator#createInformationStructureAnnotations(SDocument)}</li>
	 * <li>{@link SampleGenerator#createSyntaxAnnotations(SDocument)}</li>
	 * </ul>
	 */
	@Test
	public void testLoadStore_DocumentGraph_multilayer() {
		// create template
		SDocument template = SaltFactory.createSDocument();
		SampleGenerator.createTokens(template);
		SampleGenerator.createMorphologyAnnotations(template);
		SampleGenerator.createAnaphoricAnnotations(template);
		SampleGenerator.createDependencies(template);
		SampleGenerator.createInformationStructureAnnotations(template);
		SampleGenerator.createSyntaxAnnotations(template);
		// create other
		SDocument other = SaltFactory.createSDocument();
		SampleGenerator.createTokens(other);
		SampleGenerator.createMorphologyAnnotations(other);
		SampleGenerator.createAnaphoricAnnotations(other);
		SampleGenerator.createDependencies(other);
		SampleGenerator.createInformationStructureAnnotations(other);
		SampleGenerator.createSyntaxAnnotations(other);

		// store other document
		File tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/DocumentGraph_multilayer.salt");
		URI path = URI.createFileURI(tmpFile.getAbsolutePath());
		SaltUtil.saveDocumentGraph(other.getDocumentGraph(), path);

		// compare both document graphs
		SDocumentGraph graph = SaltUtil.loadDocumentGraph(path);

		assertTrue(template.getDocumentGraph().isIsomorph(graph));
	}

	/**
	 * Tests the loading and storing of:
	 * <ul>
	 * <li>{@link SampleGenerator#createDialogue(SDocument)}</li>
	 * </ul>
	 */
	@Test
	public void testLoadStore_DocumentGraph_dialogue() {
		// create template
		SDocument template = SaltFactory.createSDocument();
		SampleGenerator.createDialogue(template);
		// create other
		SDocument other = SaltFactory.createSDocument();
		SampleGenerator.createDialogue(other);

		// store other document
		File tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/DocumentGraph_dialogue.salt");

		URI path = URI.createFileURI(tmpFile.getAbsolutePath());
		SaltUtil.saveDocumentGraph(other.getDocumentGraph(), path);

		// compare both document graphs
		SDocumentGraph graph = SaltUtil.loadDocumentGraph(path);
		assertTrue(template.getDocumentGraph().isIsomorph(graph));
	}

	/**
	 * Tests the loading and storing of:
	 * <ul>
	 * <li>{@link SampleGenerator#createParallelData(SDocument)}</li>
	 * </ul>
	 */
	@Test
	public void testLoadStore_DocumentGraph_parallelData() {
		// create template
		SDocument template = SaltFactory.createSDocument();
		SampleGenerator.createParallelData(template);
		// create other
		SDocument other = SaltFactory.createSDocument();
		SampleGenerator.createParallelData(other);

		// store other document
		File tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/DocumentGraph_parallel.salt");
		URI path = URI.createFileURI(tmpFile.getAbsolutePath());
		SaltUtil.saveDocumentGraph(other.getDocumentGraph(), path);

		// compare both document graphs
		SDocumentGraph graph = SaltUtil.loadDocumentGraph(path);
		assertTrue(template.getDocumentGraph().isIsomorph(graph));
	}

	/**
	 * 
	 */
	@Test
	public void testLoadStore_SaltProject() {
		SaltProject project = SaltFactory.createSaltProject();

		// create two corpus structures
		SampleGenerator.createCorpusStructure(project);
		SampleGenerator.createCorpusStructure(project);

		File tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/saltProject/" + SaltUtil.FILE_SALT_PROJECT);
		SaltUtil.saveSaltProject(project, URI.createFileURI(tmpFile.getAbsolutePath()));
		SaltProject loaded = SaltUtil.loadSaltProject(URI.createFileURI(tmpFile.getAbsolutePath()));

		assertEquals(project.getCorpusGraphs().size(), loaded.getCorpusGraphs().size());
		assertEquals(project.getCorpusGraphs().get(0).getNodes().size(), loaded.getCorpusGraphs().get(0).getNodes().size());
		assertEquals(project.getCorpusGraphs().get(0).getRelations().size(), loaded.getCorpusGraphs().get(0).getRelations().size());
		assertEquals(project.getCorpusGraphs().get(1).getNodes().size(), loaded.getCorpusGraphs().get(1).getNodes().size());
		assertEquals(project.getCorpusGraphs().get(1).getRelations().size(), loaded.getCorpusGraphs().get(1).getRelations().size());

		tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/saltProject2/");
		SaltUtil.saveSaltProject(project, URI.createFileURI(tmpFile.getAbsolutePath()));
		loaded = SaltUtil.loadSaltProject(URI.createFileURI(tmpFile.getAbsolutePath()));

		assertEquals(project.getCorpusGraphs().size(), loaded.getCorpusGraphs().size());
		assertEquals(project.getCorpusGraphs().get(0).getNodes().size(), loaded.getCorpusGraphs().get(0).getNodes().size());
		assertEquals(project.getCorpusGraphs().get(0).getRelations().size(), loaded.getCorpusGraphs().get(0).getRelations().size());
		assertEquals(project.getCorpusGraphs().get(1).getNodes().size(), loaded.getCorpusGraphs().get(1).getNodes().size());
		assertEquals(project.getCorpusGraphs().get(1).getRelations().size(), loaded.getCorpusGraphs().get(1).getRelations().size());
	}
}