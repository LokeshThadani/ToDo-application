package io.todo.tasks.main;

import org.springframework.data.repository.CrudRepository;

public interface  ToDoRepository extends CrudRepository<Task,Integer>
{
	
}
