package com.mockito.handson.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.mockito.handson.api.TodoService;
import com.mockito.handson.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void test() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos = todoBusinessImpl.retieveTodosRelatedToSpring("dummy");
		assertEquals(2,filteredTodos.size());
		
	}

}
