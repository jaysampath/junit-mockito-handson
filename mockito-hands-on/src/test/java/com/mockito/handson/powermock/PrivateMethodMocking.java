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
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
public class PrivateMethodMocking {

	@Mock
	Dependency dependencyMock;

	@InjectMocks
	SystemUnderTest systemUnderTest;


	@Test
	public void testPrivatemethod() {

		List<Integer> stats = Arrays.asList(1,2,3);

		when(dependencyMock.retrieveAllStats()).thenReturn(stats);
		
	   
	    long result = 0;
		try {
			result = Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    assertEquals(6,result);
		

	}

	

}
