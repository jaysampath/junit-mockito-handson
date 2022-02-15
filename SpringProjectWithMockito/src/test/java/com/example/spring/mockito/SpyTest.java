package com.example.spring.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {
	
	

	@Test
	public void test() {
		List arrayListMock = mock(ArrayList.class);
		assertEquals(0,arrayListMock.size());
		stub(arrayListMock.size()).toReturn(5);
		assertEquals(5,arrayListMock.size());
		
//		List arrayListSpy = spy(ArrayList.class);
//		assertEquals(0,arrayListSpy.size());
//		stub(arrayListSpy.size()).toReturn(5);
//		assertEquals(5,arrayListSpy.size());
	}

}
