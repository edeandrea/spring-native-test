package com.example.springnative.mapping;

import java.util.Optional;

import com.example.springnative.api.TodoItem;
import com.example.springnative.domain.Todo;

public final class TodoMapper {
	public static TodoItem map(Todo todo) {
		return Optional.ofNullable(todo)
			.map(item -> TodoItem.builder()
				.id(item.getId())
				.title(item.getTitle())
				.completed(item.isCompleted())
				.build()
			)
			.orElseGet(TodoItem::new);
	}

	public static Todo map(TodoItem todoItem) {
		return Optional.ofNullable(todoItem)
			.map(item -> Todo.builder()
				.id(item.getId())
				.title(item.getTitle())
				.completed(item.isCompleted())
				.build()
			)
			.orElseGet(Todo::new);
	}
}
