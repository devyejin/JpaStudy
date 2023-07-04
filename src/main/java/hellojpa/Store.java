package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity // SEQUENCE 객체를 공유하는지 궁금해서 테스트
@SequenceGenerator(
        name = "STORE_SEQ_GENERATOR", //시퀀스 객체 이름
        sequenceName = "STORE_SEQ", //데이터베이스에 등록된 시퀀스 이름(기본은 hibernate_sequence)
        initialValue = 1 //시퀀스 시작값, 호출시마다 증가하는 값
)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                generator= "STORE_SEQ_GENERATOR")
    private Long id;
    private String productName;

    public Store(String productName) {
        this.productName = productName;
    }
}
