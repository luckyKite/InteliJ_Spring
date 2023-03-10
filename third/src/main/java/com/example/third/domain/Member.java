package com.example.third.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "login_id", length = 10)
  private String loginId; //loginId => login_id 자동으로 필드 이름 변경

  @Column(length = 45, nullable = false)
  private String name;

  @Column(length = 45, nullable = false)
  private String password;

  @Override
  public String toString() {
    return "Member{" +
        "id=" + id +
        ", loginId='" + loginId + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
