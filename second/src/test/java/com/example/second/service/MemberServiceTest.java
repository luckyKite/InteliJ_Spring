package com.example.second.service;

import com.example.second.domain.Member;
import com.example.second.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
  MemberService memberService;
  MemoryMemberRepository memberRepository;

  @BeforeEach
  void 준비_셋팅() {
    memberRepository = new MemoryMemberRepository();
    memberService = new MemberService(memberRepository);
  }

  @AfterEach
  void 데이터_초기화() {
    memberRepository.clear();
  }

  @Test
  void 회원가입_테스트() { //정상정인 경우
    //given
    Member member = new Member();
    member.setName("홍길동");

    //when
    memberService.join(member);

    //then
    Optional<Member> findMember = memberRepository.findById(member.getId());
    assertThat(findMember.get()).isEqualTo(member);
  }

  @Test
  void 중복_회원가입_테스트() { //오류 발생하는 경우
    //given
    Member member = new Member();
    member.setName("신짱구");

    Member member1 = new Member();
    member1.setName("신짱구");

    //when
    memberService.join(member);

    //then
    //에러가 발생하도록 설계했으므로 에러가 발생해야 함!
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member1));
    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
  }

  @Test
  void 전체_회원목록_테스트() {
    //given
    Member member = new Member();
    member.setName("홍길동");

    Member member1 = new Member();
    member1.setName("신짱구");

    //when
    memberService.join(member);
    memberService.join(member1);

    //then
    assertThat(memberRepository.findAll().size()).isEqualTo(2);
  }
}