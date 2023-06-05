package me.inflearn.springcorereviewall.autowired;

import me.inflearn.springcorereviewall.member.Member;
import me.inflearn.springcorereviewall.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption() {
        //스프링 컨테이너 생성 시 빈 등록 및 의존관계 설정
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean{
        //자동 주입할 대상이 없으면 메서드 호출 안됨
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("member = " + member);
        }
        //자동 주입할 대상이 없으면 null이 입력됨
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("member = " + member);
        }
        //자동 주입할 대상이 없으면 Optional.empty가 입력됨
        @Autowired
        public void setNoBean2(Optional<Member> member) {
            System.out.println("member = " + member);
        }
    }

}
