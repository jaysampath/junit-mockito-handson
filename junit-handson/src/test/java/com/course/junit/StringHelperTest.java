package com.course.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {
	
	StringHelper helper = new StringHelper();

	@Test
	public void test() {
		//assertEquals(expected,actual);
		assertEquals("CD",helper.truncateAInFirst2Positions("AACD"));
		assertEquals("CD",helper.truncateAInFirst2Positions("ACD"));
	}
	
	@Test
	public void truncateAInFirst2PositionsTest1() {
		assertEquals("CD",helper.truncateAInFirst2Positions("AACD"));
	}
	
	@Test
	public void truncateAInFirst2PositionsTest2() {
		assertEquals("CD",helper.truncateAInFirst2Positions("ACD"));
	}
	
	@Test
	public void areFirstAndLastTwoCharactersTheSame_stringWithLength1() {
		assertEquals(false, helper.areFirstAndLastTwoCharactersTheSame("A"));
	}
	
	@Test
	public void areFirstAndLastTwoCharactersTheSame_stringWithLength2() {
		assertEquals(true, helper.areFirstAndLastTwoCharactersTheSame("AB"));
	}
	
	@Test
	public void areFirstAndLastTwoCharactersTheSame_stringTest1() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
	
	@Test
	public void areFirstAndLastTwoCharactersTheSame_stringTest2() {
		//assertTrue("message to be put. Failed case: ", helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}

}
