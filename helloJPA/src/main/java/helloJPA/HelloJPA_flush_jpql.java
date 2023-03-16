package helloJPA;

import domain.Member;

import javax.persistence.*;
import java.util.List;

public class HelloJPA_flush_jpql {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    System.out.println("트렌젝션 시작 전~");
    tx.begin();

    //여기 실습 할때는 Member에서 //@GeneratedValue(strategy = GenerationType.IDENTITY)로 주석처리 하고 실행해야함!
    try {
      Member m1 = new Member(300L, "test300");
      Member m2 = new Member(301L, "test301");
      Member m3 = new Member(302L, "test302");

      em.persist(m1);
      em.persist(m2);
      em.persist(m3);
      System.out.println("영속상태-----");

      List<Member> members = em.createQuery("select m from Member as m where id >:id", Member.class)
                .setParameter("id", 300L)
                .getResultList();

      for(Member member : members) {
        System.out.println("member = " + member);
      }

      System.out.println("커밋전");
      tx.commit();
      System.out.println("커밋후");

    } catch (Exception e) {
      System.out.println(e.getMessage());
      tx.rollback();

    } finally {
      em.close();
    }
    emf.close();
  }
}
