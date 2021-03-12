package com.example.springnative.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springnative.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, UUID> {
}
