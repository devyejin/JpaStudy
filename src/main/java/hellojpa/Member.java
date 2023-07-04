package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //SEQUENCE전략은 DB '시퀀스 오브젝트'한테 위임 -> 숫자만가능
    private Long id;
    @Column(name="name", columnDefinition = "varchar(100) default 'EMPTY'") //ubdatable=false 시 변경불가
    private String username;


    public Member() { } //JPA가 리플렉션을 이용하기때문에 기본 생성자 필수!

    public Member(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
