package edu.eci.ieti.Tasks.controller;

import edu.eci.ieti.Tasks.data.Task;
import edu.eci.ieti.Tasks.dto.TaskDto;
import edu.eci.ieti.Tasks.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping( "/v1/task" )
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getAll());
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Task> findById(@PathVariable String id ) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));

    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskDto taskDto ) {
        String id = String.valueOf(taskService.getAll().size()+1);
        String today = DateTimeFormatter.ofPattern("YYYY-MM-DD").format(LocalDate.now());
        Task task = new Task(id,taskDto,today);
        return ResponseEntity.status(HttpStatus.OK).body(taskService.create(task));
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Task> update(@RequestBody TaskDto taskDto, @PathVariable String id ) {
        Task task = new Task(id,taskDto,taskService.findById(id).getCreated());
        return ResponseEntity.status(HttpStatus.OK).body(taskService.update(task,id));
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        if (taskService.deleteById(id)){
            return ResponseEntity.status(HttpStatus.OK).body((true));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((false));
        }
    }
}