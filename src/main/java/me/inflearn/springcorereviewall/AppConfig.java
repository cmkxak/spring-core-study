package me.inflearn.springcorereviewall;

import me.inflearn.springcorereviewall.discount.DiscountPolicy;
import me.inflearn.springcorereviewall.discount.RateDiscountPolicy;
import me.inflearn.springcorereviewall.member.MemberService;
import me.inflearn.springcorereviewall.member.MemberServiceImpl;
import me.inflearn.springcorereviewall.member.MemoryMemberRepository;
import me.inflearn.springcorereviewall.order.OrderService;
import me.inflearn.springcorereviewall.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//역할이 다 드러나도록 메서드로 다 분리해준다.
//역할들이 나오고 그 역할에 대한 구현 클래스가 무엇인지 한눈에 파악할 수 있다!
@Configuration
public class AppConfig {

    //@Bean -> memberService -> new MemoryMemberRepository()

    //@Bean -> orderService -> new MemoryMemberRepository(), new RateDiscountPolicy()

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
