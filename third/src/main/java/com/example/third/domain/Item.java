package com.example.third.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Item {

  @Id //javax.persistence.Id ==> primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql auto-increment
  private Long id;

  @Column(name = "item_name", nullable = false, length = 100)
  private String itemName;
  private Integer price;
  private Integer quantity;

  public Item(String itemName, Integer price, Integer quantity) {
    this.itemName = itemName;
    this.price = price;
    this.quantity = quantity;
  }
}
