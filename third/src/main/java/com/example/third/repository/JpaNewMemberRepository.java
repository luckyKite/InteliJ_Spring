package com.example.third.repository;

import com.example.third.domain.NewMember;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class JpaNewMemberRepository {

  private final EntityManager em;

  @Autowired
  public JpaNewMemberRepository(EntityManager em) {
    this.em = em;
  }

  public String save() {
    NewMember member = new NewMember();
    member.id = "4";
    member.username = "jpa_test";
    em.persist(member);
    return member.id;
  }

}
