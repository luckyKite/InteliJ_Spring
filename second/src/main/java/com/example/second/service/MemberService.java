package com.example.second.service;

import com.example.second.domain.Member;
import com.example.second.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
  private final MemberRepository memberRepository;

  @Autowired
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
    //this.memberRepository = new MemoryMemberRepository();
  }

  /**
   * 회원가입
   * */
  public Long join(Member member) {
    //중복 회원 존재 여부 검증
    validateDupMember(member);

    //회원 추가
    memberRepository.save(member); //controller에서 전달받은 멤버값을 jdbc save()로 보냄.
    return member.getId();
  }

  /**
   * 중복회원 등록 여부 확인
   * */
  private void validateDupMember(Member member) { //.ifPresent() 존재하면 ~
    memberRepository.findByName(member.getName()).ifPresent(m -> {
      throw new IllegalStateException("이미 존재하는 이름입니다.");
    });
  }


  /**
   * 전체 회원 정보 조회
   * */
  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  /**
   * 한명의 회원정보 조회
   * */
  public Optional<Member> findMemberById(Long id) {
    return memberRepository.findById(id);
  }
}
