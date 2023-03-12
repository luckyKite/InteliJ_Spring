package com.example.third.repository;

import com.example.third.domain.Item;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.*;

@RequiredArgsConstructor
public class JpaItemRepository implements ItemRepository {

  private final EntityManager em;

  @Override
  public Item save(Item item) {
    if(item.getId() == null) { //new item
      em.persist(item);
    } else {
      em.merge(item); //update exist item
    }
    return item;
  }

  @Override
  public Optional<Item> findById(Long id) {
    return Optional.ofNullable(em.find(Item.class, id));
  }

  @Override
  public List<Item> findAll() {
    return em.createQuery("select i from Item i", Item.class).getResultList();
  }

  @Override
  public void update(Long id, Item item) {

  }

}
