package com.mockito.handson.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class StaticMethodMocking {
	
	
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	Dependency dependencyMock;

	@InjectMocks
	SystemUnderTest systemUnderTest;


	@Test
	public void testStaticmethod() {

		List<Integer> stats = Arrays.asList(1,2,3);

		when(dependencyMock.retrieveAllStats()).thenReturn(stats);
		
		PowerMockito.mockStatic(UtilityClass.class);
		
		when(UtilityClass.staticMethod(6)).thenReturn(150);

		int result = systemUnderTest.methodCallingAStaticMethod();
		
		assertEquals(150,result);
		
		PowerMockito.verifyStatic();
		UtilityClass.staticMethod(6);
		
		

	}

	

}
