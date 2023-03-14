package domain;

import javax.persistence.*;

@Entity
public class Member {
  @Id
  @Column(name = "member_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  public String username;
}
