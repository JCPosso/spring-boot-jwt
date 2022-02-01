package edu.eci.ieti.Tasks.service;

import edu.eci.ieti.Tasks.data.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskServiceHashMap implements TaskService{
    private final HashMap<String, Task> tasksHashMap = new HashMap<>();


    @Override
    public Task create(Task task) {
        return tasksHashMap.put(task.getId(), task);
    }

    @Override
    public Task findById(String id) {
        return tasksHashMap.get(id);
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList<Task>(tasksHashMap.values());
    }

    @Override
    public boolean deleteById(String id) {
        try{
            tasksHashMap.remove(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Task update(Task task, String id) {
        return tasksHashMap.put(id,task);
    }
}