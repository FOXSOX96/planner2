package com.planner2.domain.user.entity;

import com.planner2.common.entity.BaseEntity;
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

    // - 엔티티관계 : 유저 ---0< 일정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 10, nullable = false)
    private String name;
    @Column(length = 30, nullable = false, unique = true) //ID가 될 것이기 때문에 unique
    private String email;
    @Column(length = 100, nullable = false) //암호화된 비밀번호 길이가 긺
    private String password;

    public User (String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    //이메일을 아이디로 사용해서 변경 불가
    public void updateUser (String name, String password){
        this.name = name;
        this.password = password;
    }

}
