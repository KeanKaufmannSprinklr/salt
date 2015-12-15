package org.corpus_tools.salt.util.tests;


import java.io.File;
import java.io.IOException;

import javax.xml.stream.XMLStreamException;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.exceptions.SaltException;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.exceptions.SaltResourceException;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.tests.SaltTestsUtil;
import org.corpus_tools.salt.util.VisJsVisualizer;
import org.eclipse.emf.common.util.URI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.Files;


public class VisJsVisualizerTest {
	private final static String FSEP = System.getProperty("file.separator");
	private final static String OUTPUT_FOLDER = SaltTestsUtil.getTempTestFolder().getAbsolutePath();
	
	private final static String INPUT_FOLDER =  "src"	+ FSEP+"test"	+ FSEP+ "resources" + FSEP + "VisJsTest" + FSEP + "sources";
	private final static String INPUT_FILE_MAIN_TEST = INPUT_FOLDER + FSEP + "pcc2_salt" + FSEP + "pcc2" + FSEP  + "11299.salt";
	
	private final static String TEST_RESULT_FOLDER =  "src"	+ FSEP+"test"	+ FSEP+ "resources" + FSEP + "VisJsTest" + FSEP + "results";
	
	private  String [] allFileNames;

	
	
	@Before
	  public void setUp() {
		this.allFileNames = new String [5];
		allFileNames[0] = VisJsVisualizer.HTML_FILE;
		allFileNames[1] = VisJsVisualizer.JS_FOLDER_OUT + FSEP + VisJsVisualizer.JQUERY_FILE;
		allFileNames[2] = VisJsVisualizer.JS_FOLDER_OUT + FSEP + VisJsVisualizer.JS_FILE;
		allFileNames[3] = VisJsVisualizer.CSS_FOLDER_OUT + FSEP + VisJsVisualizer.CSS_FILE;
		allFileNames[4] = VisJsVisualizer.JSON_FOLDER_OUT + FSEP + VisJsVisualizer.NODES_AND_EDGES_FILE;	
	  }
		
	
	@Test
	public void testHtmlWriterWholeDocLoadJson() throws SaltParameterException, SaltResourceException, SaltException, IOException, XMLStreamException {
		String inputFilePath = INPUT_FILE_MAIN_TEST;		
		String outputFolderName =  "pcc_whole_doc_11299_load_json";
		String outputFolderPath = OUTPUT_FOLDER + FSEP + outputFolderName;	   
		
		File testFolder = new File(outputFolderPath);
		File resultFolder = new File (TEST_RESULT_FOLDER, outputFolderName);
		
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri);
		
		
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
			
				boolean equalFiles = false;
				visJsVisualizer.visualize(outputFolderUri, true);
				
				
				if(folderStructureOk(testFolder, true) && folderStructureOk(resultFolder, true))
				{
					equalFiles = true;
					
					for (int i=0; i<allFileNames.length; i++)
					{
						equalFiles = equalFiles && filesAreEqual(new File(resultFolder, allFileNames[i]), new File(testFolder, allFileNames[i]));
				
					}					
				}
				
