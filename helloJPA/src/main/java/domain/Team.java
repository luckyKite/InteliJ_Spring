package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Team {
  @Id
  @Column(name = "team_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long teamId;

  public String name;

  @Override
  public String toString() {
    return "Team{" +
        "teamId=" + teamId +
        ", name='" + name + '\'' +
        '}';
  }
}
