package helloJPA;

import domain.MemberO;
import domain.MemberType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HelloJPA_memberO {
  public static void main(String[] args) {
    //스프링이 ENF를 만들어줌, 스프링 안써서 직접 만듦.
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    System.out.println("트렌젝션 시작 전~");
    tx.begin();

    try {
      MemberO member = new MemberO("member", MemberType.EXECUTIVE);
      MemberO member1 = new MemberO("member1", MemberType.GENERAL);
      MemberO member2 = new MemberO("member2", MemberType.MANAGER);

      System.out.println("=====비영속 상태=====");
      em.persist(member);
      em.persist(member1);
      em.persist(member2);
      System.out.println("=====영속 상태=====");

      MemberO fm = em.find(MemberO.class, member.getId());
      MemberO fm1 = em.find(MemberO.class, member1.getId());
      MemberO fm2 = em.find(MemberO.class, member2.getId());

      System.out.println("1차 캐시에서 가져옴~~~");
      System.out.println("fm = "+fm);
      System.out.println("fm1 = "+fm1);
      System.out.println("fm2 = "+fm2);

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
