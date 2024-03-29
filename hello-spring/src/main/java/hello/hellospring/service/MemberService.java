package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepositoryImpl;

import java.util.Optional;

public class MemberService {
  private final MemberRepository memberRepository = new MemoryMemberRepositoryImpl();

  // 회원가입
  public Long join(Member member){
    // 같은 이름이 있는 중복 회원 가입 X
    /*Optional<Member> result = memberRepository.findByName(member.getName());
    result.ifPresent(member1 -> {
      throw new IllegalStateException("이미 존재하는 회원입니다.");
    });*/

    memberRepository.findByName(member.getName())
            .ifPresent(member1 -> {
      throw new IllegalStateException("이미 존재하는 회원입니다.");
    });

    memberRepository.save(member);
    return member.getId();
  }
}
