package helloJPA;

import domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HelloJPA_remove {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    System.out.println("트렌젝션 시작 전~");
    tx.begin();

    try {
      Member findMember = em.find(Member.class, 2L);
      System.out.println("영속상태-----");

      em.remove(findMember);
      System.out.println("삭제상태-----");

      System.out.println("커밋전");
      tx.commit();
      System.out.println("커밋후");

      Member findMember2 = em.find(Member.class, 2L);
      System.out.println("findMember2 = "+findMember2);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      tx.rollback();

    } finally {
      em.close();
    }
    emf.close();
  }
}
