package com.planner2.domain.planner.entity;

import com.planner2.domain.common.entity.BaseEntity;
import com.planner2.domain.user.entity.User;
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_planner_user",
                    value = ConstraintMode.NO_CONSTRAINT))
    private User user;
    private String title;
    private String content;

    public Planner(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public void updatePlanner(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
