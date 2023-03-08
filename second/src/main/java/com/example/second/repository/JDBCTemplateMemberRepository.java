package com.example.second.repository;

import com.example.second.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//@Repository
public class JDBCTemplateMemberRepository implements MemberRepository {

  private final JdbcTemplate jdbcTemplate;

  //@Autowired
  public JDBCTemplateMemberRepository(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public Member save(Member member) { //받아온 name의 이름으로 멤버를 담는다.
    SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
    jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("name", member.getName());
    Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
    member.setId(key.longValue());
    return member;
  }

  @Override
  public Optional<Member> findById(Long id) {
    List<Member> result = jdbcTemplate.query("select * from member where id =?", memberRowMapper(), id);
    return Optional.ofNullable(result.get(0));
  }

  @Override
  public Optional<Member> findByName(String name) {
    List<Member> result = jdbcTemplate.query("select * from member where name =?", memberRowMapper(), name);
    return result.stream().findAny();
  }

  @Override
  public List<Member> findAll() {
    return jdbcTemplate.query("select * from member", memberRowMapper());
  }

  private RowMapper<Member> memberRowMapper() {
    return (rs, rowNum) -> {
      Member member = new Member();
      member.setId(rs.getLong("id"));
      member.setName(rs.getString("name"));
      return member;
    };
  }
}