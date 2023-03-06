package com.example.second.repository;

import com.example.second.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

class MemoryMemberRepositoryTest {
  MemoryMemberRepository memberRepository = new MemoryMemberRepository();

  @AfterEach
  void 저장소_초기화() {
    memberRepository.clear();
  }

  @Test
  @DisplayName("memberRepository save test")
  void 멤버_저장_테스트() {
    //given
    Member member = new Member();
    member.setName("Hong");

    //when
    memberRepository.save(member);

    //then
    Optional<Member> findMember = memberRepository.findById(member.getId());
    //Assertions.assertEquals(member.getName(), findMember.get().getName());
    //Assertions.assertEquals(member, findMember);

    assertThat(findMember.get().getId()).isEqualTo(member.getId());
  }

  @Test
  void 이름으로_멤버_찾기() {
    //given
    Member member = new Member();
    member.setName("Hong");
    memberRepository.save(member);

    //when
    Optional<Member> findMember = memberRepository.findByName("Hong");
    //Member findMember = memberRepository.findByName(member.getName());

    //then
    assertThat(findMember.get().getName()).isEqualTo("Hong");
  }

  @Test
  void findAll() {
    //given
    Member member1 = new Member();
    member1.setName("Hong");
    memberRepository.save(member1);

    Member member2 = new Member();
    member2.setName("Hongkildong");
    memberRepository.save(member2);

    //when
    List<Member> allMembers = memberRepository.findAll();

    //then
    System.out.println("all = " + allMembers);
    assertThat(allMembers.size()).isEqualTo(2);
  }

}