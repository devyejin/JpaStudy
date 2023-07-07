package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
//@Entity

@TableGenerator(
        name = "GRAGE_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnName = "STORE_SEQ", allocationSize = 1
)
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, //테이블전략
            generator = "GRAGE_SEQ_GENERATOR")
    private Long id;


}
