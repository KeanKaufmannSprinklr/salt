package de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.impl.SDocumentImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDominanceRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SMedialDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SMedialRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SOrderRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SPointingRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSequentialDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSequentialRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpan;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpanningRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SStructure;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SStructuredNode;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STimeline;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STimelineRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SToken;
import de.hu_berlin.u.saltnpepper.salt.common.tokenizer.Tokenizer;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SGraphImpl;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltElementNotInGraphException;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInsertionException;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltParameterException;
import de.hu_berlin.u.saltnpepper.salt.util.DataSourceSequence;
import de.hu_berlin.u.saltnpepper.salt.util.SALT_TYPE;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

@SuppressWarnings("serial")
public class SDocumentGraphImpl extends SGraphImpl implements SDocumentGraph {

	/**
	 * Calls the init of super class and expands its initialization for adding
	 * {@link SaltUtil#IDX_NODETYPE} of indexes:
	 * <ul>
	 * <li>Initializes index {@link SaltUtil#IDX_NODETYPE}</li>
	 * <li>Initializes index {@link SaltUtil#IDX_RELATIONTYPE}</li>
	 * </ul>
	 */
	@Override
	protected void init() {
		super.init();

		indexMgr.createIndex(SaltUtil.IDX_NODETYPE, Class.class, Node.class, expectedNodes / 2, expectedNodes);
		indexMgr.createIndex(SaltUtil.IDX_RELATIONTYPE, Class.class, Relation.class, expectedRelations / 2, expectedRelations);
	}

	// ============================ start: handling relations
	/**
	 * Calls the super method an puts the given relation into a relation type
	 * index. an exception will be thrown.
	 * 
	 * @param relation
	 *            to add
	 */
	@Override
	protected void basicAddRelation(Relation<? extends Node, ? extends Node> relation) {
		if (relation != null) {
			if (!(relation instanceof SRelation)) {
				throw new SaltInsertionException(this, relation, "Cannot insert an relation, which is not a SRelation object.");
			}
			// start: create a name if none exists
			if ((((SRelation) relation).getName() == null) || (((SRelation) relation).getName().isEmpty())) {
				if (relation instanceof STextualRelation) {
					((SRelation) relation).setName("sTextRel" + (getTextualRelations().size() + 1));
				} else if (relation instanceof STimelineRelation) {
					((SRelation) relation).setName("sTimeRel" + (getTimelineRelations().size() + 1));
				} else if (relation instanceof SSpanningRelation) {
					((SRelation) relation).setName("sSpanRel" + (getSpanningRelations().size() + 1));
				} else if (relation instanceof SPointingRelation) {
					((SRelation) relation).setName("sPointingRel" + (getPointingRelations().size() + 1));
				} else if (relation instanceof SDominanceRelation) {
					((SRelation) relation).setName("sDomRel" + (getDominanceRelations().size() + 1));
				} else if (relation instanceof SMedialRelation) {
					((SRelation) relation).setName("sAudioRel" + (getMedialRelations().size() + 1));
				} else if (relation instanceof SOrderRelation) {
					((SRelation) relation).setName("sOrderRel" + (getOrderRelations().size() + 1));
				} else {
					((SRelation) relation).setName("sRel" + (getRelations().size() + 1));
				}
			}
			// end: create a name if none exists
			((SRelation) relation).setId(getId() + "#" + ((SRelation) relation).getName());
			super.basicAddRelation(relation);

			Class<?> key;
			// map some implementation types to the matching interfaces
			if (relation instanceof STextualRelation) {
				key = STextualRelation.class;
			} else if (relation instanceof STimelineRelation) {
				key = STimelineRelation.class;
			} else if (relation instanceof SSpanningRelation) {
				key = SSpanningRelation.class;
			} else if (relation instanceof SPointingRelation) {
				key = SPointingRelation.class;
			} else if (relation instanceof SDominanceRelation) {
				key = SDominanceRelation.class;
			} else if (relation instanceof SMedialRelation) {
				key = SMedialRelation.class;
			} else if (relation instanceof SOrderRelation) {
				key = SOrderRelation.class;
			} else {
				key = relation.getClass();
			}

			getIndexMgr().put(SaltUtil.IDX_RELATIONTYPE, key, relation);
		}
	}

