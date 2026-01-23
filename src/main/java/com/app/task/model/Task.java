package com.app.task.model;

import java.lang.annotation.ElementType;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;
    private String description;

    @Enumerated(EnumType.STRING)
    private StatutTask statut;
    private Priorite priorite;


    private LocalDateTime dateCreation;

    @PrePersist
    public void initDate(){
        this.dateCreation = LocalDateTime.now();
        this.statut = StatutTask.TODO;
    }

}
