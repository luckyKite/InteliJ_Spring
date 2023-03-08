package com.example.third.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {
  private Long id;
  private String itemName;
  private Integer price;
  private Integer quantity;
}
