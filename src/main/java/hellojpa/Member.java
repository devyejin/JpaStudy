package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity //@Entity이 있어야 jpa가 관리하는 객체가 됨

public class Member {

    @Id
    private Long id;
    private String name;

    public Member() { } //JPA가 리플렉션을 이용하기때문에 기본 생성자 필수!
}
