package com.mockito.handson.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.mockito.handson.api.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void testRetrieveTodosRelatedToSpringUsingMock() {
		
		TodoService mockTodoService = mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
		
		when(mockTodoService.retrieveTodos("Dummy")).thenReturn(todos);
		
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
		List<String> filteredTodos = todoBusinessImpl.retieveTodosRelatedToSpring("Dummy");
		assertEquals(2,filteredTodos.size());
		
	}

}
