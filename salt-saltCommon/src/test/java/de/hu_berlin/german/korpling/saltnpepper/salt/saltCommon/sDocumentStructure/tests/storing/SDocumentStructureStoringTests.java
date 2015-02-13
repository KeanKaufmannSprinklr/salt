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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.storing;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.storing.SDocumentGraphStoringTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.storing.SDocumentStructureStoringTests;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.storing.STimelineStoringTest;
import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>sDocumentStructure</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class SDocumentStructureStoringTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new SDocumentStructureStoringTests("sDocumentStructure Tests");
		suite.addTestSuite(SDocumentGraphStoringTest.class);
		suite.addTestSuite(STimelineStoringTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentStructureStoringTests(String name) {
		super(name);
	}

} //SDocumentStructureTests
