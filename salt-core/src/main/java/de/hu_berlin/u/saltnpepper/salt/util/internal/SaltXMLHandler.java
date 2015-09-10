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
package de.hu_berlin.u.saltnpepper.salt.util.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import de.hu_berlin.u.saltnpepper.graph.IdentifiableElement;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.LabelableElement;
import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SLayer;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInsertionException;

/**
 * This class reads the XMI structure of SaltXML and creates the corresponding
 * Salt object.
 * 
 * @author florian
 *
 */
public class SaltXMLHandler extends DefaultHandler2 {
	private static final Logger logger = LoggerFactory.getLogger(SaltXMLHandler.class);

	public static final String ATT_TYPE = "xsi:type";
	public static final String ATT_SOURCE = "source";
	public static final String ATT_TARGET = "target";
	public static final String ATT_LAYERS = "layers";

	// salt-graph
	public static final String TAG_NODES = "nodes";
	public static final String TAG_EDGES = "edges";
	public static final String TAG_LABELS = "labels";
	public static final String TAG_LAYERS = "layers";

	public static final String ATT_NAMESPACE = "namespace";
	public static final String ATT_NAME = "name";
	public static final String ATT_VALUE = "value";
	public static final String ATT_VALUE_STRING = "valueString";

	// salt-saltCore
	public static final String TYPE_SFEATURE = "saltCore:SFeature";
	public static final String TYPE_SELEMENTID = "saltCore:SElementId";
	public static final String TYPE_SANNOTATION = "saltCore:SAnnotation";
	public static final String TYPE_SMETAANNOTATION = "saltCore:SMetaAnnotation";
	public static final String TYPE_SPROCESSINGANNOTATION = "saltCore:SProcessingAnnotation";

	// salt-saltCommon
	public static final String TAG_SDOCUMENT = "sDocument";
	public static final String TAG_SDOCUMENT_GRAPH = "sDocumentStructure:SDocumentGraph";
	public static final String TAG_SALT_PROJECT = "saltCommon:SaltProject";
	public static final String TAG_SCORPUS_GRAPH = "sCorpusGraphs";

	public static final String ATT_SNAME = "sName";

	public static final String TYPE_SCORPUS = "sCorpusStructure:SCorpus";
	public static final String TYPE_SDOCUMENT = "sCorpusStructure:SDocument";
	public static final String TYPE_SCORPUS_DOCUMENT_RELATION = "sCorpusStructure:SCorpusDocumentRelation";
	public static final String TYPE_SCORPUS_RELATION = "sCorpusStructure:SCorpusRelation";

	public static final String TYPE_STIMELINE = "sDocumentStructure:STimeline";
	public static final String TYPE_SAUDIODS = "sDocumentStructure:SAudioDS";
	public static final String TYPE_STEXTUALDS = "sDocumentStructure:STextualDS";
	public static final String TYPE_STOKEN = "sDocumentStructure:SToken";
	public static final String TYPE_SSPAN = "sDocumentStructure:SSpan";
	public static final String TYPE_SSTRUCTURE = "sDocumentStructure:SStructure";
	public static final String TYPE_STEXTUAL_RELATION = "sDocumentStructure:STextualRelation";
	public static final String TYPE_SAUDIO_RELATION = "sDocumentStructure:SAudioRelation";
	public static final String TYPE_STIMELINE_RELATION = "sDocumentStructure:STimelineRelation";
	public static final String TYPE_SSPANNING_RELATION = "sDocumentStructure:SSpanningRelation";
	public static final String TYPE_SORDER_RELATION = "sDocumentStructure:SOrderRelation";
	public static final String TYPE_SDOMINANCE_RELATION = "sDocumentStructure:SDominanceRelation";
	public static final String TYPE_SPOINTING_RELATION = "sDocumentStructure:SPointingRelation";

