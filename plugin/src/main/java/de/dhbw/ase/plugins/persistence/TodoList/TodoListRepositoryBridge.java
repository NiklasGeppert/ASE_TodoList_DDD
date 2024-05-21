package de.dhbw.ase.plugins.persistence.TodoList;

import de.dhbw.ase.Todo.Todo;
import de.dhbw.ase.TodoList.TodoList;
import de.dhbw.ase.TodoList.TodoListRepository;
import de.dhbw.ase.plugins.persistence.Todo.TodoListData;
import de.dhbw.ase.values.ListStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TodoListRepositoryBridge implements TodoListRepository {

    private final TodoListData todoListData;

    @Autowired
    public TodoListRepositoryBridge(final TodoListData todoListData) {
        this.todoListData = todoListData;
    }


    @Override
    public TodoList insert(TodoList todoList, Todo todo) {
        todoList.getTodoList().add(todo);
        return todoListData.save(todoList);
    }

    @Override
    public TodoList save(TodoList toDoList) {
        return todoListData.save(toDoList);
    }

    @Override
    public void delete(TodoList toDoList) {
        todoListData.delete(toDoList);
    }

    @Override
    public Optional<TodoList> findById(UUID id) {
        return todoListData.findById(id);
    }

    @Override
    public List<TodoList> findbyStatus(ListStatus status) {
        return todoListData.findByListStatus(status);
    }

    @Override
    public TodoList remove(TodoList todoList, UUID todoId) {
        todoList.getTodoList().remove(todoId);
        return todoListData.save(todoList);
    }
}

