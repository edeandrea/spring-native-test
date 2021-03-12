package com.example.springnative.domain;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "todo_items")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 16, unique = true, nullable = false)
	private UUID id;

	@Version
	private Long version;

	@Column(nullable = false)
	@NotBlank
	private String title;
	private boolean completed;

	public Todo() {
	}

	public Todo(UUID id, String title, boolean completed) {
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

	public Long getVersion() {
		return this.version;
	}

	protected void setVersion(Long version) {
		this.version = version;
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
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}

		return this.id.equals(((Todo) o).id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Todo.class.getSimpleName() + "[", "]")
			.add("id=" + this.id)
			.add("version=" + this.version)
			.add("title='" + this.title + "'")
			.add("completed=" + this.completed)
			.toString();
	}
}
