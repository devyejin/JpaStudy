package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        //EntityManagerFactory는 애플리케이션에 하나, EntityManager는 트랜잭션 당 하나
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //DB연결 등 다 해결됨
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //트랜잭션 시작 - JPA는 모든 작업을 트랜잭션 단위안에서 해야함

        try {
            //등록
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("memberB");
//            em.persist(member);

            //조회
            Member findMember = em.find(Member.class, 2L);//em은 일 대신해주는 대리인이라 생각
            System.out.println("findMember.getId() : " + findMember.getId());
            System.out.println("findMember.getName() : " + findMember.getName());



            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }


    }
}
