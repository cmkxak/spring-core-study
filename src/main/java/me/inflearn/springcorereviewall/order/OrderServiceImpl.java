package me.inflearn.springcorereviewall.order;

import lombok.RequiredArgsConstructor;
import me.inflearn.springcorereviewall.discount.DiscountPolicy;
import me.inflearn.springcorereviewall.member.Member;
import me.inflearn.springcorereviewall.member.MemberRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //회원 조회
        Member findMember = memberRepository.findByid(memberId);
        //할인 적용
        int discountPrice = discountPolicy.discount(findMember, itemPrice);
        //생성된 주문 객체 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
