package com.planner2.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.planner2.domain.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    public User (String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void updateUser (String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
