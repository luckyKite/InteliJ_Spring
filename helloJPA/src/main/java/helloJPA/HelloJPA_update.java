package helloJPA;

import domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HelloJPA_update {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    System.out.println("트렌젝션 시작 전~");
    tx.begin();

    try {
      Member m1 = em.find(Member.class, 3L);

      String before = m1.username;
      System.out.println("수정전 = "+before);
      m1.username = "jpa update";

      System.out.println("영속상태-----");
      System.out.println("커밋전");
      tx.commit();
      System.out.println("커밋후");
      System.out.println("m1 = "+m1);

      Member m2 = em.find(Member.class, 3L);
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
