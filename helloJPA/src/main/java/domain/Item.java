package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "item_id")
  private Long itemId;

  @Column(name = "item_name")
  private String itemName;

  private Integer price;

  private Integer quantity;

  @Override
  public String toString() {
    return "Item{" +
        "itemId=" + itemId +
        ", itemName='" + itemName + '\'' +
        ", price=" + price +
        ", quantity=" + quantity +
        '}';
  }


}
