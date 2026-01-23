package com.app.task.mapper;

import com.app.task.dto.TaskCreateResquest;
import com.app.task.dto.TaskRequest;
import com.app.task.model.Task;

public class TaskMapper {

    public static Task toEntity(TaskCreateResquest dto){
        Task task = new Task();

        task.setTitre(dto.getTitre());
        task.setDescription(dto.getDescription());
        task.setPriorite(dto.getPriorite());
        
        return task;
    }

    public static TaskRequest toDoRequest(Task task){
        TaskRequest dto = new TaskRequest();

        dto.setId(task.getId());
        dto.setTitre(task.getTitre());
        dto.setDescription(task.getDescription());
        dto.setPriorite(task.getPriorite());
        dto.setStatut(task.getStatut());
        dto.setDateCreation(task.getDateCreation());

        return dto;
    }

}
