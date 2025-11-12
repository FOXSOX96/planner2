package com.planner2.domain.planner.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "/planners")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Planner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public Planner (Long id, String name, String title, String content){
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
    }

    public void updatePlanner (Long id, String name, String title, String content){
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
    }

}
