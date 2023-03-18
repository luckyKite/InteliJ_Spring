package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Orders {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;

  @ManyToOne
  @JoinColumn(name = "member_id")
  private MemberO memberO;

  @Override
  public String toString() {
    return "Orders{" +
        "orderId=" + orderId +
        ", memberO=" + memberO +
        '}';
  }
}
