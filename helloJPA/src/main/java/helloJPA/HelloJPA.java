package helloJPA;

import domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HelloJPA {
  public static void main(String[] args) {
    //스프링이 ENF를 만들어줌, 스프링 안써서 직접 만듦.
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    System.out.println("트렌젝션 시작 전~");
    tx.begin();

    try {
      Member member = new Member();
      member.username = "안중근";

      Member member1 = new Member();
      member1.username = "유관순";

      System.out.println("=====비영속 상태=====");

      em.persist(member);
      em.persist(member1);

      System.out.println("=====persist 이후=====");

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
