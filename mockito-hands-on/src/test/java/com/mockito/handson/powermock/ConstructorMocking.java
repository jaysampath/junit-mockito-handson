package com.mockito.handson.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
@PrepareForTest(SystemUnderTest.class)
public class ConstructorMocking {

	@Mock
	ArrayList mockList;

	@InjectMocks
	SystemUnderTest systemUnderTest;
	



	@Test
	public void testConstrucorMethod() {

		
		
		when(mockList.size()).thenReturn(10);

		try {
			PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int size = systemUnderTest.methodUsingAnArrayListConstructor();
		
		assertEquals(10,size);
		
	   
	 
		

	}

	

}
