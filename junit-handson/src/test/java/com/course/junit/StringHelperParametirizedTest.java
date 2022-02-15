package com.course.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParametirizedTest {
	 static StringHelper helper ;
	
	@BeforeClass
	public static void beforeClass() {
	    helper = new StringHelper();
	}
	
	private String input;
	private String expectedOutput;
	
	
	
	public StringHelperParametirizedTest(String input, String expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameters
	public static Collection<String[]> testConditions() {
		String expectedOutputs[][] = {
		{"AACD","CD"},
		{"ACD","CD"}
		};
		return Arrays.asList(expectedOutputs);
	}

	@Test
	public void test() {
		System.out.println("expected = "+expectedOutput+" input = "+input);
		assertEquals(expectedOutput,helper.truncateAInFirst2Positions(input));
	
	}
	

	
}
