package me.inflearn.springcorereviewall.member;

import me.inflearn.springcorereviewall.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void setUp(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given ~가 주어졌을 때
        Member memberA = new Member(1L, "memberA", Grade.VIP);

        //when ~했을 때
        memberService.join(memberA);
        Member findMember = memberService.findMember(memberA.getId());

        //then ~결과를 가진다.
        assertThat(memberA).isEqualTo(findMember);
    }
}
