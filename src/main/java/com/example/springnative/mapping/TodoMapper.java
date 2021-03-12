package com.example.springnative.mapping;

import java.util.Optional;

import com.example.springnative.api.TodoItem;
import com.example.springnative.domain.Todo;

public final class TodoMapper {
	public static TodoItem map(Todo todo) {
		return Optional.ofNullable(todo)
			.map(item -> new TodoItem(item.getId(), item.getTitle(), item.isCompleted()))
			.orElseGet(TodoItem::new);
	}

	public static Todo map(TodoItem todoItem) {
		return Optional.ofNullable(todoItem)
			.map(item -> new Todo(item.getId(), item.getTitle(), item.isCompleted()))
			.orElseGet(Todo::new);
	}
}
