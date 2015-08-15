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
package de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.u.saltnpepper.graph.GraphFactory;
import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpus;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SGraphImpl;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltException;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInsertionException;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

@SuppressWarnings("serial")
public class SCorpusGraphImpl extends SGraphImpl implements SCorpusGraph {

	/** Salt-project containing this corpus structure **/
	protected SaltProject saltProject = null;

	/** {@inheritDoc} **/
	@Override
	public SaltProject getSaltProject() {
		return (saltProject);
	}

	/** {@inheritDoc} **/
	@Override
	public void setSaltProject(SaltProject saltProject) {
		this.saltProject = saltProject;
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
		if (!(relation instanceof SRelation)) {
			throw new SaltInsertionException(this, relation, "Cannot insert an edge, which is not a SRelation object. ");
		}
		// start: create a name if none exists
		if ((((SRelation) relation).getName() == null) || (((SRelation) relation).getName().isEmpty())) {
			if (relation instanceof SCorpusRelation) {
				((SRelation) relation).setName("corpRel" + (this.getCorpusRelations().size() + 1));
			} else if (relation instanceof SCorpusDocumentRelation) {
				((SRelation) relation).setName("corpDocRel" + (this.getCorpusDocumentRelations().size() + 1));
			} else {
				((SRelation) relation).setName("rel" + (this.getRelations().size() + 1));
			}
		}
		// end: create a name if none exists
		if ((((SRelation) relation).getId() == null) || (((SRelation) relation).getId().isEmpty())) {
			((SRelation) relation).setId("salt:/" + ((SRelation) relation).getName());
		}
		super.basicAddRelation(relation);

		// map some implementation types to the matching interfaces
		Class key;
		if (relation instanceof SCorpusRelation) {
			key = SCorpusRelation.class;
		} else if (relation instanceof SCorpusDocumentRelation) {
			key = SCorpusDocumentRelation.class;
		} else {
			key = relation.getClass();
		}
		getIndexMgr().put(SaltUtil.IDX_RELATIONTYPE, key, relation);
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
		if (!(node instanceof SNode)) {
			throw new SaltException("Cannot insert a node, which is not a SNode object: " + node);
		}
		// start: create a name if none exists
		if ((((SNode) node).getName() == null) || (((SNode) node).getName().isEmpty())) {
			if (node instanceof SCorpus)
				((SNode) node).setName("corp" + (this.getCorpora().size() + 1));
			else if (node instanceof SDocument)
				((SNode) node).setName("doc" + (this.getDocuments().size() + 1));
			else
				((SNode) node).setName("node" + (this.getDocuments().size() + 1));
		}
		// end: create a name if none exists
		if ((((SNode) node).getId() == null) || (((SNode) node).getId().isEmpty())) {
			// id a name if none exists
			((SNode) node).setId("salt:/" + ((SNode) node).getName());
		}// id a name if none exists

		super.basicAddNode(node);

		// map some implementation types to the matching interfaces
		Class key;
		if (node instanceof SCorpus)
			key = SCorpus.class;
		else if (node instanceof SDocument)
			key = SDocument.class;
		else
			key = node.getClass();

		// end: compute slot id
		getIndexMgr().put(SaltUtil.IDX_NODETYPE, key, node);
	}

	// ============================ end: handling nodes

	// ============================ start: handling specific nodes

