package com.example.first.repository;

import com.example.first.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
  private static Map<Long, Member> map = new HashMap<>();

  private static long nextId = 1L;
  //primitive data types = int, char, long, float, double, boolean

  public Member save(Member member) {
    long id = nextId++;
    member.setId(id);
    map.put(id, member);
    return member;
  }

  public Member findById(long id) { //오토박싱, 언박싱이 되므로 Long으로 쓰지 않아도 괜찮다.
    Member member = map.get(id);
    return member;
  }

  public List<Member> findAll() {
    List<Member> values = new ArrayList<>(map.values()); //주의!!! map.values()를 빠뜨려서 리스트 출력이 안됐다ㅠㅠ
    return values;
  }

}
