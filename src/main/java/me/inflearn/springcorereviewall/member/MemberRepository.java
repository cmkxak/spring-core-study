package me.inflearn.springcorereviewall.member;

import org.springframework.stereotype.Component;

public interface MemberRepository {
    void save(Member member);

    Member findByid(Long memberId);
}
