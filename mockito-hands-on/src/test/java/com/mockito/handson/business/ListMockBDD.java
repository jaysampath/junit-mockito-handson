package com.mockito.handson.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import java.util.List;

import org.junit.Test;

public class ListMockBDD {

	@Test
	public void testListGetAurgumentMatcher() {
		// given
		List<String> listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("mockito");
		// when
		String firstElement = listMock.get(0);

		// then
		assertThat(firstElement, is("mockito"));

	}

}
