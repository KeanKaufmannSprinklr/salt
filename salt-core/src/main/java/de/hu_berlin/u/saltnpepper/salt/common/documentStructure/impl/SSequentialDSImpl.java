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
package de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSequentialDS;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SNodeImpl;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

@SuppressWarnings("serial")
public abstract class SSequentialDSImpl<D, P> extends SNodeImpl implements SSequentialDS<D, P> {

	/** {@inheritDoc} */
	@Override
	public D getSData() {
		D retVal = null;
		SFeature feature = getFeature(SaltUtil.FEAT_SDATA_QNAME);
		if (feature != null) {
			retVal = (D)feature.getValue();
		}
		return (retVal);
	}

	/** {@inheritDoc} */
	@Override
	public void setSData(D newSData) {
		SFeature feature = getFeature(SaltUtil.FEAT_SDATA_QNAME);
		if (feature == null) {// create a new sFeature
			feature = SaltFactory.createSFeature();
			feature.setNamespace(SaltUtil.SALT_NAMESPACE);
			feature.setName(SaltUtil.FEAT_SDATA);
			this.addFeature(feature);
		}
		feature.setValue(newSData);
	}
	/** {@inheritDoc} */
	@Override
	public SDocumentGraph getGraph() {
		return((SDocumentGraph)super.getGraph());
	}
	
	/**
	 * {@inheritDoc SSequentialDS#getSStart()}. This method throws an exception,
	 * and has to be overridden by derived classes.
	 */
	@Override
	public P getSStart() {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc SSequentialDS#getSEnd()}. This method throws an exception,
	 * and has to be overridden by
	 */
	@Override
	public P getSEnd() {
		throw new UnsupportedOperationException();
	}
} // SSequentialDSImpl