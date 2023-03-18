package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Member {
  @Id
  @Column(name = "member_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  public String username;

  public Member() {}

  public Member(Long id, String username) {
    this.id = id;
    this.username = username;
  }

  public Member(String username) {
    this.username = username;
  }

  @Override
  public String toString() {
    return "Member{" +
        "id=" + id +
        ", username='" + username + '\'' +
        '}';
  }
}
