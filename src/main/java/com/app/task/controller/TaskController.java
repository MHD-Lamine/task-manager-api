package com.app.task.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.task.dto.TaskCreateResquest;
import com.app.task.dto.TaskReponse;
import com.app.task.dto.TaskStatusUpdateRequest;
import com.app.task.mapper.TaskMapper;
import com.app.task.model.StatutTask;
import com.app.task.model.Task;
import com.app.task.service.TaskService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TaskReponse> creer(
        @Valid 
        @RequestBody 
        TaskCreateResquest dto
    ) {

        var task = TaskMapper.toEntity(dto);
        var saved = service.creer(task);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(TaskMapper.toDoReponse(saved));
    }

    @GetMapping
    public Page<TaskReponse> lister(@PageableDefault(size = 5, sort = "dateCreation") Pageable pageable){
        return service.lister(pageable)
                .map(TaskMapper::toDoReponse);
    }

    @GetMapping("/search")
    public Page<TaskReponse> rechercherParStatut(@RequestParam StatutTask statut, Pageable pageable){ 
        return service.rechercherParStatut(statut, pageable)
                .map(TaskMapper::toDoReponse);  
    }
    
    @PutMapping("/{id}/statut")
    public TaskReponse changerStatut(
        @PathVariable Long id,
        @Valid @RequestBody TaskStatusUpdateRequest dto) {

            return TaskMapper.toDoReponse(
                service.changerStatut(id, dto.getStatut())
            );
        }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void supprimer(@PathVariable Long id) {
        service.supprimer(id);  
    }


}
