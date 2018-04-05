package io.todo.tasks.main;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController 
{
	@Autowired
	private TaskService taskService;
	
	@GetMapping(value = "/getAllTasks") 
	public List<Task> getAllTasks() 
	{
		return taskService.getAllTasks();
	}
	
	@PostMapping(value = "/addTask")
	@ResponseBody
	public List<Task> addPlayer(HttpServletRequest request,@RequestBody String json) 
	{
		taskService.saveTask(json);
		return taskService.getAllTasks();
	}
	
	@PutMapping(value = "/updateTask")
	@ResponseBody
	public List<Task> updateTask(HttpServletRequest request,@RequestBody String json) 
	{
		taskService.saveTask(json);
		return taskService.getAllTasks();
	}
	
	@DeleteMapping(value = "/removeTask/{id}")
	public List<Task> deletePlayer(HttpServletRequest request,@PathVariable("id") int id) 
	{
		taskService.removeTask(id);
		return taskService.getAllTasks();
	}
	
	@RequestMapping(value = "/getTaskDetails/{id}", method = RequestMethod.GET ) 
	public Task getPlayerDetails(@PathVariable("id") int id) 
	{
		return taskService.getTaskDetails(id);
	}
}
