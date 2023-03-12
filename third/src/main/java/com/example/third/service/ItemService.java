package com.example.third.service;

import com.example.third.domain.Item;
import com.example.third.domain.ItemDTO;
import com.example.third.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional(readOnly = true) //mysql을 사용하려면 붙여야 함, 여러번 수정된다고 하면 마지막에 있는 것을 확인 할 수 있어야 된다.
@RequiredArgsConstructor
public class ItemService { //@MemoryRepository에서는 Transactional 안써도 동작함 => mysql 접근 안하고 내꺼에서만 동작되기 때문에!

  private final ItemRepository itemRepository;

  //@RequiredArgsConstructor 쓰면 여기에 주석 처리 필요함.
//  public ItemService(ItemRepository itemRepository) {
//    this.itemRepository = itemRepository;
//  }

  @Transactional
  public Long addItem(ItemDTO itemDTO) {
    Item item = new Item(itemDTO.getItemName(), itemDTO.getPrice(), itemDTO.getQuantity());
    return itemRepository.save(item).getId();
  }

  public List<Item> allItem() {
    return itemRepository.findAll();
  }

  public Optional<Item> findItemById(Long id) {
    return itemRepository.findById(id);
  }

  @Transactional
  public void updateItem(Long id, ItemDTO itemDTO) {
    Item item = itemRepository.findById(id).get();
    item.setItemName(itemDTO.getItemName());
    item.setPrice(itemDTO.getPrice());
    item.setQuantity(itemDTO.getQuantity());
    itemRepository.update(id, item);
  }
}
