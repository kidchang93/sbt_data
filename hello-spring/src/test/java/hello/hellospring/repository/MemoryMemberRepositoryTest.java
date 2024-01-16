package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemoryMemberRepositoryTest {

  MemberRepository memberRepository = new MemoryMemberRepositoryImpl();

  @AfterEach
  public void afterEach(){
    memberRepository.clearStore();
  }
  @Test
  public void save(){
    Member member = new Member();
    member.setName("spring");

    memberRepository.save(member);

    Member result = memberRepository.findById(member.getId()).get();
    /*System.out.println("(result == member) = " + (result == member));*/
    /*Assertions.assertEquals(member,null);*/
    Assertions.assertThat(member).isEqualTo(result);
  }
  @Test
  public void findByName(){
    Member member1 = new Member();
    member1.setName("spring1");
    memberRepository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    memberRepository.save(member2);

    Member result = memberRepository.findByName("spring2").get();

    Assertions.assertThat(result).isEqualTo(member2);
  }
  @Test
  public void findByAll(){
    Member member1 = new Member();
    member1.setName("spring1");
    memberRepository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    memberRepository.save(member2);

    List<Member> result = memberRepository.findAll();
    Assertions.assertThat(result.size()).isEqualTo(2);
  }
}
