package me.inflearn.springcorereviewall.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//자동으로 스프링 빈 등록
@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    //자동 의존 관계 주입
    @Autowired //ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findByid(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