	public static final String TYPE_SPOS = "saltSemantics:SPOSAnnotation";
	public static final String TYPE_SLEMMA = "saltSemantics:SLemmaAnnotation";
	public static final String TYPE_SCAT = "saltSemantics:SCatAnnotation";
	public static final String TYPE_SSENTENCE = "saltSemantics:SentenceAnnotation";
	public static final String TYPE_SWORD = "saltSemantics:SWordAnnotation";
	public static final String TYPE_STYPE = "saltSemantics:STypeAnnotation";

	public SaltXMLHandler() {
		nodes = new ArrayList<SNode>();
		relations = new ArrayList<SRelation>();
		layers = new HashMap<String, SLayer>();
		currentContainer = new Stack<Object>();
	}

	private Object saltObject = null;

	/**
	 * Sets the Salt object to be returned. This should be the root container
	 * object of the passed file. This object is only set once.
	 * 
	 **/
	private void setSaltObject(Object saltObject) {
		if (this.saltObject == null) {
			this.saltObject = saltObject;
		}
	}

	/**
	 * Returns the object, which has been loaded.
	 * 
	 * @return
	 */
	public Object getSaltObject() {
		return saltObject;
	}

	/** This is a container object mostly used for labels. **/
	private Stack<Object> currentContainer = null;
	/** current salt project if file is a corpus structure **/
	private SaltProject saltProject = null;

