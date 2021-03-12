package com.example.springnative.api;

import java.util.StringJoiner;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class TodoItem {
	private UUID id;

	@NotBlank
	private String title;
	private boolean completed;

	public TodoItem() {

	}

	public TodoItem(UUID id, String title, boolean completed) {
		this.id = id;
		this.title = title;
		this.completed = completed;
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return this.completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", TodoItem.class.getSimpleName() + "[", "]")
			.add("id=" + this.id)
			.add("title='" + this.title + "'")
			.add("completed=" + this.completed)
			.toString();
	}
}
