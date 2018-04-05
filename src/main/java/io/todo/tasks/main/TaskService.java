package io.todo.tasks.main;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	@Autowired
	private ToDoRepository toDoRepository;
	
	public Task getTaskDetails(int id) 
	{
		return toDoRepository.findOne(id);
	}

	public List<Task> getAllTasks() {
		
		List<Task> tasks = new ArrayList<>();
		for(Task task:toDoRepository.findAll()){
			tasks.add(task);
		}
		return tasks;
	}

	public void saveTask(String jsonStr) {
		Task task = new Task();
		try {
		JSONObject json = new JSONObject(jsonStr);
		int id = json.has("id")?(int) json.get("id"):0;
		String text = json.getString("text");
		boolean done = json.has("done")?(boolean) json.getBoolean("done"):false;
		task.setDone(done);
		if(id!=0)task.setId(id);
		task.setText(text);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		toDoRepository.save(task);
	}
	
	public void removeTask(int id) {
		toDoRepository.delete(id);
	}

}