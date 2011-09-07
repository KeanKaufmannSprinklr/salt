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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.reader;

import java.io.File;
import java.util.Properties;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.GrAFResource.GRAF_MAPPING_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

public class GrAFReader extends DefaultHandler2
{
	/**
	 * XML-element graph
	 */
	private static final String ELEMENT_GRAPH= "graph";
	/**
	 * XML-element region
	 */
	private static final String ELEMENT_REGION= "region";
	/**
	 * XML-element link
	 */
	private static final String ELEMENT_LINK= "link";
	/**
	 * XML-element node
	 */
	private static final String ELEMENT_NODE= "node";
	/**
	 * XML-element edge
	 */
	private static final String ELEMENT_EDGE= "edge";
	/**
	 * XML-element a
	 */
	private static final String ELEMENT_ANNOTATION= "a";
	/**
	 * XML-element fs
	 */
	private static final String ELEMENT_FEATURE_STRUCTURE= "fs";
	/**
	 * XML-element f
	 */
	private static final String ELEMENT_FEATURE= "f";
	/**
	 * Stores node, for links
	 */
//	private SNode currentSNode= null;
	private Stack<SNode> node_stack= new Stack<SNode>();  	
	/**
	 * the SDocumentGraph object, where all nodes, relations annotations etc. are supposed to be mapped in.
	 */
	private SDocumentGraph sDocumentGraph= null;

	public void setsDocumentGraph(SDocumentGraph sDocumentGraph) {
		this.sDocumentGraph = sDocumentGraph;
	}

	public SDocumentGraph getsDocumentGraph() {
		return sDocumentGraph;
	}
//	================================ start: currentSTextualDS
	/**
	 * If this GrAF document depends on a primary data file, {@link GrAFReader#currentSTextualDS}} will contain the correct STextualDS object
	 * corresponding the created primary data.
	 */
	private STextualDS currentSTextualDS= null;
	public void setCurrentSTextualDS(STextualDS currentSTextualDS) {
		this.currentSTextualDS = currentSTextualDS;
	}

	public STextualDS getCurrentSTextualDS() {
		return currentSTextualDS;
	}
//	================================ end: currentSTextualDS
	
// ========================================== start: fileResource
	/**
	 * the resource, from where the data shall be loaded.
	 */
	private File fileResource= null;
	/**
	 * Sets the resource, from where the data shall be loaded.
	 * @param destination the destination to set
	 */
	public void setFileResource(File destination) {
		this.fileResource = destination;
	}

	/**
	 * Returns the resource, from where the data shall be loaded.
	 * @return the destination
	 */
	public File getFileResource() {
		return fileResource;
	}
// ========================================== end: fileResource

// ========================================== start: grafType
	/**
	 * The name of the layer or the type, which is set by header file for this file.
	 */
	private String grafType= null; 
	
	public String getGrAFType() {
		return grafType;
	}

	public void setGrAFType(String grafType) {
		this.grafType = grafType;
	}
// ========================================== end: mappingType
	
// ========================================== start: mappingType
	/**
	 * The type of how to map data belonging to a GrAF type (layer) to Salt-elements. For the current layer file
	 */
	private GRAF_MAPPING_TYPE mappingType= null; 
	
	public GRAF_MAPPING_TYPE getMappingType() {
		return mappingType;
	}

	public void setMappingType(GRAF_MAPPING_TYPE mappingType) {
		this.mappingType = mappingType;
	}
// ========================================== end: mappingType

// =================================== start: mapping properties
	private Properties mappingProps= null;
	public void setMappingProps(Properties mappingProps) {
		this.mappingProps = mappingProps;
	}

