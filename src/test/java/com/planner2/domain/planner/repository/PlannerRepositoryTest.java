package com.planner2.domain.planner.repository;

import com.planner2.domain.planner.dto.response.GetPlannerPageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.assertj.core.api.Assertions.assertThat;

/*@DataJpaTest*/
@SpringBootTest //Datainitializer(@Repository만)를 참조해서 테스트할경우 SpringBootTest(@Bean)를 참조해야함
class PlannerRepositoryTest {

    @Autowired
    private PlannerRepository plannerRepository;

    @Test
    void getPlannerPageWithComment() {

        //Given:
        Pageable pageable0 = PageRequest.of(
                0,
                10,
                Sort.by(Sort.Direction.DESC, "modifiedAt")
        );
        Pageable pageable1 = PageRequest.of(
                1,
                10,
                Sort.by(Sort.Direction.DESC, "modifiedAt")
        );

        //When:
        Page<GetPlannerPageResponse> page0 =
                plannerRepository.getPlannerPageWithComment(pageable0);
        Page<GetPlannerPageResponse> page1 =
                plannerRepository.getPlannerPageWithComment(pageable1);

        //Then:
        //한 페이지에 최대 10개, 전체 11개
        assertThat(page0.getContent().size()).isEqualTo(10);
        assertThat(page0.getTotalElements()).isEqualTo(11);
        assertThat(page0.getTotalPages()).isEqualTo(2);

        //일정1에 댓글3개, 일정11에 댓글1개
        assertThat(page1.getContent().get(0).getCommentCount()).isEqualTo(3);
        assertThat(page0.getContent().get(0).getCommentCount()).isEqualTo(1);


    }

}