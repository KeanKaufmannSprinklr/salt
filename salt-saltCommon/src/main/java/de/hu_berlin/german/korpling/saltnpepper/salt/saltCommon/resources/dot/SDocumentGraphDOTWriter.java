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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltModuleException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot.model.DOTEdge;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot.model.DOTNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

public class SDocumentGraphDOTWriter implements GraphTraverseHandler
{
	private URI outputURI= null;
	public void setOutputURI(URI outputURI) {
		this.outputURI = outputURI;
	}

	public URI getOutputURI() {
		return outputURI;
	}
	
	private SDocumentGraph sDocumentGraph= null;
	public void setSDocumentGraph(SDocumentGraph sDocumentGraph) {
		this.sDocumentGraph = sDocumentGraph;
	}

	public SDocumentGraph getSDocumentGraph() {
		return sDocumentGraph;
	}
	
	private PrintStream currOutputStream= null; 
	
	/**
	 * This list contains all nodes, which are visited.
	 */
	private EList<Node> visitedNodes= null;
	
	private Set<SToken> tokenList;
	private Set<SSpan> spanList;
	private Set<STimeline> timelineList;
	private Set<SStructure> structureList;
	private Set<STextualDS> textList;
	private Set<SNode> otherNodeList;
	
	public void save()
	{
		if (outputURI == null)
			throw new SaltModuleException("Cannot print the given model to dot, because no output file is given.");
		
		File outputFile= new File(this.getOutputURI().toFileString());
		File outputDir= null;
		// check if uri is a file uri or a directory uri
		if (outputFile.getName().contains("."))
			outputDir= outputFile.getParentFile();
		else outputDir= outputFile;
		outputDir.mkdirs();
		try {
			this.currOutputStream= new PrintStream(outputFile, "UTF-8");
			}
		catch (FileNotFoundException e) {
			throw new NullPointerException(e.getMessage());
		}
		catch (UnsupportedEncodingException e) 
		{ throw new NullPointerException(e.getMessage()); }
		this.currOutputStream.println("digraph G {");
		this.currOutputStream.println("ordering=out;");
		
		//if documentgraph isn't  null print it 
		SDocumentGraph docGraph = getSDocumentGraph();
		if (docGraph != null)
		{
			
			this.visitedNodes= new BasicEList<Node>(); 
			this.spanList = new LinkedHashSet<SSpan>();
			this.structureList = new LinkedHashSet<SStructure>();
			this.textList = new LinkedHashSet<STextualDS>();
			this.timelineList = new LinkedHashSet<STimeline>();
			this.tokenList = new LinkedHashSet<SToken>();
			this.otherNodeList = new LinkedHashSet<SNode>();
			
			EList<Node> startNodes= docGraph.getRoots();
			if (startNodes== null)
			{
				startNodes= new BasicEList<Node>();
				if (	(this.getSDocumentGraph().getSTokens()!= null) &&
						(this.getSDocumentGraph().getSTokens().size()>0))
						startNodes.add(this.getSDocumentGraph().getSTokens().get(0));
			}
			if (	(startNodes!= null)&&
					(startNodes.size() >0))
				docGraph.traverse(startNodes, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "Dot_top_down", this);
		    
			
			// primary texts should be on the bottom
		    if(textList.size() > 0)
			{
				currOutputStream.println("{");
				currOutputStream.println("rank=max;");
				for(STextualDS n : textList)
				{
					printSTextualDS(n);
				}
				currOutputStream.println("}");
			}
			
			// put timeline on separate layer
			if(timelineList.size() > 0)
			{
				currOutputStream.println("{");
				currOutputStream.println("rank=same;");
				for(STimeline n : timelineList)
				{
					printSTimeline(n);
				}
				currOutputStream.println("}");
			}
			
			// put all token on same layer
			if(tokenList.size() > 0)
			{
				currOutputStream.println("{");
				currOutputStream.println("rank=same;");
				for(SToken n : tokenList)
				{
					printSToken(n);
				}
				currOutputStream.println("}");
			}
			
			// put all spans on same layer
		    if(spanList.size() > 0)
			{
				currOutputStream.println("{");
				currOutputStream.println("rank=same;");
				for(SSpan n : spanList)
				{
					printSSpan(n);
				}
				currOutputStream.println("}");
			}
			
			// no specific ordering for structured nodes and other nodes
			for(SStructure n : structureList)
			{
				printSStructure(n);
			}
			
			for(SNode n : otherNodeList)
			{
				printSNode(n);
			}
			
			
			{//some nodes have no roots for example if they are part of a cycle, they have to be still stored
				if (visitedNodes.size() != this.getSDocumentGraph().getSNodes().size())
				{//if both lists doesn't have the same size create difference
					//contains all nodes, which wasn' t visited while first traversal
					EList<Node> forgottenNodes= new BasicEList<Node>();
					for (Node node: this.getSDocumentGraph().getSNodes())
					{
						if (!visitedNodes.contains(node))
							forgottenNodes.add(node);
					}
					if (forgottenNodes.size()== 0)
						throw new SaltResourceException("There are some nodes, which hasn' t been printed because of an unknown reason.");
					else
					{//traverse again
						docGraph.traverse(forgottenNodes, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "dot_forgotten_nodes", this);
					}//traverse again
				}//if both lists doesn't have the same size create difference
			}//some nodes have no roots for example if they are part of a cycle, they have to be still stored
		}
		else 
		{
			this.currOutputStream.println("<empty>[color= red, style = filled]");
		}	
		this.currOutputStream.println("}");
		//close and flusch stream
		this.currOutputStream.flush();
		this.currOutputStream.close();
	}
	
