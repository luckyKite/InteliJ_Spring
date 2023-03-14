package com.example.third.domain;

import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {

  @Id
  @Column(name = "team_id")
  public Long id;

  public String name;
}
