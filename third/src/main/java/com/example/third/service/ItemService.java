package com.example.third.service;

import com.example.third.domain.Item;
import com.example.third.domain.ItemDTO;
import com.example.third.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

public class ItemService {
  private final ItemRepository itemRepository;

  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

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

  public void updateItem(Long id, ItemDTO itemDTO) {
    Item item = itemRepository.findById(id).get();
    item.setItemName(itemDTO.getItemName());
    item.setPrice(itemDTO.getPrice());
    item.setQuantity(itemDTO.getQuantity());
    itemRepository.update(id, item);
  }
}
