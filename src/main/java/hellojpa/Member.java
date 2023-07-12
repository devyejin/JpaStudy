package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * 요구사항 추가
 * 1. 회원 : 일반 회원, 관리자 구분
 * 2. 회원 가입일, 수정일
 * 3. 회원 설명할 수 있는 필드 추가, 길이 제한 없음
 */
@Setter
@Getter
@Entity //@Entity이 있어야 jpa가 관리하는 객체가 됨
public class Member {

    @Id //기본 키(PK)
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    @Embedded
    private Address homeAddress; //한개짜리 값타입


    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
        @JoinColumn(name="MEMBER_ID")) //테이블 명 지정 , 외래키 잡기(FK)
    @Column(name="FOOD_NAME") //String 타입으로 값이 하나니까 칼럼명 지정 가능 , 반면에 Address 임베디드 값 타입은 여러개의 필드가 칼럼명으로 됨
    private Set<String> favoriteFoods = new HashSet<>();

//    //값 타입 컬렉션
//    @ElementCollection
//    @CollectionTable(name = "ADDRESS", joinColumns =
//        @JoinColumn(name="MEMBER_ID")) //테이블 명 지정, 외래키 잡기(FK)
//    private List<Address> addressHistory = new ArrayList<>();

    //값 타입 컬렉션대안
    //<-- 이제 여기서 양방향할건지 말건지는 선택의 문제
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="MEMBER_ID")
    private List<AddressEntity> addressEntities = new ArrayList<>(); //Entity니까 1:N 관계 ㅇㅋㅇㅋ



//    @ManyToOne(fetch = FetchType.LAZY) //지연로딩
//    @JoinColumn(name="TEAM_ID") //TEAM에 있는 칼럼명
//    private Team team;

//    @OneToMany(mappedBy = "member")
//    private List<Orders> orers = new ArrayList<>();
//



//    //Member가 주인
//    @OneToOne
//    @JoinColumn(name="LOCKER_ID")
//    private Locker locker;

    //일대다에서 Member -> Team 조회하고싶다면 (양방향, read-only)
//    @ManyToOne
//    @JoinColumn(name="TEAM_ID" insertable = false, updatable = false)
//    private Team team;


//    @Column(name="TEAM_ID")
//    private Long teamId; <-- 테이블 중심


//
//    //@Setter 쓰고, 직접 Setter정의하면 어떻게되지? 직접 쓴게 오버라이드되나?
//    // -> oo된다함


//    public void changeTeam(Team team) {
//        this.team = team;
//        //team(주인이 아닌쪽에서 값을 설정하는 로직을 여기에 반영)
//        team.getMembers().add(this); // add(member)인데, 여기선 member=this니까
//    }
}
