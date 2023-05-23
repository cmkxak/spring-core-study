package me.inflearn.springcorereviewall;

import me.inflearn.springcorereviewall.member.Grade;
import me.inflearn.springcorereviewall.member.Member;
import me.inflearn.springcorereviewall.member.MemberService;
import me.inflearn.springcorereviewall.order.Order;
import me.inflearn.springcorereviewall.order.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        OrderService orderService = appConfig.orderService();
//        MemberService memberService = appConfig.memberService();

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = ac.getBean("orderService", OrderService.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "itemA", 20000);

        System.out.println("order = " + order);


    }
}
