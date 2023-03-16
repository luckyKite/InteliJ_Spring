package helloJPA;

import domain.MemberO;
import domain.MemberType;
import domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HelloJPA_memberO_team {
  public static void main(String[] args) {
    //스프링이 ENF를 만들어줌, 스프링 안써서 직접 만듦.
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    System.out.println("트렌젝션 시작 전~");
    tx.begin();

    try {
      //팀생성
      Team team = new Team();
      team.setName("teamA");
      em.persist(team);
      System.out.println("team = "+ team);

      //멤버생성
      MemberO memberO = new MemberO("teamtest", MemberType.EXECUTIVE);

      //참조를 사용해서 연관관계 설정
      memberO.setTeam(team);
      em.persist(memberO);
      System.out.println("영속상태------");

      MemberO fm = em.find(MemberO.class, memberO.getId());
      System.out.println("1차 캐시에서 가져옴------");
      System.out.println("fm = "+fm);

      //참조를 사용해서 연관관계 조회
      Team ft = (Team) em.find(Team.class, fm.getTeam().getTeamId());
      System.out.println("ft = "+ft);

      System.out.println("커밋 전!");
      tx.commit();

      System.out.println("커밋 후!");

    } catch (Exception e) {
      System.out.println(e.getMessage());
      tx.rollback();

    } finally {
      em.close();
    }
    emf.close();
  }
}
