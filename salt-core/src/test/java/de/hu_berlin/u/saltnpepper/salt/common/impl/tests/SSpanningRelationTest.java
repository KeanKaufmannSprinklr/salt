package de.hu_berlin.u.saltnpepper.salt.common.impl.tests;

import org.junit.Before;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;

public class SSpanningRelationTest extends SRelationAbstractTest {

	@Before
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSSpanningRelation());
	}

}
