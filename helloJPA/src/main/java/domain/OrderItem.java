package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "order_item")
@Getter
@Setter
public class OrderItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_item_id")
  private Long orderItemId;

  @ManyToOne
  @JoinColumn(name = "item_id")
  private Item item;

  @Column(name = "order_price")
  private Integer orderPrice;

  @Column(name = "order_quantity")
  private Integer orderQuantity;

  @Override
  public String toString() {
    return "OrderItem{" +
        "orderItemId=" + orderItemId +
        ", item=" + item +
        ", orderPrice=" + orderPrice +
        ", orderQuantity=" + orderQuantity +
        '}';
  }
}
