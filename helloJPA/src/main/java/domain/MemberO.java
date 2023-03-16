package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MemberO {

  @Id
  @Column(name = "member_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne //1,2,3번 회원이 모두 1번팀 소속
  @JoinColumn(name = "team_id")
  private Team team;

  private String username;

  @Enumerated(EnumType.STRING)
  private MemberType memberType;

  public MemberO() { }

  public MemberO(String username, MemberType memberType) {
    this.username = username;
    this.memberType = memberType;
  }

  public MemberO(Long id, String username, MemberType memberType) {
    this.id = id;
    this.username = username;
    this.memberType = memberType;
  }

  @Override
  public String toString() {
    return "MemberO{" +
        "id=" + id +
        ", team=" + team +
        ", username='" + username + '\'' +
        ", memberType=" + memberType +
        '}';
  }
}
