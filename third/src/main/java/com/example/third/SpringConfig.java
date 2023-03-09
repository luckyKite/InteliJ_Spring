package com.example.third;

import com.example.third.repository.ItemRepository;
import com.example.third.repository.MemoryItemRepository;
import com.example.third.service.ItemService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

  //private final EntityManager em;

//  private final DataSource dataSource;
//
//  public SpringConfig(DataSource dataSource) {
//    this.dataSource = dataSource;
//  }

  @Bean
  public ItemService itemService() {
    return new ItemService(itemRepository());
  }

  @Bean
  public ItemRepository itemRepository() {
    return new MemoryItemRepository();
  }
}
