package pentrubiserici.manager.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class Member {
    private String firstName;
    private String lastName;
    private String address;
    private String birthDate;
    private String baptizedate;
    private String phone;
    private int gender;

    public Member() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Member(String firstName, String tel) {
        this.firstName = firstName;
        this.phone=tel;
    }
}
