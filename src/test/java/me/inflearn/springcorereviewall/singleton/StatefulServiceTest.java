package me.inflearn.springcorereviewall.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleTon() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //ThreadA : A 사용자가 만원을 주문
        int memberAPrice = statefulService.order("memberA", 10000);

        //Thread B : B 사용자가 2만원을 주문
        int memberBPrice = statefulService2.order("memberB", 20000);

        //ThreadA : 사용자 A 주문 금액 조회 : 20000이 나옴.
//        int price = statefulService.getPrice();
//        System.out.println("price = " + price);

        Assertions.assertThat(memberAPrice).isEqualTo(10000);
        Assertions.assertThat(memberBPrice).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}