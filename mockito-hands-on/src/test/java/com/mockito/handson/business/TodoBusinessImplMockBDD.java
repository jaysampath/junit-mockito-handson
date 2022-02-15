package com.mockito.handson.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.mockito.handson.api.TodoService;

public class TodoBusinessImplMockBDD {

	@Test
	public void testRetrieveTodosRelatedToSpringUsingBDD() {

		// Given
		TodoService mockTodoService = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		given(mockTodoService.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);

		// When
		List<String> filteredTodos = todoBusinessImpl.retieveTodosRelatedToSpring("Dummy");

		// Then
		assertThat(filteredTodos.size(), is(2));

	}

	@Test
	public void testDeleteTodoBDD() {

		// Given
		TodoService mockTodoService = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		given(mockTodoService.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);

		// When
		todoBusinessImpl.deletTodosNotRelatedToSpring("Dummy");

		// Then
		verify(mockTodoService).deleteTodo("Learn to Dance");
		then(mockTodoService).should().deleteTodo("Learn to Dance");
		verify(mockTodoService, times(1)).deleteTodo("Learn to Dance");
		verify(mockTodoService, never()).deleteTodo("Learn Spring MVC");
		then(mockTodoService).should(never()).deleteTodo("Learn Spring MVC");

	}

	@Test
	public void testDeleteTodoBDD_AurgumentCapture() {

		// Declare an Argument Captor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

		// Given
		TodoService mockTodoService = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		given(mockTodoService.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);

		// When
		todoBusinessImpl.deletTodosNotRelatedToSpring("Dummy");

		// Then

		then(mockTodoService).should().deleteTodo(stringArgumentCaptor.capture());

		assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));

	}
	
	@Test
	public void testDeleteTodoBDD_AurgumentCapture_MultipleTimes() {

		// Declare an Argument Captor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

		// Given
		TodoService mockTodoService = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance","Learn hip hop");

		given(mockTodoService.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);

		// When
		todoBusinessImpl.deletTodosNotRelatedToSpring("Dummy");

		// Then

		then(mockTodoService).should(times(2)).deleteTodo(stringArgumentCaptor.capture());

		assertThat(stringArgumentCaptor.getAllValues().size(), is(2));

	}

}
