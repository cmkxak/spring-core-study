package me.inflearn.springcorereviewall.singleton;

import me.inflearn.springcorereviewall.AppConfig;
import me.inflearn.springcorereviewall.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService = appConfig.memberService();

        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService = " + memberService);

        //MemberService는 MemberService2와 서로 다른 객체이다.
        Assertions.assertThat(memberService).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("스프링 컨테이너")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService = " + memberService);

        //MemberService는 MemberService2와 서로 다른 객체이다.
        Assertions.assertThat(memberService).isSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService single = SingletonService.getInstance();
        SingletonService single2 = SingletonService.getInstance();

        System.out.println("single2 = " + single2);
        System.out.println("single = " + single);

        Assertions.assertThat(single).isSameAs(single2);

        single.logic();
    }
}