				Assert.assertTrue(equalFiles);
				
	}
	
		
	
	
	@Test
	public void testHtmlWriterWholeDoc() throws SaltParameterException, SaltResourceException, SaltException, IOException, XMLStreamException {
		String inputFilePath = INPUT_FILE_MAIN_TEST;	
		String outputFolderName = "pcc_whole_doc_11299";	   
		String outputFolderPath = OUTPUT_FOLDER + FSEP + outputFolderName;	   
		
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri);
		File testFolder = new File(outputFolderPath);
		File resultFolder = new File (TEST_RESULT_FOLDER, outputFolderName);		
		
		 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
		
			boolean equalFiles = false;
			visJsVisualizer.visualize(outputFolderUri, false);
			
			if(folderStructureOk(testFolder, false) && folderStructureOk(resultFolder, false))
			{
				equalFiles = true;
				
				for (int i=0; i<(allFileNames.length - 1); i++)
				{
					equalFiles = equalFiles && filesAreEqual(new File(resultFolder, allFileNames[i]), new File(testFolder, allFileNames[i]));
				
				}					
			}
			
			Assert.assertTrue(equalFiles);			
	}
	
	
	
	
	@Test
	public void testHtmlWriterSample() throws SaltParameterException, SaltResourceException, SaltException, IOException, XMLStreamException {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(doc);	
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(doc);
		String outputFolderName = "sample_doc";
		String outputFolderPath = OUTPUT_FOLDER + FSEP + outputFolderName;	
		
		File testFolder = new File(outputFolderPath);
		File resultFolder = new File (TEST_RESULT_FOLDER, outputFolderName);
		

			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
	
				 boolean equalFiles = false;
					visJsVisualizer.visualize(outputFolderUri, false);
					
					if(folderStructureOk(testFolder, false) && folderStructureOk(resultFolder, false))
					{
						equalFiles = true;
						
						for (int i=0; i<(allFileNames.length - 1); i++)
						{
							equalFiles = equalFiles && filesAreEqual(new File(resultFolder, allFileNames[i]), new File(testFolder, allFileNames[i]));
							
						}					
					}
					
				Assert.assertTrue(equalFiles);				
	
	}
	
	@Test
	public void testHtmlWriterSampleAnaphoricAnnLoadJson() throws SaltParameterException, SaltResourceException, SaltException, IOException, XMLStreamException {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createAnaphoricAnnotations(doc);
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(doc);
		String outputFolderName =  "sample_doc_anaphoric_ann_load_json";	 
		String outputFolderPath = OUTPUT_FOLDER + FSEP + outputFolderName;	
		
		File testFolder = new File(outputFolderPath);
		File resultFolder = new File (TEST_RESULT_FOLDER, outputFolderName);
		
		
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
						 
				 boolean equalFiles = false;
					visJsVisualizer.visualize(outputFolderUri, true);
					
					if(folderStructureOk(testFolder, true) && folderStructureOk(resultFolder, true))
					{
						equalFiles = true;
						
						for (int i=0; i<allFileNames.length; i++)
						{
							equalFiles = equalFiles && filesAreEqual(new File(resultFolder, allFileNames[i]), new File(testFolder, allFileNames[i]));
							
						}					
					}
					
					Assert.assertTrue(equalFiles);
	}
	
	
	
	@Test
	public void testHtmlWriterSampleDependencies() throws SaltParameterException, SaltResourceException, SaltException, IOException, XMLStreamException {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createDependencies(doc);
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(doc);
		String outputFolderName =  "sample_doc_dependencies";
		String outputFolderPath = OUTPUT_FOLDER + FSEP + outputFolderName;	  
		
		File testFolder = new File(outputFolderPath);
		File resultFolder = new File (TEST_RESULT_FOLDER, outputFolderName);
	
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
	
				 boolean equalFiles = false;
					visJsVisualizer.visualize(outputFolderUri, false);
					
					if(folderStructureOk(testFolder, false) && folderStructureOk(resultFolder, false))
					{
						equalFiles = true;
						
						for (int i=0; i<(allFileNames.length - 1); i++)
						{
							equalFiles = equalFiles && filesAreEqual(new File(resultFolder, allFileNames[i]), new File(testFolder, allFileNames[i]));
							
						}					
					}
					
					Assert.assertTrue(equalFiles);		
		
	}
	
	
	
	@Test
	public void testHtmlWriterSampleSyntaxStructure() throws SaltParameterException, SaltResourceException, SaltException, IOException, XMLStreamException {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createSyntaxStructure(doc);
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(doc);
		String outputFolderName = "sample_doc_syntax_structure";
		String outputFolderPath = OUTPUT_FOLDER + FSEP + outputFolderName;	  
		
		File testFolder = new File(outputFolderPath);
		File resultFolder = new File (TEST_RESULT_FOLDER, outputFolderName);
		
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
	
				 boolean equalFiles = false;
					visJsVisualizer.visualize(outputFolderUri, false);
					
					if(folderStructureOk(testFolder, false) && folderStructureOk(resultFolder, false))
					{
						equalFiles = true;
						
						for (int i=0; i<(allFileNames.length - 1); i++)
						{
							equalFiles = equalFiles && filesAreEqual(new File(resultFolder, allFileNames[i]), new File(testFolder, allFileNames[i]));
							
						}					
					}
					
					Assert.assertTrue(equalFiles);	
			
	}
	
	@Test
	public void testHtmlWriterSampleTokens() throws SaltParameterException, SaltResourceException, SaltException, IOException, XMLStreamException {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createTokens(doc);
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(doc);
		String outputFolderName = "sample_doc_tokens";
		String outputFolderPath = OUTPUT_FOLDER + FSEP + outputFolderName;	 
		
		File testFolder = new File(outputFolderPath);
		File resultFolder = new File (TEST_RESULT_FOLDER, outputFolderName);
		

			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	

				 boolean equalFiles = false;
					visJsVisualizer.visualize(outputFolderUri, false);
					
					if(folderStructureOk(testFolder, false) && folderStructureOk(resultFolder, false))
					{
						equalFiles = true;
						
						for (int i=0; i<(allFileNames.length - 1); i++)
						{
							equalFiles = equalFiles && filesAreEqual(new File(resultFolder, allFileNames[i]), new File(testFolder, allFileNames[i]));
							
						}					
					}
					
					Assert.assertTrue(equalFiles);

	}
	
	
	
	@Test
	public void testHtmlWriterSampleMorphologyAnn() throws SaltParameterException, SaltResourceException, SaltException, IOException, XMLStreamException {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createMorphologyAnnotations(doc);
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(doc);
		String outputFolderName = "sample_doc_morphology_ann";	
		String outputFolderPath = OUTPUT_FOLDER + FSEP + outputFolderName;	 
		
		File testFolder = new File(outputFolderPath);
		File resultFolder = new File (TEST_RESULT_FOLDER, outputFolderName);
		
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
		
				 boolean equalFiles = false;
					visJsVisualizer.visualize(outputFolderUri, false);
					
					if(folderStructureOk(testFolder, false) && folderStructureOk(resultFolder, false))
					{
						equalFiles = true;
						
						for (int i=0; i<(allFileNames.length - 1); i++)
						{
							equalFiles = equalFiles && filesAreEqual(new File(resultFolder, allFileNames[i]), new File(testFolder, allFileNames[i]));
							
						}					
					}
					
					Assert.assertTrue(equalFiles);
					
	}
	
	
	
	@Test(expected = SaltParameterException.class)
	public void testInputUrlIsNull(){
		URI uri = null;
		@SuppressWarnings("unused")
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri);
	}
	
	@Test(expected = SaltResourceException.class)
	public void testInvalideSaltFormat(){
		String inputFilePath = INPUT_FOLDER + FSEP + "pcc2_invalid_format" + FSEP + "pcc2" + FSEP + "11299.salt";
		URI uri = URI.createFileURI(inputFilePath);	
		@SuppressWarnings("unused")
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri);
	}
	
	@Test(expected = SaltResourceException.class)
	public void testAbsentSaltResource(){
		String inputFilePath = INPUT_FOLDER + FSEP + "pcc2_absent_resource" + FSEP + "pcc2" + FSEP + "11299.salt";
		URI uri = URI.createFileURI(inputFilePath);	
		@SuppressWarnings("unused")
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri);
	}
	

	@Test(expected = SaltParameterException.class)
	public void testNodeWriterIsNull(){
		URI uri = URI.createFileURI(INPUT_FILE_MAIN_TEST);	
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri);		
		visJsVisualizer.setEdgeWriter(System.out);
		visJsVisualizer.buildJSON();
	}
	
	@Test(expected = SaltParameterException.class)
	public void testEdgeWriterIsNull(){
		URI uri = URI.createFileURI(INPUT_FILE_MAIN_TEST);	
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri);		
		visJsVisualizer.setNodeWriter(System.out);
		visJsVisualizer.buildJSON();
	}	
	
	
	private static boolean folderStructureOk (File folder, boolean loadJson){
		int nFiles;
		
		if (loadJson) 
		{
			nFiles = 4;
		}
		else
		{
			nFiles = 3;
		}
		
		if (folder.exists() && folder.isDirectory() && folder.canRead())
		{
			
			if(folder.listFiles().length == nFiles)
			{
				return true;
			}
		}		
		return false;
	}



	private static boolean filesAreEqual (File testFile, File resultFile) throws IOException{				
		return Files.equal(testFile, resultFile);		
	}

}