	// ============================ end: handling relations
	// ============================ start: handling nodes
	/**
	 * Calls the super method an puts the given node into a node type index. an
	 * exception will be thrown.
	 * 
	 * @param node
	 *            to add
	 */
	@Override
	protected void basicAddNode(SNode node) {
		if (node != null) {
			if (!(node instanceof SNode)) {
				throw new SaltInsertionException(this, node, "Cannot insert a node, which is not a SNode object. ");
			}
			// start: create a name if none exists
			if ((((SNode) node).getName() == null) || (((SNode) node).getName().isEmpty())) {
				if (node instanceof STextualDS) {
					((SNode) node).setName("sText" + (getTextualDSs().size() + 1));
				} else if (node instanceof SToken) {
					((SNode) node).setName("sTok" + (getTokens().size() + 1));
				} else if (node instanceof STimeline) {
					((SNode) node).setName("sTimeline" + (getTokens().size() + 1));
				} else if (node instanceof SSpan) {
					((SNode) node).setName("sSpan" + (getSpans().size() + 1));
				} else if (node instanceof SStructure) {
					((SNode) node).setName("structure" + (getStructures().size() + 1));
				} else if (node instanceof SMedialDS) {
					((SNode) node).setName("audio" + (getMedialDSs().size() + 1));
				} else {
					((SNode) node).setName("sNode" + (getNodes().size() + 1));
				}
			}
			// end: create a name if none exists

			if ((((SNode) node).getId() == null) || (((SNode) node).getId().isEmpty())) {
				((SNode) node).setId(getId() + "#" + ((SNode) node).getName());
			}
			super.basicAddNode(node);

			// map some implementation types to the matching interfaces
			Class<?> key;
			if (node instanceof SToken) {
				key = SToken.class;
			} else if (node instanceof STextualDS) {
				key = STextualDS.class;
			} else if (node instanceof STimeline) {
				key = STimeline.class;
			} else if (node instanceof SSpan) {
				key = SSpan.class;
			} else if (node instanceof SStructure) {
				key = SStructure.class;
			} else if (node instanceof SMedialDS) {
				key = SMedialDS.class;
			} else {
				key = node.getClass();
			}

			getIndexMgr().put(SaltUtil.IDX_NODETYPE, key, node);
		}
	}

