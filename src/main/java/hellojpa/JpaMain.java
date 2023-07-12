package hellojpa;



import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;


public class JpaMain {

    public static void main(String[] args) {
        //EntityManagerFactory는 애플리케이션에 하나, EntityManager는 트랜잭션 당 하나
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //DB연결 등 다 해결됨
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //트랜잭션 시작 - JPA는 모든 작업을 트랜잭션 단위안에서 해야함

        try {
            //등록
//            Member member2 = new Member();
//            member2.setId(2L);
//            member2.setName("memberB");
//            em.persist(member2);

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
//            for(Member member2 : result) {
//                System.out.println("member2 name = " + member2.getName());
//            }

//            Member member2 = new Member();
//            member2.setId(3L);
//            member2.setName("memberC");//<-----------비영속 상태
//
//            em.persist(member2); // <---- 영속 상태, 아직 DB에 저장안됨
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
//            Member member2 = em.find(Member.class, 100L);
//            member2.setName("workbook");
//
//            //em.persist(member2); <--- 이렇게 할 필요가 없음!
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
//            Member member2 = em.find(Member.class, 100L);
//            member2.setName("KKKKKK"); //<- 아직 커밋전이므로 영속 컨텍스트 1차캐시에만 더티상태 (DB 미반영)
//
//            //<---- 트랜잭션 전에, 준영속 상태로 만든다면?
//            em.detach(member2);
//            System.out.println("member2 이름 : " + member2.getName());
//            System.out.println("===== 트랜잭션 커밋 전 ======");
//            tx.commit(); //이때 SQL에 쿼리를 날림

//            Member member2 = em.find(Member.class, 100L); //<-쿼리 날라감
//            member2.setName("TTTTTT"); // 영속 상태
//
//            em.clear(); //영속 컨텍스트 다 비움
//
//            Member member2 = em.find(Member.class, 100L); //<- 컨텍스트 비웠으니 쿼리 또 날라감
//            System.out.println("====== 트랜잭션 커밋 전 =====");

            //기본키  1.@Id
//            Member member2 = new Member();
//            member2.setUsername("userA");
//            em.persist(member2);

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
//            System.out.println("===========");
//
//            for(int i=0; i<270; i++) {
//                em.persist(new Store("test"));
//            }
//
//            System.out.println("=============");
//

            //----------------------------------------------------------------------------------
            //객체 중심의 설계
            //저장, 팀에 회원을 저장할 때
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setTeam(team); //<--- 객체와 객체간의 관계를 맺어줌! 오호
//            em.persist(member2);
//
//
//            //우선 강제로 쿼리날리고
//            em.flush();
////            em.close(); //<-- 영속 컨텍스트 비우기 oh~no~ close가 아니라 clear
//            em.clear();
//
//            //조회
//            Member findMember = em.find(Member.class, member2.getId());
////            Team team1 = em.find(Team.class, findMember.getTeam().getId());
////            System.out.println(team1.getMembers().size()); <-- 궁금해서 테스트
//
//            List<Member> members = findMember.getTeam().getMembers();
//
//            for(Member m : members) {
//                System.out.println("회원들 나열 : " + m.getUsername());
//            }
//

            //-------------------------------------------------------------------
            //Team, Member에서 Member가 주인이므로, Member에서 Team정보를 입력해줘야함
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            //member에서 team을 정해줘야하는데 입력안하는 실수를 많이들 함
//            member2.setTeam(team); //<---- 이게 옳은 설정
//            em.persist(member2);
//
//            em.flush(); //커밋전 sql 날려서 DB랑 동기화해주고
//            em.clear(); //1차 캐시 비워주고
//
//            Team findTeam = em.find(Team.class, team.getId()); //<--이때 DB에서 읽어오 거 이용
//            List<Member> members = findTeam.getMembers();
//
//            for(Member m : members) {
//                System.out.println("member2 : " + m.getUsername());
//            }

            //-----------------------------------------------------------------
            //편의 메서드 사용한 로직
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member2 = new Member();
//            member2.setUsername("memberA");
////            member2.setTeam(); <--- 개별 로직보다는
//            member2.changeTeam(team); //<---양방향 값 들어가도록 '편의 메서드'
//            em.persist(member2);
//
//            //이제 양방향으로 값이 들어간거니까 flush, clear안하고 1차캐시에서 조회해도 조회되겠지
//            Team findTeam = em.find(Team.class, team.getId());
//
//            List<Member> members = findTeam.getMembers();
//
//            for(Member m : members) {
//                System.out.println("TeamA 회원 조회 : " + m.getUsername());
//            }

            //편의 메서드를 주인이 아닌쪽에서 만들었다면
//            Member member2 = new Member();
//            member2.setUsername("memberA");
////            em.persist(member2); //<-- 여기서 추가하면 안됨! addMembers() 에서도 추가되는 내용이 있음
//
//            Team team = new Team();
//            team.setName("TeamA");
//            team.addMembers(member2); //<-- 생성한 편의메서드
//            em.persist(team);
//            em.persist(member2);
//
//            //flush, clear없이 1차캐시에서도 양방향으로 조회가능하겠쥬
//            //1. 멤버->팀 조회
//            Member findMember = em.find(Member.class, member2.getId());
//            System.out.println(findMember.getTeam().getName());

            //일대다 단방향 Team -> Member (Team에서 외래키를 관리하는 경우)
            //Team에서 member2 등록할거니까 member부터
//            Member member2 = new Member();
//            member2.setUsername("member2"); //실무에서는 setter잘 안씀
//
//            em.persist(member2);
//
//            Team team = new Team();
//            team.setName("teamA");
//            team.getMembers().add(member2);  // <--- 요기가 문제, Member테이블에서 업데이트가 되야할 내용인데
//            // MEMBER는 앞에서 영속 컨텍스트로 들어가버렸내?!
//
//            em.persist(team);


            //테이블 조인전략
            //영화 등록(INSERT)
//            Movie movie = new Movie();
//            movie.setActor("who");
//            movie.setName("엘리멘탈");
//            movie.setDirector("벤자민");
//            movie.setPrice(15000);
//            em.persist(movie);
//
//            em.flush();
//            em.clear(); //영속성 컨텍스트 1차캐시 비움
//                        //이제 조회(쿼리)시 DB에서 불러오겠지
//            //조회
//            Movie findMovie = em.find(Movie.class, 1L);
//            System.out.println("findMovie Name" + findMovie.getName());

            //---------------------------------------
            //프록시

            //상황 가정
//            Team team = new Team();
//            team.setName("TeamA");
//
//            Member member2 = new Member();
//            member2.setUsername("userA");
//            member2.setTeam(team);
//
//            em.persist(team);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();

//            //조회 - Member를 ㅈ회할 때 Team도 조회해야할까?
//            Member member2 = em.find(Member.class, 1L);
//            printMemberAndTeam(member2); // 둘 다 필요한경우는 필요
//
//            //하지만 로직이 변경되서 Member만 필요하다면? - Team까지 데려온다면 리소스낭비
//            printMember(member2);

            //프록시 테스트
//            Member member2 = new Member();
//            member2.setUsername("hello");
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
////            Member findMember = em.find(Member.class, member2.getId());
//            //em.find() -> em.getReference()
//            Member findMember = em.getReference(Member.class, member2.getId()); // <--- findMember는 프록시객체
//
//            System.out.println("findMember.id = " + findMember.getId()); //<- 여기 getId()이건 모르겠음
//
//            System.out.println("findMember.username = " + findMember.getUsername());
//            // <-- getUsername()를 요구하면 프록시객체 내부에서 target.getId() 가 발생하고 실제 값을 받게되는거쥬
//

            //지연 로딩
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Team teamB = new Team();
//            teamB.setName("teamB");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("hello");
//            member1.setTeam(team);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("hello2222");
//            member2.setTeam(teamB);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
////            Member m = em.find(Member.class, member2.getId());
//
//            //즉시로딩(EAGER)을 지양해야 하는 이유 - JPQL 예시
//            List<Member> members = em.createQuery("select m from Member m  left join fetch m.team", Member.class)
//                    .getResultList();
//            // Member 조회 쿼리 나감 -> Member 조회하며 필드보니 EAGER(즉시로딩)이네 -> Team 조회 쿼리 나감



            //CASCADE
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent); //CASCADE라 부모,자식 다 저장
//
//            em.flush();
//            em.clear(); //영속 컨텍스트 청소
//
////            Parent findParent = em.find(Parent.class, parent.getId());//준영속 상태되도 영속->준영속시 식별자 값 갖고있음
////            findParent.getChildList().remove(0); //부모에서 제거
//
//            //부모를 제거하면 -> 자식은 남음 (false인경우)
//            em.remove(findParent);




//            System.out.println("======부모에서만 떼어냄=======");
//            for(Child child : findParent.getChildList()) {
//                System.out.println(child.getId()); //3 (하나만 나옴)
//            }


            Member member = new Member();
            member.setUsername("member1");

            member.setHomeAddress(new Address(
                    "homeCity","street","zipcode"));
            //member.getFavoriteFoods() 하면 Set<String> 즉, 컬렉션이 반환되니까 컬렉션에 담아주는거지
            member.getFavoriteFoods().add("꾸부라꼬");
            member.getFavoriteFoods().add("카페라떼");
            member.getFavoriteFoods().add("회");

            //값 타입 컬렉션 대신 -> 1:N을 활용
            member.getAddressEntities().add(new AddressEntity("old1", "street", "zipcode"));
            member.getAddressEntities().add(new AddressEntity("old2", "street", "zipcode"));



            em.persist(member);

            em.flush();
            em.clear();

//            System.out.println("================== 조회 시작 ==================");
//            Member findMember = em.find(Member.class, member.getId());// <--- 영속 컨텍스트 비워도 Entity에 식별자값은 남아있음

//            //컬렉션 값 타입은 지연로딩, 필요시 조회 쿼리가 나간다.
//            System.out.println("================== 컬렉션은 지연로딩, Addr 조회 ==================");
//
//            findMember.getHomeAddress();
//            for( Address address : addressHistory) {
//                System.out.println("address = " + address.getCity());
//            }
//
//            System.out.println("================== 컬렉션은 지연로딩, favoritfood 조회 조회 ==================");
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for(String foavortefood : favoriteFoods) {
//                System.out.println("foavortefood = " +foavortefood);
//            }
//
//            // 값 타입 수정은 어떻게 할까?!! (immutable object인데) => 부작용 방지를 위해 setter 안만듬(권장, 만들고자하면 만들긴하지만)
//            //주소 중 city만 변경되고 zipcode등은 동일하다면, 기존값찾아서 이용
//            Address homeAddress = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("new change city", homeAddress.getStreet(), homeAddress.getZipcode()));
//            // -> 여기서 persist안해도 되나?하겠지만 영속 컨텍스트에 담긴 상태라 dirty check 해줌 + 밑에 트랜잭션
//
//            // 값 타입 컬렉션인 경우
//            // 컬렉션에 있는 꾸부라꼬 -> 베이글로 변경하고 싶으면?! -> 지우고 새로운거 추가? -> 빙고
//            findMember.getFavoriteFoods().remove("꾸부라꼬");
//            findMember.getFavoriteFoods().add("무화과 크림치즈 베이글");
//
//            //old1 주소를 -> new1 으로 변경하고싶다면?
//            //remove(object) object.equals(xxx) = true인 대상을 찾아서 지워주도록 내부 로직이 짜여잇음
//            //즉, equals hashCode가 제대로 구현되지 않았다면 값이 지워지지 않는다!!!! ohho!!
//            System.out.println("========== 값 타입 컬렉션 주소 삭제 + 추가 ================");
//            findMember.getAddressHistory().remove(new Address("old1", "street", "zipcode"));
//            findMember.getAddressHistory().add(new Address("newCity1", "street", "zipcode"));






            tx.commit();

        }catch (Exception e) {
            System.out.println(e.getMessage());
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }


    }

//    private static void printMember(Member member) {
//    }
//
//    private static void printMemberAndTeam(Member member) {
//        Team team = member.getTeam();
//        System.out.println("username" + member.getUsername());
//        System.out.println("teamname" + team.getName());
//    }
}
