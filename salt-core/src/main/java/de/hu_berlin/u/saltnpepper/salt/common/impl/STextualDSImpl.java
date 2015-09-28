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
package de.hu_berlin.u.saltnpepper.salt.common.impl;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.salt.common.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.STextualDS;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltParameterException;

@SuppressWarnings("serial")
public class STextualDSImpl extends SSequentialDSImpl<String, Integer> implements STextualDS {

	/** {@inheritDoc} **/
	@Override
	public String getText() {
		String retVal = null;
		if (super.getData() instanceof String) {
			retVal = (String) super.getData();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public void setText(String newSText) {
		super.setData(newSText);
	}

	/** {@inheritDoc} **/
	@Override
	public SDocumentGraph getGraph() {
		return ((SDocumentGraph) super.getGraph());
	}

	/** {@inheritDoc} **/
	@Override
	public void setGraph(@SuppressWarnings("rawtypes") Graph graph) {
		if (!(graph instanceof SDocumentGraph)) {
			throw new SaltParameterException("graph", "setGrah", getClass(), "The parameter was not of type SDocumentGraph. ");
		}
		super.setGraph(graph);
	}

	/**
	 * {@inheritDoc SSequentialDS#getSStart()}. If a text was set returns 0,
	 * null otherwise
	 */
	@Override
	public Integer getStart() {
		if (getText() != null) {
			return (0);
		} else {
			return (null);
		}
	}

	/**
	 * {@inheritDoc SSequentialDS#getSEnd()}. If a text was set returns it's
	 * length, null otherwise
	 * 
	 */
	public Integer getEnd() {
		String sText = getText();
		if (sText != null) {
			return (sText.length());
		} else {
			return (null);
		}
	}
} // STextualDSImpl
