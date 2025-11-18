package com.planner2.domain.comment.entity;

import com.planner2.common.entity.BaseEntity;
import com.planner2.domain.planner.entity.Planner;
import com.planner2.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    // - 엔티티관계 : 유저 -|---0< 댓글
    // - 엔티티관계 : 일정 -|---0< 댓글
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_comment_user",
                    value = ConstraintMode.NO_CONSTRAINT))
    private User user;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "planner_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_comment_planner",
                    value = ConstraintMode.NO_CONSTRAINT))
    private Planner planner;
    @Column(length = 100, nullable = false)
    private String content;

    public Comment(User user, Planner planner, String content) {
        this.user = user;
        this.planner = planner;
        this.content = content;
    }

    public void updateComment(String content) {
        this.content = content;
    }


}
