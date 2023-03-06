package com.example.second.repository;

import com.example.second.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository {

  private static Map<Long, Member> map = new HashMap<>();

  private static long seq = 0L;

  @Override
  public Member save(Member member) {
    member.setId(++seq);
    map.put(member.getId(), member);
    return member;
  }

  @Override
  public Optional<Member> findById(Long id) {
    return Optional.ofNullable(map.get(id)); //{1L,홍길동} Ehsms null => 빈 객체
  }

  @Override
  public Optional<Member> findByName(String name) { //name이 unique 하다는 가정하에 비즈니스 로직 구성
    //map.values() => List<Member>
//    for(Member member : map.values()) {
//      if(member.getName().equals(name)) {
//        return member;
//      }
//    }
    Optional<Member> any1 = map.values().stream().filter(m -> m.getName().equals(name)).findAny();
    return any1;
  }

  @Override
  public List<Member> findAll() {
    return new ArrayList<>(map.values());
  }

  public void clear() {
    map.clear();
  }
}
