package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

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
//            Member findMember = em.find(Member.class, 2L);//em은 일 대신해주는 대리인이라 생각
//            System.out.println("findMember.getId() : " + findMember.getId());
//            System.out.println("findMember.getName() : " + findMember.getName());

            //삭제
//            em.remove(findMember);

            //수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("changeName"); //끝!, DB데이터를 컬렉션에 담긴 객체처럼 관리!, em.persistence() 호출 필요가 없음

            //전체회원을 조회하고 싶다면? JPQL -> 대상이 테이블중심이 아니라 '객체'중심
            List<Member> result = em.createQuery("select m from Member m", Member.class)
                                    .setFirstResult(1) //조회된결과의 1번부터(set)
                                    .setMaxResults(10) //10개를 (set)
                                    .getResultList(); //가져와 (get)

            for(Member member : result) {
                System.out.println("member name = " + member.getName());
            }


            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }


    }
}