	/** a list of all read nodes **/
	private List<SNode> nodes = null;
	/** a list of all read edges **/
	private List<SRelation> relations = null;
	/** a list of all read layers **/
	private Map<String, SLayer> layers = null;
	/** stores the position of the current read layer **/
	private Integer layerIdx = 0;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (TAG_SALT_PROJECT.equals(qName)) {
			SaltProject project = SaltFactory.createSaltProject();
			setSaltObject(project);
			saltProject = project;
			String sName = attributes.getValue(ATT_SNAME);
			if (sName != null) {
				project.setName(sName);
			}
			currentContainer.push(project);
		} else if (TAG_SCORPUS_GRAPH.equals(qName)) {
			SCorpusGraph graph = SaltFactory.createSCorpusGraph();
			setSaltObject(graph);
			if (saltProject != null) {
				saltProject.getCorpusGraphs().add(graph);
			}
			currentContainer.push(graph);
		} else if (TAG_SDOCUMENT_GRAPH.equals(qName)) {
			SDocumentGraph graph = SaltFactory.createSDocumentGraph();
			setSaltObject(graph);
			currentContainer.push(graph);
		} else if (TAG_NODES.equals(qName)) {
			SNode sNode = null;
			String type = attributes.getValue(ATT_TYPE);
			if (SaltXMLHandler.TYPE_SAUDIODS.equals(type)) {
				sNode = SaltFactory.createSMedialDS();
			} else if (SaltXMLHandler.TYPE_STEXTUALDS.equals(type)) {
				sNode = SaltFactory.createSTextualDS();
			} else if (SaltXMLHandler.TYPE_STIMELINE.equals(type)) {
				sNode = SaltFactory.createSTimeline();
			} else if (TYPE_STOKEN.equals(type)) {
				sNode = SaltFactory.createSToken();
			} else if (TYPE_SSPAN.equals(type)) {
				sNode = SaltFactory.createSSpan();
			} else if (TYPE_SSTRUCTURE.equals(type)) {
				sNode = SaltFactory.createSStructure();
			} else if (TYPE_SCORPUS.equals(type)) {
				sNode = SaltFactory.createSCorpus();
			} else if (TYPE_SDOCUMENT.equals(type)) {
				sNode = SaltFactory.createSDocument();
			}
			if (sNode != null) {
				setSaltObject(sNode);
				currentContainer.push(sNode);
				nodes.add(sNode);
			}
			String layersStr = attributes.getValue(ATT_LAYERS);
			if (layersStr != null) {
				layersStr = layersStr.replace("//@layers.", "");
				String[] layerNums = layersStr.split(" ");
				if (layerNums.length > 0) {
					for (String layerNum : layerNums) {
						SLayer layer = layers.get(layerNum);
						if (layer == null) {
							layer = SaltFactory.createSLayer();
							layers.put(layerNum, layer);
						}
						sNode.addLayer(layer);
					}
				}
			}
		} else if (TAG_EDGES.equals(qName)) {
			SRelation sRel = null;
			String type = attributes.getValue(ATT_TYPE);
			String source = attributes.getValue(ATT_SOURCE);
			String target = attributes.getValue(ATT_TARGET);
			if (SaltXMLHandler.TYPE_STEXTUAL_RELATION.equals(type)) {
				sRel = SaltFactory.createSTextualRelation();
			} else if (SaltXMLHandler.TYPE_SAUDIO_RELATION.equals(type)) {
				sRel = SaltFactory.createSMedialRelation();
			} else if (SaltXMLHandler.TYPE_STIMELINE_RELATION.equals(type)) {
				sRel = SaltFactory.createSTimelineRelation();
			} else if (SaltXMLHandler.TYPE_SSPANNING_RELATION.equals(type)) {
				sRel = SaltFactory.createSSpanningRelation();
			} else if (SaltXMLHandler.TYPE_SORDER_RELATION.equals(type)) {
				sRel = SaltFactory.createSOrderRelation();
			} else if (SaltXMLHandler.TYPE_SDOMINANCE_RELATION.equals(type)) {
				sRel = SaltFactory.createSDominanceRelation();
			} else if (SaltXMLHandler.TYPE_SPOINTING_RELATION.equals(type)) {
				sRel = SaltFactory.createSPointingRelation();
			} else if (SaltXMLHandler.TYPE_SCORPUS_RELATION.equals(type)) {
				sRel = SaltFactory.createSCorpusRelation();
			} else if (SaltXMLHandler.TYPE_SCORPUS_DOCUMENT_RELATION.equals(type)) {
				sRel = SaltFactory.createSCorpusDocumentRelation();
			}
			if ((sRel != null) && (target != null) && (source != null)) {
				setSaltObject(sRel);

				Integer sourceIdx = Integer.parseInt(source.replaceAll("((//@sCorpusGraphs[.]0)|/)/@nodes.", ""));
				sRel.setSource(nodes.get(sourceIdx));
				Integer targetIdx = Integer.parseInt(target.replaceAll("((//@sCorpusGraphs[.]0)|/)/@nodes.", ""));
				sRel.setTarget(nodes.get(targetIdx));
				relations.add(sRel);
				currentContainer.push(sRel);
			}
			String layersStr = attributes.getValue(ATT_LAYERS);
			if (layersStr != null) {
				layersStr = layersStr.replace("//@layers.", "");
				String[] layerNums = layersStr.split(" ");
				if (layerNums.length > 0) {
					for (String layerNum : layerNums) {
						SLayer layer = layers.get(layerNum);
						if (layer == null) {
							layer = SaltFactory.createSLayer();
							layers.put(layerNum, layer);
						}
						sRel.addLayer(layer);
					}
				}
			}
		} else if (TAG_LABELS.equals(qName)) {
			Label label = null;
			String type = attributes.getValue(ATT_TYPE);
			String ns = attributes.getValue(ATT_NAMESPACE);
			String name = attributes.getValue(ATT_NAME);
			String value = attributes.getValue(ATT_VALUE_STRING);
			if (value == null) {
				value = attributes.getValue(ATT_VALUE);
			}
			if (TYPE_SELEMENTID.equals(type)) {
				if ((!currentContainer.isEmpty()) && (currentContainer.peek() instanceof IdentifiableElement)) {
					((IdentifiableElement) currentContainer.peek()).setId((String) createObjectFromString(value));
				}
				currentContainer.push("SElementId");
			} else if (TYPE_SFEATURE.equals(type)) {
				label = SaltFactory.createSFeature();
			} else if (TYPE_SANNOTATION.equals(type)) {
				label = SaltFactory.createSAnnotation();
			} else if (TYPE_SMETAANNOTATION.equals(type)) {
				label = SaltFactory.createSMetaAnnotation();
			} else if (TYPE_SPROCESSINGANNOTATION.equals(type)) {
				label = SaltFactory.createSProcessingAnnotation();
			} else if (TYPE_SPOS.equals(type)) {
				label = SaltFactory.createSPOSAnnotation();
			} else if (TYPE_SLEMMA.equals(type)) {
				label = SaltFactory.createSLemmaAnnotation();
			} else if (TYPE_SCAT.equals(type)) {
				label = SaltFactory.createSCatAnnotation();
			} else if (TYPE_SSENTENCE.equals(type)) {
				label = SaltFactory.createSSentenceAnnotation();
			} else if (TYPE_SWORD.equals(type)) {
				label = SaltFactory.createSWordAnnotation();
			} else if (TYPE_STYPE.equals(type)) {
				label = SaltFactory.createSTypeAnnotation();
			} else {
				label = SaltFactory.createSAnnotation();
			}
			if (label != null) {
				label.setNamespace(ns);
				label.setName(name);
				label.setValue(createObjectFromString(value));
				if ((!currentContainer.isEmpty()) && (currentContainer.peek() != null)) {
					try {
						Object container = currentContainer.peek();
						if (container instanceof LabelableElement) {
							((LabelableElement) container).addLabel(label);
						}
					} catch (SaltInsertionException e) {
						logger.warn("A label having the name '" + label.getNamespace() + ":" + label.getName() + "' already exists for container '" + currentContainer.peek() + "' and could not be added twice.");
					}
				}

				setSaltObject(label);
				currentContainer.push(label);
			}
		} else if (TAG_LAYERS.equals(qName)) {
			SLayer layer = layers.get(layerIdx.toString());
			if (layer == null) {
				layer = SaltFactory.createSLayer();
			}
			if (currentContainer.peek() instanceof SDocumentGraph) {
				((SDocumentGraph) currentContainer.peek()).addLayer(layer);
			}
			currentContainer.push(layer);
			layerIdx++;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (!currentContainer.isEmpty()) {
			Object obj = currentContainer.pop();
			Object parent = null;
			if (!currentContainer.isEmpty()) {
				parent = currentContainer.peek();
			}
			if (TAG_NODES.equals(qName)) {
				if (parent != null) {
					if (parent instanceof SDocumentGraph) {
						((SDocumentGraph) currentContainer.peek()).addNode((SNode) obj);
					} else if (parent instanceof SCorpusGraph) {
						((SCorpusGraph) currentContainer.peek()).addNode((SNode) obj);
					}
				}
			} else if (TAG_EDGES.equals(qName)) {
				if (parent != null) {
					if (parent instanceof SDocumentGraph) {
						((SDocumentGraph) currentContainer.peek()).addRelation((SRelation) obj);
					} else if (parent instanceof SCorpusGraph) {
						((SCorpusGraph) currentContainer.peek()).addRelation((SRelation) obj);
					}
				}
			}
		}
	}

	public Object createObjectFromString(String value) {
		Object retVal = null;
		if ((value == null) || (value.length() < 3)) {
		} else if (value.startsWith("T")) {
			retVal = StringEscapeUtils.unescapeXml(value.substring(3));
		} else if (value.startsWith("B")) {
			retVal = Boolean.parseBoolean(StringEscapeUtils.unescapeXml(value.substring(3)));
		} else if (value.startsWith("N")) {
			retVal = Long.parseLong(StringEscapeUtils.unescapeXml(value.substring(3)));
		} else if (value.startsWith("F")) {
			retVal = Float.parseFloat(StringEscapeUtils.unescapeXml(value.substring(3)));
		} else if (value.startsWith("U")) {
			retVal = URI.createURI(StringEscapeUtils.unescapeXml(value.substring(3)));
		}
		return (retVal);
	}
}