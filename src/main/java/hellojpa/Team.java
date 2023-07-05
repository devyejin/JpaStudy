package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Team {

    @Id
    @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;
    private String name;

    //이제 객체의 패러다임의 대시작 ㅋㅋ 양방향을 부여해보자

    @OneToMany(mappedBy = "team") //mappedBy는 상대 테이블(member)에서 누구랑 관련있는지
    private List<Member> members = new ArrayList<>(); //초기화해두는 것이 관례

    public void addMembers(Member member) {
       member.setTeam(this);
       this.members.add(member);
    }
}
