package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 요구사항 추가
 * 1. 회원 : 일반 회원, 관리자 구분
 * 2. 회원 가입일, 수정일
 * 3. 회원 설명할 수 있는 필드 추가, 길이 제한 없음
 */
@Setter
@Getter
//@Entity //@Entity이 있어야 jpa가 관리하는 객체가 됨
public class Member {

    @Id //기본 키(PK)
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;
    @Column(name="USERNAME")
    private String username;

    @OneToMany(mappedBy = "member")
    private List<Orders> orers = new ArrayList<>();




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

//    @ManyToOne // Member가 n이니까
//    @JoinColumn(name="TEAM_ID") //TEAM에 있는 칼럼명
//    private Team team;
//
//    //@Setter 쓰고, 직접 Setter정의하면 어떻게되지? 직접 쓴게 오버라이드되나?
//    // -> oo된다함


//    public void changeTeam(Team team) {
//        this.team = team;
//        //team(주인이 아닌쪽에서 값을 설정하는 로직을 여기에 반영)
//        team.getMembers().add(this); // add(member)인데, 여기선 member=this니까
//    }
}
