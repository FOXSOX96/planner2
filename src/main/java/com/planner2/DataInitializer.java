package com.planner2;


import com.planner2.common.config.PasswordEncoder;
import com.planner2.domain.comment.entity.Comment;
import com.planner2.domain.comment.repository.CommentRepository;
import com.planner2.domain.planner.entity.Planner;
import com.planner2.domain.planner.repository.PlannerRepository;
import com.planner2.domain.user.entity.User;
import com.planner2.domain.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PlannerRepository plannerRepository;
    private final CommentRepository commentRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PlannerRepository plannerRepository, CommentRepository commentRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.plannerRepository = plannerRepository;
        this.commentRepository = commentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {


        // 유저 준비
        User LGJ = new User("임꺽정", "임꺽정@gmail.com", passwordEncoder.encode("abcd1234!"));
        // 일정 준비
        Planner LGJ1 = new Planner(LGJ, "오늘할일1", "내용");
        Planner LGJ2 = new Planner(LGJ, "오늘할일2", "내용");
        Planner LGJ3 = new Planner(LGJ, "오늘할일3", "내용");


        // 댓글 준비
        Comment LGJ1C1 = new Comment(LGJ, LGJ1, "댓글1");
        Comment LGJ1C2 = new Comment(LGJ, LGJ1, "댓글2");
        Comment LGJ1C3 = new Comment(LGJ, LGJ1, "댓글3");


        // 유저 생성
        userRepository.save(LGJ);

        // 일정 생성
        plannerRepository.save(LGJ1);
        plannerRepository.save(LGJ2);
        plannerRepository.save(LGJ3);

        // 댓글 생성
        commentRepository.save(LGJ1C1);
        commentRepository.save(LGJ1C2);
        commentRepository.save(LGJ1C3);
    }
}
