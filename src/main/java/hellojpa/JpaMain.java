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
//            Member findMember = em.find(Member.class, 2L);//em은 일 대신해주는 대리인이라 생각
//            System.out.println("findMember.getId() : " + findMember.getId());
//            System.out.println("findMember.getName() : " + findMember.getName());

            //삭제
//            em.remove(findMember);

            //수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("changeName"); //끝!, DB데이터를 컬렉션에 담긴 객체처럼 관리!, em.persistence() 호출 필요가 없음

            //전체회원을 조회하고 싶다면? JPQL -> 대상이 테이블중심이 아니라 '객체'중심
//            List<Member> result = em.createQuery("select m from Member m", Member.class)
//                                    .setFirstResult(1) //조회된결과의 1번부터(set)
//                                    .setMaxResults(10) //10개를 (set)
//                                    .getResultList(); //가져와 (get)
//
//            for(Member member : result) {
//                System.out.println("member name = " + member.getName());
//            }

//            Member member = new Member();
//            member.setId(3L);
//            member.setName("memberC");//<-----------비영속 상태
//
//            em.persist(member); // <---- 영속 상태, 아직 DB에 저장안됨
//            System.out.println("====== db에 저장 이전 =======");


            //DB저장안되도 영속컨텍스트에서 조회한다는 시도
//            Member memberK = new Member(150L, "memberK");
//            em.persist(memberK); // <-- db에 저장은 안됐지만
//
//            //조회는 가능
//            Member findMemberK = em.find(Member.class, 150L);
//            System.out.println("findMemberK : " + findMemberK.getName());


            //영속 컨텍스트에 없는 데이터를 조회하면 DB에서 조회 -> 영속 컨텍스트 저장 -> 불러옴

//            System.out.println(em.find(Member.class, 2L).getName());
//            System.out.println("=== 커밋 날리기 전 ====");
//            System.out.println("커밋 전 재조회");
//            System.out.println(em.find(Member.class, 2L).getName());

            //영속성 동일성 보장
//            Member findMember1 = em.find(Member.class, 1L);
//            Member findMember2 = em.find(Member.class, 1L);
//            System.out.println("같니? " + (findMember2 == findMember1));
            
            //엔티티 등록 쓰기 지연(버퍼) <-- 조회 이런거말고 '등록'에서! 버퍼기능
//            Member member100 = new Member(100L, "아몬드");
//            Member member101 = new Member(101L, "브리즈");
//
//            em.persist(member100);
//            em.persist(member100); //여기까지는 SQL을 데이터베이스에 안날림 (버퍼 지연)
//            System.out.println("====쿼리 날리기 전====");

            //변경 감지(dirty checking)
//            Member member = em.find(Member.class, 100L);
//            member.setName("workbook");
//
//            //em.persist(member); <--- 이렇게 할 필요가 없음!
//            //영속성 컨텍스트에서 더치 체킹(변경 감지)를 해서, 변경됐으면 트랜잭션시 반영함
//            //기억) JPA는 엔티티를 자바컬렉션처럼 관리하는 것! 컬렉션도 객체를 꺼내서 변경 후 다시 컬렉션에 넣지않음
//            //참조값이기 때문에!
//            System.out.println("=========================");

            //플러시
//            Member flushMember = new Member(200L, "flushMember");
//            em.persist(flushMember);
//
//            //commit 전까지는 SQL을 볼 수도없고 DB에 반영할 수가 없는데, 미리하고싶다면 flush를 직접 호출
//            em.flush(); //커밋전에 flush호출 즉, 변경사항이 반영됨
//            System.out.println("=== 커밋전 ===");

            //준영속상태 예씨
//            Member member = em.find(Member.class, 100L);
//            member.setName("KKKKKK"); //<- 아직 커밋전이므로 영속 컨텍스트 1차캐시에만 더티상태 (DB 미반영)
//
//            //<---- 트랜잭션 전에, 준영속 상태로 만든다면?
//            em.detach(member);
//            System.out.println("member 이름 : " + member.getName());
//            System.out.println("===== 트랜잭션 커밋 전 ======");
//            tx.commit(); //이때 SQL에 쿼리를 날림

//            Member member = em.find(Member.class, 100L); //<-쿼리 날라감
//            member.setName("TTTTTT"); // 영속 상태
//
//            em.clear(); //영속 컨텍스트 다 비움
//
//            Member member2 = em.find(Member.class, 100L); //<- 컨텍스트 비웠으니 쿼리 또 날라감
//            System.out.println("====== 트랜잭션 커밋 전 =====");

            //기본키  1.@Id
//            Member member = new Member();
//            member.setUsername("userA");
//            em.persist(member);

            //과연 sequence객체를 공유할까?
//            Store prod = new Store();
//            prod.setProductName("호올스");
//            em.persist(prod);

            //Table 전략 예시
//            Grade grade = new Grade();
//            em.persist(grade);
//
//            tx.commit();

            //SEQUENCE전략 - Store <- 50개 다 쓰면 또 SEQUENCE객체 데려오는지 테스트
            System.out.println("===========");

            for(int i=0; i<270; i++) {
                em.persist(new Store("test"));
            }

            System.out.println("=============");

            tx.commit();

        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }


    }
}
