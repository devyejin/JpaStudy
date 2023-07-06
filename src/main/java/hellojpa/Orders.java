package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Orders {

    @Id
    @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;

    //FK관리하는쪽(주키)
    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name="PRODUCT_ID")
    private Product product;

    private LocalDate orderDate;
    private int count; //수량
}
