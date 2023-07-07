package hellojpa;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@Entity
public class Product {

    @Id
    @GeneratedValue
    @Column(name="PRODUCT_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "product") //Order테이블의 필드명
    private List<Orders> orders = new ArrayList<>();

}
