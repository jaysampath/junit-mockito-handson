package com.mockito.handson.business;

import java.util.List;
import java.util.stream.Collectors;

import com.mockito.handson.api.TodoService;

public class TodoBusinessImpl {

	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retieveTodosRelatedToSpring(String user) {

		List<String> todos = todoService.retrieveTodos(user);
		List<String> filteredTodos = (List<String>) todos.stream().filter(s -> s.contains("Spring"))
				.collect(Collectors.toList());
		return filteredTodos;
	}

	public void deletTodosNotRelatedToSpring(String user) {

		List<String> todos = todoService.retrieveTodos(user);

		todos.forEach(todo -> {
			if (!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		});

	}

}
