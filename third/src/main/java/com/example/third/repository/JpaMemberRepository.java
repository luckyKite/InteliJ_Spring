package com.example.third.repository;

import com.example.third.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

  private final EntityManager em;

  @Autowired
  public JpaMemberRepository(EntityManager em) {
    this.em = em;
  }

  @Override
  public Member save(Member member) {
    em.persist(member);
    return member;
  }

  @Override
  public Optional<Member> findById(Long id) {
    return Optional.ofNullable(em.find(Member.class, id));
  }

  @Override
  public Optional<Member> findByLoginId(String loginId) { //대소문자 구분 확인! => login_id jpa ddl-create 자동으로 생성함
    Optional<Member> findMember = em.createQuery("select m from Member m where m.loginId = :loginId", Member.class)
        .setParameter("loginId", loginId)
        .getResultList()
        .stream()
        .filter(member -> member.getLoginId().equals(loginId))
        .findAny();

    return findMember;
  }

  @Override
  public List<Member> findAll() {
    List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
    return members;
  }

  @Override
  public void update(Long id, Member member) {
//    Member findMember = em.find(Member.class, id);
//    findMember.setName(member.getName());
//    findMember.setPassword(member.getPassword());
//    //map.put(member.getId(), findMember);
  }
}
