package com.example.third.service;

import com.example.third.domain.Member;
import com.example.third.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true) //readOnly로 두면 업데이트가 안돼기 때문에 update가 필요한 곳에는 @Transactional로 줘야함.
public class MemberService {
  
  private final MemberRepository memberRepository;
  
  @Autowired
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }
  
  @Transactional
  public Long join(Member member) throws IllegalStateException { //memberController에서 예외처리를 해줘야 함!
    validateDuplicateLoginId(member.getLoginId());
    return memberRepository.save(member).getId();
  }
  
  public void validateDuplicateLoginId(String loginId) {
    if(!findMember(loginId).isEmpty()) { //동일한 로그인아이디가 존재한다는 것
      throw new IllegalStateException("이미 존재하는 아이디 입니다.");
    }
  }
  
  public Optional<Member> findMember(String loginId) {
    return memberRepository.findByLoginId(loginId);
  }

  public Optional<Member> findMemberId(Long id) {
    return memberRepository.findById(id);
  }
}
