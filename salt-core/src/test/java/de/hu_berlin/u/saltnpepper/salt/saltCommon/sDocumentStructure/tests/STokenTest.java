package de.hu_berlin.u.saltnpepper.salt.saltCommon.sDocumentStructure.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;

public class STokenTest extends SNodeAbstractTest{

	@Before
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSToken());
	}

}