	/**
	 * Creates all annotation for dotNode comming from SAnnotation. This methode also
	 * includes traversing recursive Annotations (meta annotations).
	 * @param sAnno salt object form which all annotations come
	 * @return returns a label for dot node
	 */
	private String createAnnotations(SAnnotation sAnno)
	{
		String retStr= null;
		
		String anno= null;
		if (sAnno.getSValue()!= null)
		{
			anno= sAnno.getSValue().toString().replace("\"", "\\\"");
			anno= anno.replace("\n", "\\n");
			anno= anno.replace("\r", "\\r");
		}
		
		if ((retStr!= null) && (!retStr.isEmpty()))		
		{
				retStr= (sAnno.getQName()+"="+anno+"\\{"+retStr+"\\}");
		}
		else	
		{
			retStr= (sAnno.getQName()+"="+anno);
		}
		
		return(retStr);
	}
	
	/**
	 * Namespace for dot flags
	 */
	protected static final String KW_DOT_NS=	"dot::";
	/**
	 * String to identify a flag in salt elements or relations, which say that the current 
	 * element or relation has already been stored or not
	 */
	protected static final String KW_DOT_STORED=	KW_DOT_NS+"stored";
	
	@Override
	public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType,
			String traversalId, Edge edge, Node currNode, long order) {
		return(true);
	}
	

	@Override
	public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId,
			Node currNode, Edge edge, Node fromNode, long order) {
	}
	
	
	private DOTNode getDOTNode(SNode currSNode)
	{
		DOTNode dotNode= new DOTNode();
		dotNode.id= currSNode.getId().toString();
			
		//print sName
		if (currSNode.getSName()!= null)
			dotNode.labels.add("sName"+"= "+currSNode.getSName());
		
		//create all annotations incl. meta annotations
		for (SAnnotation sAnno: currSNode.getSAnnotations())
		{
			dotNode.labels.add(this.createAnnotations(sAnno));
		}
		
		visitedNodes.add(currSNode);
		return dotNode;
	}
	
	private void printDOTNode(DOTNode dotNode)
	{
		this.currOutputStream.println(dotNode.toString());
	}
	
	private void printSTextualDS(STextualDS t)
	{
		DOTNode dotNode = getDOTNode(t);
		
		dotNode.color= "yellow"; 
		dotNode.style = "filled";
		dotNode.shape = "Mrecord";
		String text = t.getSText();
		if (text != null) {//preparing text for dot
			//replace " with \"
			text = text.replace("\"", "\\\"");
			//replace " with \n"
			text = text.replace("\n", "");
			text = text.replace("\r", "");
		}//preparing text for dot   
		dotNode.labels.add("text=" + text);
		printDOTNode(dotNode);
	}
	
	private void printSToken(SToken currSNode)
	{
		DOTNode dotNode = getDOTNode(currSNode);
		
		dotNode.color = "turquoise";
		dotNode.style = "filled";
		dotNode.shape = "Mrecord";
		printDOTNode(dotNode);
	}
	
	private void printSTimeline(STimeline currSNode)
	{
		DOTNode dotNode = getDOTNode(currSNode);
		
		dotNode.color = "gray";
		dotNode.style = "filled";
		dotNode.shape = "Mrecord";
		dotNode.labels.add("time=" + ((STimeline) currSNode).getSPointsOfTime());
		printDOTNode(dotNode);
	}
	
	private void printSSpan(SSpan currSNode)
	{
		DOTNode dotNode = getDOTNode(currSNode);

		dotNode.color = "dodgerblue3";
		dotNode.style = "filled";
		dotNode.shape = "Mrecord";
		printDOTNode(dotNode);
	}
		
	private void printSStructure(SStructure currSNode)
	{
		DOTNode dotNode = getDOTNode(currSNode);

		dotNode.color = "seagreen";
		dotNode.style = "filled";
		dotNode.shape = "Mrecord";
		printDOTNode(dotNode);
	}
	
	private void printSNode(SNode currSNode)
	{
		DOTNode dotNode = getDOTNode(currSNode);

		dotNode.color = "red";
		dotNode.shape = "Mrecord";
		dotNode.style = "filled";
		printDOTNode(dotNode);
	}
		
	
	@Override
	public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType,
			String traversalId, Node currNode, Edge edge, Node fromNode,
			long order) 
	{
		SRelation relation= null;
		SNode currSNode= (SNode) currNode;
		SNode fromSNode= null;
		if (edge!= null) 
		{
			relation= (SRelation) edge;
		}
		if (fromNode!= null) 
		{
			fromSNode= (SNode) fromNode;
		}
		
		//------------------------------- Elements of a document
		//STEXTUAL_DATASOURCE
		if (currSNode instanceof STextualDS)
		{
			textList.add((STextualDS) currSNode);
		}
		//STIMELINE
		else if (currSNode instanceof STimeline)
		{
			timelineList.add((STimeline) currSNode);
		}
		//STOKEN
		else if (currSNode instanceof SToken)
		{
			tokenList.add((SToken) currSNode);
		}
		//SSpan
		else if (currSNode instanceof SSpan)
		{
			spanList.add((SSpan) currSNode);
		}
		//SSTRUCTURE
		else if (currSNode instanceof SStructure)
		{
			structureList.add((SStructure) currSNode);
		}
		else 
		{
			otherNodeList.add(currSNode);
		}		
		
		//print relation, if exists
		if (relation!= null)
		{
			DOTEdge dotEdge= new DOTEdge();
			dotEdge.fromId= fromSNode.getId().toString();
			dotEdge.toId= currSNode.getId().toString();	
			
//			//print sName
//			if (relation.getSName()!= null)
//				dotEdge.labels.add("sName"+"= "+relation.getSName());
			
			{//print edge type, if exists
				EList<String> sTypes= relation.getSTypes(); 
				if (	(sTypes!= null) &&
						(sTypes.size() > 0))
				{
					String dotString= "";
					for (String sType: sTypes)
					{	
						if (dotString.isEmpty()) 
						{
							dotString= sType;
						}
						else 
						{
							dotString= dotString + sType+ ", ";
						}
					}
					dotString= "sTypes= ["+ dotString +"]";
					
					dotEdge.labels.add(dotString);
				}
			}
			for (SAnnotation sAnno: relation.getSAnnotations())
			{
				dotEdge.labels.add(sAnno.getQName()+"= "+sAnno.getSValueSTEXT());
			}
						
			//STEXTUAL_RELATION
			if (relation instanceof STextualRelation)
			{
				dotEdge.color= "yellow";
				dotEdge.style= "filled";
			}
			//STimelineRelation
			else if (relation instanceof STimelineRelation)
			{
				dotEdge.color= "gray";
				dotEdge.style= "filled";
			}
			//SPANNING_RELATION
			else if (relation instanceof SSpanningRelation)
			{
				dotEdge.color= "dodgerblue3";
				dotEdge.style= "filled";
			}
			//SDOMINANCE_RELATION
			else if (relation instanceof SDominanceRelation)
			{
				dotEdge.color= "seagreen";
				dotEdge.style= "filled";
			}
			//SPOINTING_RELATION
			else if (relation instanceof SPointingRelation)
			{
				dotEdge.color= "blue";
				dotEdge.style= "filled";
			}
			//if relation is already stored don't store again
			if (relation.getSProcessingAnnotation(KW_DOT_STORED)!= null);
			else
			{
				this.currOutputStream.println(dotEdge.toString());
				//flag the current element
				{
					SProcessingAnnotation spAnno= SaltCommonFactory.eINSTANCE.createSProcessingAnnotation();
					spAnno.setQName(KW_DOT_STORED);
					relation.addSProcessingAnnotation(spAnno);
				}
			}
		}		
	}
}
