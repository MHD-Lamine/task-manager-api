package com.app.task.mapper;

import com.app.task.dto.TaskCreateResquest;
import com.app.task.dto.TaskReponse;
import com.app.task.model.Priorite;
import com.app.task.model.Task;

public class TaskMapper {

    public static Task toEntity(TaskCreateResquest dto){
        Task task = new Task();

        task.setTitre(dto.getTitre());
        task.setDescription(dto.getDescription());
        task.setPriorite(Priorite.valueOf(dto.getPriorite()));
        
        return task;
    }

    public static TaskReponse toDoReponse(Task task){
        TaskReponse dto = new TaskReponse();

        dto.setId(task.getId());
        dto.setTitre(task.getTitre());
        dto.setDescription(task.getDescription());
        dto.setPriorite(task.getPriorite().toString());
        dto.setStatut(task.getStatut().toString());
        dto.setDateCreation(task.getDateCreation());

        return dto;
    }

}
