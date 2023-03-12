package com.example.third;

import com.example.third.repository.*;
import com.example.third.service.ItemService;
import com.example.third.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

  private final EntityManager em;

  private final DataSource dataSource;

  public SpringConfig(EntityManager em, DataSource dataSource) {
    this.em = em;
    this.dataSource = dataSource;
  }

  @Bean
  public ItemService itemService() {
    return new ItemService(itemRepository());
  }

  @Bean
  public ItemRepository itemRepository() {
    //return new MemoryItemRepository();
    return new JpaItemRepository(em);
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    return new JpaMemberRepository(em);
  }

}
