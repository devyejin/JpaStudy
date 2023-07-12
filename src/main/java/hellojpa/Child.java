package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Child {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    //연관관계 주인
    @ManyToOne
    @JoinColumn(name="PARENT_ID")
    private Parent parent;
}
