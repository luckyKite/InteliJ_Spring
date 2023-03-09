package com.example.third.repository;

import com.example.third.domain.Item;

import java.util.*;

public class MemoryItemRepository implements ItemRepository {

  private static final Map<Long, Item> map = new HashMap<>();

  private static Long seq = 0L;

  @Override
  public Item save(Item item) {
    item.setId(++seq);
    map.put(item.getId(), item);
    return item;
  }

  @Override
  public Optional<Item> findById(Long id) {
    return Optional.ofNullable(map.get(id));
  }

  @Override
  public List<Item> findAll() {
    return new ArrayList<>(map.values());
  }

  @Override
  public void update(Long id, Item item) { //여기서 item은 수정된 필드 값을 가지고 있다.
    Item findItem = findById(id).get(); //findItem은 수정되기 전의 필드 값을 가지고 있다.
    System.out.println("findItem : " + findItem);
    findItem.setItemName(item.getItemName());
    findItem.setQuantity(item.getQuantity());
    findItem.setPrice(item.getPrice());
    map.put(id, findItem);
  }
}
