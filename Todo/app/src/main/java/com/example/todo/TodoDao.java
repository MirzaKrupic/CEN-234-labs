package com.example.todo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TodoDao {
    @Insert
    void add(Todo todo);

    @Query("SELECT * FROM todos")
    List<Todo> getAll();

    @Query("SELECT * FROM todos WHERE id=:id LIMIT 1")
    Todo getTodoById(long id);

    @Query("UPDATE todos SET title = :title, description = :description WHERE id = :id")
    void update(long id, String title, String description);

    @Delete
    void delete(Todo todo);
}
