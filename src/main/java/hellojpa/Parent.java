package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Parent {


        @Id
        @GeneratedValue
        @Column(name = "PARENT_ID")
        private Long id;

        private String name;

        //양방향
        @OneToMany(mappedBy = "parent")
        private List<Child> childList = new ArrayList<>();

        //연관관계 편의 메서드 -> 부모에서 자식넣는거
        public void addChild(Child child) {
                childList.add(child);
                child.setParent(this);
        }


}
