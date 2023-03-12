package com.example.third.controller;

import com.example.third.domain.Item;
import com.example.third.domain.ItemDTO;
import com.example.third.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/basic")
public class ItemController {

  private final ItemService itemService;

  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @GetMapping("/items")
  public String items(Model model) {
    List<Item> items = itemService.allItem();
    model.addAttribute("items", items);
    return "basic/items";
  }

  @GetMapping("/item/{id}")
  public String item(@PathVariable Long id, Model model) {
    Item item = itemService.findItemById(id).get();
    model.addAttribute("item", item);
    return "basic/item";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Long id, Model model) {
    Item item = itemService.findItemById(id).get();
    model.addAttribute("item", item);
    return "basic/editForm";
  }

  @PostMapping("/edit/{id}") //수정하는 동작
  public String editItemSave(@PathVariable Long id,
                             @ModelAttribute ItemDTO itemDTO,
                             RedirectAttributes redirectAttributes) {
    itemService.updateItem(id, itemDTO);
    redirectAttributes.addAttribute("id", id);
    redirectAttributes.addAttribute("status", true);
    return "redirect:/basic/item/{id}";
  }

  @GetMapping("/add")
  public String addItem() {
    return "basic/addForm";
  }

  @PostMapping("/add")
  public String addItemSave(
//      @RequestParam String itemName,
//      @RequestParam Integer price,
//      @RequestParam Integer quantity) {
    @ModelAttribute ItemDTO itemDTO) {
//    ItemDTO itemDTO = new ItemDTO();
//    itemDTO.setItemName(itemName);
//    itemDTO.setPrice(price);
//    itemDTO.setQuantity(quantity);

    itemService.addItem(itemDTO);
    System.out.println("itemDTO: " + itemDTO);
    return "redirect:/basic/items";
  }

}