	/** {@inheritDoc} **/
	@Override
	public List<SCorpus> getCorpora() {
		return (getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SCorpus.class));
	}

	/** {@inheritDoc} **/
	@Override
	public List<SDocument> getDocuments() {
		return (getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SDocument.class));
	}

	// ============================ end: handling specific nodes
	// ============================ start: handling specific relations
	/** {@inheritDoc} **/
	@Override
	public List<SCorpusRelation> getCorpusRelations() {
		return (getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SCorpusRelation.class));
	}

	/** {@inheritDoc} **/
	@Override
	public List<SCorpusDocumentRelation> getCorpusDocumentRelations() {
		return (getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SCorpusDocumentRelation.class));
	}

	// ============================ end: handling specific relations
	/** {@inheritDoc} **/
	@Override
	public SCorpus getCorpus(Identifier corpusId) {
		SCorpus retVal = null;
		SNode node = this.getNode(corpusId.getId());
		if (node instanceof SCorpus)
			retVal = (SCorpus) node;
		return retVal;
	}

	/** {@inheritDoc} **/
	@Override
	public SDocument getDocument(Identifier documentId) {
		SDocument retVal = null;
		SNode node = this.getNode(documentId.getId());
		if (node instanceof SDocument)
			retVal = (SDocument) node;
		return retVal;
	}

	/** {@inheritDoc} **/
	@Override
	public Identifier addSubCorpus(SCorpus superCorpus, SCorpus subCorpus) {
		if (superCorpus == null) {
			throw new SaltException("Cannot add the given subCorpus, because the given superCorpus is null.");
		}
		if (subCorpus == null) {
			throw new SaltException("Cannot add the given subCorpus, because it is null.");
		}
		if (superCorpus.getId() == null) {
			throw new SaltException("Cannot add the given subCorpus, because the given superCorpus is not already contained in corpus graph.");
		}
		if (this.getNode(superCorpus.getId()) == null) {
			throw new SaltException("Cannot add the given subCorpus, because the given superCorpus is not already contained in corpus graph.");
		}

		String namePart = null;
		namePart = subCorpus.getName();
		if ((namePart == null) || (namePart.isEmpty())) {
			namePart = "corp_" + getCorpora().size();
		}

		// creates and sets identifier
		GraphFactory.createIdentifier(subCorpus, URI.createURI(superCorpus.getId() + "/" + namePart).toString());

		addNode(subCorpus);
		SCorpusRelation corpRel = SaltFactory.createSCorpusRelation();
		corpRel.setSource(superCorpus);
		corpRel.setTarget(subCorpus);
		addRelation(corpRel);

		return (corpRel.getIdentifier());
	}

	/** {@inheritDoc} **/
	@Override
	public Identifier addDocument(SCorpus corpus, SDocument document) {
		if (corpus == null) {
			throw new SaltException("Cannot add the given sDocument, because the given sCorpus is null.");
		}
		if (document == null) {
			throw new SaltException("Cannot add the given sDocument, because it is null.");
		}
		if (this.getNode(corpus.getId()) == null) {
			throw new SaltException("Cannot add the given sDocument, because the given sCorpus is not already contained in corpus graph.");
		}
		String namePart = null;
		namePart = document.getName();
		if ((namePart == null) || (namePart.isEmpty())) {
			namePart = "doc_" + getCorpora().size();
		}
		GraphFactory.createIdentifier(document, URI.createURI(corpus.getId() + "/" + namePart).toString());

		addNode(document);
		SCorpusDocumentRelation corpDocRel = SaltFactory.createSCorpusDocumentRelation();
		corpDocRel.setSource(corpus);
		corpDocRel.setTarget(document);
		addRelation(corpDocRel);

		return (corpDocRel.getIdentifier());
	}

	/** {@inheritDoc} **/
	@Override
	public SCorpus getCorpus(SDocument document) {
		SCorpus retVal = null;
		if (document != null) {
			List<SRelation<SNode, SNode>> inRels = getInRelations(document.getId());
			for (SRelation inEdge : Collections.synchronizedCollection(inRels)) {
				if (inEdge instanceof SCorpusDocumentRelation) {

					retVal = ((SCorpusDocumentRelation) inEdge).getSource();
					break;
				}
			}
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public void load(URI corpusGraphUri) {
		// TODO Auto-generated method stub

	}

	/** {@inheritDoc} **/
	@Override
	public SCorpus createSCorpus(SCorpus superCorpus, String corpusName) {
		SCorpus corpus = SaltFactory.createSCorpus();
		corpus.setName(corpusName);
		if (superCorpus != null) {
			addSubCorpus(superCorpus, corpus);
		} else {
			addNode(corpus);
		}
		return (corpus);
	}

	/** {@inheritDoc} **/
	@Override
	public SDocument createSDocument(SCorpus parentCorpus, String documentName) {
		SDocument document = SaltFactory.createSDocument();
		document.setName(documentName);
		addDocument(parentCorpus, document);
		return (document);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SCorpus> createSCorpus(URI corpusPath) {
		List<SCorpus> retVal = null;
		if (corpusPath != null) {
			SCorpus parentCorpus = null;
			for (int i = corpusPath.segments().length - 1; i >= 0; i--) {
				URI currPath = corpusPath.trimSegments(i);
				SNode node = getNode(currPath.toString());
				if (node == null) {
					parentCorpus = createSCorpus(parentCorpus, currPath.lastSegment());
					if (retVal == null)
						retVal = new ArrayList<SCorpus>();
					retVal.add(parentCorpus);
				} else {
					parentCorpus = (SCorpus) node;
				}
			}
		}
		return (retVal);

	}

	/** {@inheritDoc} **/
	@Override
	public SDocument createSDocument(URI documentPath) {
		SDocument retVal = null;
		List<SCorpus> corpora = createSCorpus(documentPath.trimSegments(1));
		if ((corpora == null) || (corpora.size() == 0)) {
			corpora = new Vector<SCorpus>();
			corpora.add((SCorpus) getNode(documentPath.trimSegments(1).toString()));
		}
		retVal = createSDocument(corpora.get(corpora.size() - 1), documentPath.lastSegment());
		return (retVal);
	}
} // SCorpusGraphImpl