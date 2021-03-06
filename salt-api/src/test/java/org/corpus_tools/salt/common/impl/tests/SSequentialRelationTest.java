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
package org.corpus_tools.salt.common.impl.tests;

import org.corpus_tools.salt.common.SSequentialRelation;
import org.corpus_tools.salt.core.SNode;
import org.junit.Test;

public abstract class SSequentialRelationTest<S extends SNode, T extends SNode, P extends Number> extends SRelationAbstractTest {

	protected SSequentialRelation<S, T, P> getFixture() {
		return (SSequentialRelation<S, T, P>) fixture;
	}

	/** Tests whether the start value is set and returned correct. **/
	@Test
	public abstract void testSetGetStart();

	/** Tests whether the end value is set and returned correct. **/
	@Test
	public abstract void testSetGetEnd();
} // SSequentialDSTest