	/** {@inheritDoc} **/
	@Override
	public SDocument getDocument() {
		SDocument retVal = null;
		SFeature sFeature = getFeature(SaltUtil.FEAT_SDOCUMENT_QNAME);
		if (sFeature != null) {
			retVal = (SDocument) sFeature.getValue();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public void setDocument(SDocument document) {
		SDocument oldDocument = getDocument();
		if ((oldDocument != null) && (oldDocument != document)) {
			if (oldDocument instanceof SDocumentImpl) {
				((SDocumentImpl) oldDocument).basic_setDocumentGraph(null);
			}
		}
		if (document != null) {
			if (document instanceof SDocumentImpl) {
				((SDocumentImpl) document).basic_setDocumentGraph(this);
			}
		}
		basic_setDocument(document);
	}

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link SDocument} and {@link SDocumentGraph} object when a document is
	 * set to avoid an endless invocation. The invocation of methods is
	 * implement as follows:
	 * 
	 * <pre>
	 * {@link #setSDocument(SDocument)}                      {@link SDocument#setSDocumentGraph(Graph)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link #basicSDocument(SDocument)}            {@link SDocument#basicSetSDocumentGraph(Graph)}
	 * </pre>
	 * 
	 * @param document
	 *            the container document of this document graph
	 */
	public void basic_setDocument(SDocument document) {
		SFeature sFeature = getFeature(SaltUtil.FEAT_SDOCUMENT_QNAME);
		if (sFeature == null) {
			// create a new sFeature
			sFeature = SaltFactory.createSFeature();
			sFeature.setNamespace(SaltUtil.SALT_NAMESPACE);
			sFeature.setName(SaltUtil.FEAT_SDOCUMENT);
			addFeature(sFeature);
		}
		sFeature.setValue(document);
	}

	/** {@inheritDoc} **/
	@Override
	public List<STextualDS> getTextualDSs() {
		List<STextualDS> retVal = getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, STextualDS.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<STextualRelation> getTextualRelations() {
		List<STextualRelation> retVal = getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, STextualRelation.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> getTokens() {
		List<SToken> retVal = getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SToken.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public STimeline getTimeline() {
		return (getIndexMgr().get(SaltUtil.IDX_NODETYPE, STimeline.class));
	}

	/** {@inheritDoc} **/
	@Override
	public void setTimeline(STimeline value) {
		addNode(value);
	}

	/** {@inheritDoc} **/
	@Override
	public List<STimelineRelation> getTimelineRelations() {
		List<STimelineRelation> retVal = getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, STimelineRelation.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SSpanningRelation> getSpanningRelations() {
		List<SSpanningRelation> retVal = getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SSpanningRelation.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SSpan> getSpans() {
		List<SSpan> retVal = getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SSpan.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SStructure> getStructures() {
		List<SStructure> retVal = getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SStructure.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SDominanceRelation> getDominanceRelations() {
		List<SDominanceRelation> retVal = getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SDominanceRelation.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SPointingRelation> getPointingRelations() {
		List<SPointingRelation> retVal = getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SPointingRelation.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SMedialRelation> getMedialRelations() {
		List<SMedialRelation> retVal = getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SMedialRelation.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SMedialDS> getMedialDSs() {
		List<SMedialDS> retVal = getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SMedialDS.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SOrderRelation> getOrderRelations() {
		List<SOrderRelation> retVal = getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SOrderRelation.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public SRelation addNode(SNode source, SNode target, SALT_TYPE sRelationType) {
		if (!getNodes().contains(source)) {
			throw new SaltElementNotInGraphException(this, source, "Given SNode cannot be used as source node, because it is not contained in the SDocumentGraph");
		}
		SRelation retVal = null;
		switch (sRelationType) {
		case STEXTUAL_RELATION:
			retVal = SaltFactory.createSTextualRelation();
			break;
		case SPOINTING_RELATION:
			retVal = SaltFactory.createSPointingRelation();
			break;
		case SSPANNING_RELATION:
			retVal = SaltFactory.createSSpanningRelation();
			break;
		case SDOMINANCE_RELATION:
			retVal = SaltFactory.createSDominanceRelation();
			break;
		default:
			;
		}
		if (retVal == null) {
			throw new SaltParameterException("Improper STYPE_NAME for this method; must be one of STEXTUAL_RELATION, SPOINTING_RELATION, SSPANNING_RELATION and SDOMINANCE_RELATION.");
		}
		retVal.setSource(source);
		retVal.setTarget(target);
		if (!getNodes().contains(target)) {
			addNode(target);
		}
		addRelation(retVal);
		return retVal;
	}

	/** {@inheritDoc} **/
	@Override
	public STextualDS createTextualDS(String text) {
		STextualDS sTextualDS = SaltFactory.createSTextualDS();
		sTextualDS.setText(text);
		addNode(sTextualDS);
		return (sTextualDS);
	}

	/** {@inheritDoc} **/
	@Override
	public SToken createToken(List<DataSourceSequence> sequences) {
		if (sequences == null) {
			throw new SaltParameterException("sDSSequences", "addSToken", this.getClass());
		}
		if (sequences.size() > 0) {
			SToken sToken = SaltFactory.createSToken();
			this.addNode(sToken);
			for (DataSourceSequence sequence : sequences) {
				addToken(sToken, sequence);
			}
			return (sToken);
		} else {
			return (null);
		}
	}

	/**
	 * Connects the given {@link SToken} object to the given
	 * {@link SSequentialDS} object. If the given {@link SToken} object is not
	 * already add to the graph, it will be added.
	 * 
	 * @param token
	 *            token to connect to the {@link SSequentialDS} object
	 * @param sequence
	 *            object containing the {@link SSequentialDS} object and the
	 *            borders, to which the token points to
	 */
	private void addToken(SToken token, DataSourceSequence sequence) {
		if (sequence == null) {
			throw new SaltParameterException("sDSSequence", "addSToken", this.getClass());
		}
		if (sequence.getDataSource() == null) {
			throw new SaltParameterException("sDSSequences.getSSequentialDS()", "addSToken", this.getClass());
		}
		if (sequence.getStart() == -1) {
			throw new SaltParameterException("sDSSequences.getSStart()", "addSToken", this.getClass());
		}
		if (sequence.getEnd() == -1) {
			throw new SaltParameterException("sDSSequences.getSEnd()", "addSToken", this.getClass());
		}
		if ((token.getId() == null) || (getNode(token.getId()) == null)) {
			addNode(token);
		}

		SSequentialRelation seqRel = null;

		if (sequence.getDataSource() instanceof STextualDS) {
			seqRel = SaltFactory.createSTextualRelation();
			((STextualRelation) seqRel).setTarget((STextualDS) sequence.getDataSource());
		} else if (sequence.getDataSource() instanceof STimeline) {
			seqRel = SaltFactory.createSTimelineRelation();
			((STimelineRelation) seqRel).setTarget((STimeline) sequence.getDataSource());
		}
		seqRel.setSource(token);
		seqRel.setStart(sequence.getStart());
		seqRel.setEnd(sequence.getEnd());
		addRelation(seqRel);
	}

	/** {@inheritDoc} **/
	@Override
	public SToken createToken(DataSourceSequence sDSSequence) {
		SToken sToken = SaltFactory.createSToken();
		addNode(sToken);
		addToken(sToken, sDSSequence);
		return (sToken);
	}

	/** {@inheritDoc} **/
	@Override
	public SSpan createSpan(SToken token) {
		if (token == null) {
			throw new SaltParameterException("addSSpan", "sourceSToken", this.getClass());
		}
		SSpan sSpan = SaltFactory.createSSpan();
		addNode(sSpan);
		SSpanningRelation rel = SaltFactory.createSSpanningRelation();
		rel.setSource(sSpan);
		rel.setTarget(token);
		this.addRelation(rel);
		return (sSpan);
	}

	/** {@inheritDoc} **/
	@Override
	public SSpan createSpan(List<SToken> sTokens) {
		SSpan retVal = null;
		if (sTokens != null) {
			for (SToken sToken : sTokens) {
				if (sToken != null) {
					if (retVal == null) {
						retVal = SaltFactory.createSSpan();
						addNode(retVal);
					}
					SSpanningRelation sSpanRel = SaltFactory.createSSpanningRelation();
					sSpanRel.setSource(retVal);
					sSpanRel.setTarget(sToken);
					addRelation(sSpanRel);
				}
			}
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public SStructure createSStructure(SStructuredNode sourceSNode) {
		if (sourceSNode == null) {
			throw new SaltParameterException("addSStructure", "sourceSNode", this.getClass());
		}
		SStructure sStruct = SaltFactory.createSStructure();
		addNode(sStruct);
		SDominanceRelation sDomRel = SaltFactory.createSDominanceRelation();
		sDomRel.setSource(sStruct);
		sDomRel.setTarget(sourceSNode);
		addRelation(sDomRel);
		return (sStruct);
	}

	/** {@inheritDoc} **/
	@Override
	public SStructure createStructure(List<SStructuredNode> structures) {
		SStructure retVal = null;
		if (structures != null) {
			for (SStructuredNode sStructuredNode : structures) {
				if (sStructuredNode != null) {
					if (retVal == null) {
						retVal = SaltFactory.createSStructure();
						addNode(retVal);
					}
					SDominanceRelation sDomRel = SaltFactory.createSDominanceRelation();
					sDomRel.setSource(retVal);
					sDomRel.setTarget(sStructuredNode);
					addRelation(sDomRel);
				}
			}
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public STimeline createTimeline() {
		STimeline retVal = null;
		if ((getTimeline() == null) || (getTimeline().getEnd() == 0)) {
			STimeline sTimeline = SaltFactory.createSTimeline();
			addNode(sTimeline);
			List<STimelineRelation> sTimeRelList = new ArrayList<>();
			Map<STextualDS, List<STimelineRelation>> sTimeRelTable = new Hashtable<>();
			for (STextualRelation sTextRel : getTextualRelations()) {
				// for each token create a STimeline object
				STimelineRelation sTimeRel = SaltFactory.createSTimelineRelation();
				sTimeRel.setTarget(sTimeline);
				sTimeRel.setSource(sTextRel.getSource());

				// start: put STimelineRelation into sTimeRelTable
				if (sTimeRelTable.get(sTextRel.getTarget()) == null){
					sTimeRelTable.put(sTextRel.getTarget(), new ArrayList<STimelineRelation>());
				}
				// TODO not only adding the timeRel, sorting for left and right
				// textual position
				sTimeRelTable.get(sTextRel.getTarget()).add(sTimeRel);
				// end: put STimelineRelation into sTimeRelTable
			}// for each token create a STimeline object
			for (STextualDS sTextualDS : getTextualDSs()) {
				sTimeRelList.addAll(sTimeRelTable.get(sTextualDS));
			}
			Integer pot = 0;
			for (STimelineRelation sTimeRelation : sTimeRelList) {
				sTimeRelation.setStart(pot);
				pot++;
				sTimeline.increasePointOfTime();
				sTimeRelation.setEnd(pot);
				addRelation(sTimeRelation);
			}
			retVal = sTimeline;
		} else {
			retVal = getTimeline();
		}

		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> getTokensBySequence(DataSourceSequence sequence) {
//		SDataSourceAccessor sDatasourceAccessor= new SDataSourceAccessor();
//		sDatasourceAccessor.setDocumentGraph(this);
//		return(sDatasourceAccessor.getTokensBySequence(sequence));
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} **/
	@Override
	public List<SSpan> getSpansBySequence(DataSourceSequence sequence) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SStructure> getStructuresBySequence(DataSourceSequence sequence) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SNode> getNodesBySequence(DataSourceSequence sequence) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<DataSourceSequence> getOverlappedDSSequences(SNode node, List<SALT_TYPE> relationTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<DataSourceSequence> getOverlappedDSSequences(List<SNode> sNode, List<SALT_TYPE> relationTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public boolean isContinuousByText(List<SNode> subNodeList, List<SNode> fullNodeList) {
		// TODO Auto-generated method stub
		return false;
	}

	/** {@inheritDoc} **/
	@Override
	public boolean isContinuousByText(List<SNode> subNodeList) {
		// TODO Auto-generated method stub
		return false;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> getSortedSTokenByText(List<SToken> tokens2sort) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> getSortedTokenByText() {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public void sortTokenByText() {
		// TODO Auto-generated method stub

	}

	/** {@inheritDoc} **/
	@Override
	public List<SNode> getRootsByRelation(SALT_TYPE type) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public Map<String, List<SNode>> getRootsBySRelationSType(SALT_TYPE type) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public SToken createSToken(SSequentialDS sequentialDS, Integer start, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> tokenize() {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public Tokenizer createTokenizer() {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public SToken insertTokenAt(STextualDS sTextualDS, Integer posInText, String text, Boolean insertSpace) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> insertTokensAt(STextualDS sTextualDS, Integer posInText, List<String> texts, Boolean insertSpace) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public SRelation createSRelation(SNode sSource, SNode sTarget, SALT_TYPE sRelationType, String sAnnotations) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> getOverlappedTokens(SNode overlappingNode, List<SALT_TYPE> overlappingRelationTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public String getSText(SNode sNode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(getClass().getSimpleName());
		str.append("(");
		str.append(getId());
		str.append(")");
		return (str.toString());
	}
}
