package com.planner2.domain.planner.entity;

import com.planner2.domain.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
@Table(name = "planners")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Planner extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String content;

    public Planner (String name, String title, String content){
        this.name = name;
        this.title = title;
        this.content = content;
    }

    public void updatePlanner (String name, String title, String content){
        this.name = name;
        this.title = title;
        this.content = content;
    }

}
