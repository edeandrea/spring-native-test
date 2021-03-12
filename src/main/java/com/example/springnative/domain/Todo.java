package com.example.springnative.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "todo_items")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 16, unique = true, nullable = false)
	@Include
	private UUID id;

	@Version
	@Setter(AccessLevel.PROTECTED)
	private Long version;

	@Column(nullable = false)
	@NotBlank
	private String title;
	private boolean completed;

	@Builder
	public Todo(UUID id, String title, boolean completed) {
		this.id = id;
		this.title = title;
		this.completed = completed;
	}
}
