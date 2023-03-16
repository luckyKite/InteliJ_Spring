package helloJPA;

import domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HelloJPA_flush {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    System.out.println("트렌젝션 시작 전~");
    tx.begin();

    //여기 실습 할때는 Member에서 //@GeneratedValue(strategy = GenerationType.IDENTITY)로 주석처리 하고 실행해야함!
    try {
      Member m1 = new Member(200L, "test2");
      em.persist(m1);
      System.out.println("영속상태-----");

      em.flush();
      System.out.println("커밋전");
      tx.commit();

      System.out.println("커밋후");
      System.out.println("m1 = "+m1);

      Member m2 = em.find(Member.class, 200L);
      System.out.println("m2 = "+m2);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      tx.rollback();

    } finally {
      em.close();
    }
    emf.close();
  }
}
