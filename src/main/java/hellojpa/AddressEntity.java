package hellojpa;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 값 타입 컬렉션(Address) 대안
 * 일대다 관계를 위한 엔티티(AddressEntity)를 만들고, 여기에 값 타입을 사용
 */
@Entity
@Table(name="ADDRESS")
public class AddressEntity {

    @Id @GeneratedValue
    private Long id;

    private Address address; //값 타입을 AddressEntity로 한번 wrapping해주는 개념!, 그러면 pk도 이용 가능하니께

    public AddressEntity(String city, String street, String zipcode) {
        this.address = new Address(city, street, zipcode);
    }

    public AddressEntity() {}
}
