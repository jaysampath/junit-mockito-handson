package com.mockito.handson.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListMockTest {

	@Test
	public void test() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
	}

	@Test
	public void testMultipleValues() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}

	@Test
	public void testListGet() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("mockito");
		assertEquals("mockito", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}

	@Test
	public void testListGetAurgumentMatcher() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("mockito");
		assertEquals("mockito", listMock.get(0));
		assertEquals("mockito", listMock.get(1));
		assertEquals("mockito", listMock.get(-1));
	}

	@Test(expected=RuntimeException.class)
	public void testListMockThrowException() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("something went wrong!!!"));
		listMock.get(0);
	}
	
	@Test(expected=RuntimeException.class)
	public void testListMockThrowExceptionMixingup() {
		List listMock = mock(List.class);
		when(listMock.subList(anyInt(),5)).thenThrow(new RuntimeException("something went wrong!!!"));
		listMock.get(5);
	}

}
