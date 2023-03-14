package com.example.third.domain;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class NewMember {
  @Id
  @Column(name = "member_id")
  public String id;

  @ManyToOne
  @JoinColumn(name = "team_id")
  public Team team;

  public String username;

  Team getTeam() {
    return team;
  }
}
