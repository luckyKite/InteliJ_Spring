package com.example.second.service;

import com.example.second.repository.JpaMemberRepository;
import com.example.second.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

  private final DataSource dataSource;

  private final EntityManager em;

  public SpringConfig(DataSource dataSource, EntityManager em) {
    this.dataSource = dataSource;
    this.em = em;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    //return new MemberRepository();
    //return new JDBCTemplateMemberRepository(dataSource);
    return new JpaMemberRepository(em);
  }

}
