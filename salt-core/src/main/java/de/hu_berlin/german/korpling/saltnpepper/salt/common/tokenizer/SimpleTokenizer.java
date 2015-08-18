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
package de.hu_berlin.german.korpling.saltnpepper.salt.common.tokenizer;

import java.util.List;

import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SToken;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltTokenizerException;

/**
 * This class is a very simple implementation of a tokenizer, which just splits
 * a primary text by a given list of characters. e.g. a blank.
 * 
 * @author Florian Zipser
 *
 */
public class SimpleTokenizer {
	/**
	 * Sets the {@link SDocumentGraph} to be used.
	 */
	private SDocumentGraph sDocumentGraph = null;

	public void setsDocumentGraph(SDocumentGraph sDocumentGraph) {
		this.sDocumentGraph = sDocumentGraph;
	}

	public SDocumentGraph getsDocumentGraph() {
		return sDocumentGraph;
	}

	/**
	 * Initializes a new TTokenizer object.
	 */
	public SimpleTokenizer() {
	}

	/**
	 * Sets the {@link STextualDS} to be tokenized. Its language will be
	 * detected automatically if possible.
	 * 
	 * @param sTextualDSs
	 */
	public List<SToken> tokenize(STextualDS sTextualDSs, Character... separator) {
		return (tokenize(sTextualDSs, null, null, separator));
	}

	/**
	 * Sets the {@link STextualDS} to be tokenized and the language of the text.
	 * If language is null, it will be detected automatically if possible.
	 * 
	 * @param sTextualDSs
	 *            {@link STextualDS} object containing the text to be tokenized
	 * @param startPos
	 *            start position, if text to be tokenized is subset (0 assumed
	 *            if set to null)
	 * @param startPos
	 *            end position, if text to be tokenized is subset (length of
	 *            text assumed if set to null)
	 */
	public List<SToken> tokenize(STextualDS sTextualDS, Integer startPos, Integer endPos, Character... separator) {
		List<SToken> retVal = null;
		if (sTextualDS == null)
			throw new SaltTokenizerException("Cannot tokenize an empty 'SSTextualDS' object.");

		if (this.getsDocumentGraph() == null) {
			if (sTextualDS.getGraph() == null) {
				throw new SaltTokenizerException("Cannot add tokens to an empty SDocumentGraph object and can not estimate SDocumentGraph, because STextualDS does not belong to a SDocumentGraph object.");
			} else {
				this.setsDocumentGraph(sTextualDS.getGraph());
			}
		}

		if (sTextualDS.getText() != null) {
			if (startPos == null) {
				startPos = 0;
			}
			if (endPos == null) {
				endPos = sTextualDS.getText().length();
			}

			char[] text;
			if ((startPos != 0) || (endPos != sTextualDS.getText().length())) {
				text = sTextualDS.getText().substring(startPos, endPos).toCharArray();
			} else {
				text = sTextualDS.getText().toCharArray();
			}
			// true if last character was a separator, false otherwise
			boolean isSep = false;
			int currStart = 0; // current start position for token
			int currEnd = 0; // current end position for token
			boolean wasHere = false;
			for (char chr : text) {
				wasHere = false;
				for (char sep : separator) {
					if (chr == sep) {
						if (currStart != currEnd) {
							// create token
							getsDocumentGraph().createSToken(sTextualDS, currStart, currEnd);
						}
						isSep = true;
					} else {
						if (wasHere) {
							break;
						}
						isSep = false;
					}
					wasHere = true;
				}
				currEnd++;
				if (isSep) {
					currStart = currEnd;
				}
			}
			if (!isSep) {
				// create a token for the last part of text, if last character
				// was not a separator
				getsDocumentGraph().createSToken(sTextualDS, currStart, currEnd);
			}
		}
		return (retVal);
	}
}