package com.example.springnative.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springnative.mapping.TodoMapper;
import com.example.springnative.repository.TodoRepository;

@RestController
@RequestMapping("/api")
public class TodoAPI {
	private final TodoRepository todoRepository;

	public TodoAPI(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TodoItem> getAll() {
		return this.todoRepository.findAll().stream()
			.map(TodoMapper::map)
			.collect(Collectors.toList());
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TodoItem> getOne(@PathVariable UUID id) {
		return this.todoRepository.findById(id)
			.map(TodoMapper::map)
			.map(ResponseEntity::ok)
			.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<TodoItem> addTodo(@Valid @RequestBody TodoItem todo) {
		this.todoRepository.save(TodoMapper.map(todo));
		return getAll();
	}

	// This method did not work in native
	// When running native there was a ClassNotFoundException on the HttpStatus class
	// I had to re-write this method in a different fashion
//	@DeleteMapping("/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void deleteTodo(@PathVariable UUID id) {
//		this.todoRepository.deleteById(id);
//	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable UUID id) {
		this.todoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
