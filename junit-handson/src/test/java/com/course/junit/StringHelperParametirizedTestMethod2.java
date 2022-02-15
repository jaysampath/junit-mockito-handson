package com.course.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParametirizedTestMethod2 {
	static StringHelper helper;

	@BeforeClass
	public static void beforeClass() {
		helper = new StringHelper();
	}

	private String input;
	private boolean expectedOutput;

	public StringHelperParametirizedTestMethod2(Method2Test test) {
		this.input = test.input;
		this.expectedOutput = test.expectedOutput;
	}

	@Parameters
	public static List<Method2Test> testConditions() {
		
		Method2Test[] expOutputs = new Method2Test[4];
		
			expOutputs[0] = new Method2Test("A",false);
			expOutputs[1] = new Method2Test("AB",true);
			expOutputs[2] = new Method2Test("ABAB",true);
			expOutputs[3] = new Method2Test("ABCD",false);
			
				
			
		return Arrays.asList(expOutputs);
	}

	@Test
	public void test() {
		 System.out.println("expected = "+expectedOutput+" input = "+input);
		if (expectedOutput) {
			assertTrue(helper.areFirstAndLastTwoCharactersTheSame(input));
		} else {
			assertFalse(helper.areFirstAndLastTwoCharactersTheSame(input));
		}

	}

}
class Method2Test{
	String input;
	boolean expectedOutput;
	public Method2Test(String input, boolean expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}
	
}