	public Properties getMappingProps() {
		return mappingProps;
	}
// =================================== end: mapping properties
	/**
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	
	@Override
	public void startElement(	String uri,
            					String localName,
            					String qName,
            					Attributes attributes) throws SAXException
    {
		//DEBUG System.out.println("grafType: "+ this.getGrAFType()+ ", mapping type: "+ this.getMappingType());
		// get type of mapping from config file (default: structure)
		String config_map_type = GRAF_MAPPING_TYPE.HIERARCHIE.toString();
		config_map_type = this.getMappingType().toString();
		if(qName.equalsIgnoreCase(ELEMENT_REGION))
		{//xml-element is region
			// map region to sToken
			SToken sToken = SaltFactory.eINSTANCE.createSToken();
			// relate to its primary data resource
			STextualRelation sTextualRelation = SaltFactory.eINSTANCE.createSTextualRelation();
			sTextualRelation.setSToken(sToken);
			sTextualRelation.setSTextualDS(currentSTextualDS);
			// handle region attributes: xml:id - Name 
			sToken.setSName(attributes.getValue("xml:id"));
			// handle region attributes: atype - label
			String atype = attributes.getValue("atype");
			if (atype != null)
			{// optional attribute atype is given 
				//TODO add label  
			}// optional attribute atype is given
			// handle region attributes: anchors 
			String[] anchors= attributes.getValue("anchors").split(" ");
			if(anchors.length == 2)
			{// two anchors for region
				//DEBUG System.out.println(anchors[0]+","+anchors[1]);
				Integer start = null;
				Integer end = null;
				try {
					start= new Integer(anchors[0]);
					end= new Integer(anchors[1]);
				}catch (NumberFormatException e) 
				{
					throw new SaltResourceException("Cannot read given GrAF-file '"+this.getFileResource().getAbsolutePath()+"', because the start and end position of region is not convertable to a number.", e);
				}
				sTextualRelation.setSStart(start);
				sTextualRelation.setSEnd(end);
			}// two anchors for region
			else
			{
				throw new SaltResourceException("Only pairs of integer values are supported as region anchors by this version. They are interpreted as character-offsets to start and end position of region.");
			}
			getsDocumentGraph().addSNode(sToken);
			getsDocumentGraph().addSRelation(sTextualRelation);
		}//xml-element is region
		else if(qName.equalsIgnoreCase(ELEMENT_NODE))
		{//xml-element is node
			SNode sNode= null;
			// map nodes of this file to SSpan or SStructure	
			if (config_map_type.equalsIgnoreCase(GRAF_MAPPING_TYPE.SPAN.toString()))
			{//xml-element has to be mapped to a SSpan
				sNode= SaltCommonFactory.eINSTANCE.createSSpan();
			}//xml-element node will be mapped to SSpan
			else if (config_map_type.equalsIgnoreCase(GRAF_MAPPING_TYPE.HIERARCHIE.toString()))
			{//xml-element has to be mapped to a SStructure
				sNode= SaltCommonFactory.eINSTANCE.createSStructure();
			}//xml-element has to be mapped to a SStructure
			else if (config_map_type.equalsIgnoreCase(GRAF_MAPPING_TYPE.POINTER.toString()))
			{//xml-element cannot be mapped, pointing relations do not specify a node type
				//TODO Node Mapping Type vs. Edge Mapping Type? Mapping Type pointer means 'edge-only' files?
			}//xml-element cannot be mapped, pointing relations do not specify a node type
			else
			{//xml-element cannot be mapped
				throw new SaltResourceException("Cannot handle mapping type "+config_map_type+". Only mapping types "+GRAF_MAPPING_TYPE.SPAN.toString()+", "+GRAF_MAPPING_TYPE.HIERARCHIE.toString()+", "+GRAF_MAPPING_TYPE.POINTER.toString()+" are handled by this version.");
			}//xml-element cannot be mapped
			if (sNode!= null)
			{//to some general things for every node
				sNode.setSName(attributes.getValue("xml:id"));
				this.node_stack.push(sNode);
//				if (this.currentSLayer!= null)
//					this.currentSLayer.getSNodes().add(sNode);
//				this.currentSNode= sNode;
//				this.nodeId2SNode.put(attributes.getValue("id"), sNode);
				this.getsDocumentGraph().addSNode(sNode);
			}//to some general things for every node
		}
		else if(qName.equalsIgnoreCase(ELEMENT_GRAPH))
		{//xml-element is graph
			// do nothing
		}//xml-element is graph
		else if(qName.equalsIgnoreCase(ELEMENT_LINK))
		{//xml-element is link
			//System.out.println(node_stack.peek());
		}//xml-element is link
		else if(qName.equalsIgnoreCase(ELEMENT_EDGE))
		{//xml-element is edge
			SRelation sRelation = null;
			// map edges of this file to SSpanningRelation, SDominanceRelation or SPointingRelation	
			if (config_map_type.equalsIgnoreCase(GRAF_MAPPING_TYPE.SPAN.toString()))
			{//xml-element has to be mapped to SSpanningRelation
				sRelation= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
			}//xml-element has to be mapped to SSpanningRelation
			else if (config_map_type.equalsIgnoreCase(GRAF_MAPPING_TYPE.HIERARCHIE.toString()))
			{//xml-element has to be mapped to SDominanceRelation
				sRelation= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			}//xml-element has to be mapped to SDominanceRelation
			else if (config_map_type.equalsIgnoreCase(GRAF_MAPPING_TYPE.POINTER.toString()))
			{//xml-element has to be mapped to SPointingRelation
				sRelation= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			}//xml-element has to be mapped to SPointingRelation
			else
			{//xml-element cannot be mapped
				throw new SaltResourceException("Cannot handle mapping type "+config_map_type+". Only mapping types "+GRAF_MAPPING_TYPE.SPAN.toString()+", "+GRAF_MAPPING_TYPE.HIERARCHIE.toString()+", "+GRAF_MAPPING_TYPE.POINTER.toString()+" are handled by this version.");
			}//xml-element cannot be mapped
			//System.out.println(getsDocumentGraph().getSNodes());
			if (sRelation!= null)
			{//to some general things for every edge
				//id is optional for edges - it if has one, it might be annotated
				String edgeId= null;
				edgeId= attributes.getValue("xml:id");
				if(edgeId!= null){
					sRelation.setSName(attributes.getValue("xml:id"));
				}
				System.out.println(sRelation.getSId()+" "+sRelation.getSName());
				this.getsDocumentGraph().addSRelation(sRelation);
			}//to some general things for every edge
		}//xml-element is edge
		else if(qName.equalsIgnoreCase(ELEMENT_ANNOTATION))
		{//xml-element is annot
			//TODO handle annotation
		}//xml-element is annot
		else if(qName.equalsIgnoreCase(ELEMENT_FEATURE_STRUCTURE))
		{//xml-element is fs
			//TODO handle feature structure		
		}//xml-element is fs
		else if(qName.equalsIgnoreCase(ELEMENT_FEATURE))
		{//xml-element is feature
			//TODO handle feature
		}//xml-element is feature
		else
		{// element not handled 
			throw new SaltResourceException("Cannot read given GrAF-file '"+this.getFileResource().getAbsolutePath()+"', because this version does not handle <"+qName+"/> elements.");
		}// element not handled
    }
	
	@Override
	public void endElement(		String uri,
            					String localName,
            					String qName) throws SAXException
    {
		if (ELEMENT_REGION.equalsIgnoreCase(qName))
		{
			//TODO do something
		}
    }

	
	
}