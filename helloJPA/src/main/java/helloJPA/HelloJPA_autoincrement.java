package helloJPA;

import domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
//왜 1,2,3 영속이 순서대로 안나오는건지????ㅜㅜ create 해도 안해도 안돼요...
public class HelloJPA_autoincrement {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    System.out.println("트렌젝션 시작 전~");
    tx.begin();

    try {
      Member m1 = new Member("test100"); //아이디값까지 적어주면 쭉 비용속으로 내려오게 되는것이다. -> 영속상태 사이에 찍히지 않음
      Member m2 = new Member("test200");
      Member m3 = new Member("test300");
      System.out.println("비영속상태------");

      em.persist(m1);
      System.out.println("1영속상태-----");
      em.persist(m2);
      System.out.println("2영속상태-----");
      em.persist(m3);
      System.out.println("3영속상태-----");

      Member fm1 = em.find(Member.class, m1.id);
      System.out.println("1차 캐시에서 가져옴");
      System.out.println("fm1 = "+fm1);

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
