package mock.backend.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mock.backend.domain.model.enums.YesNo;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Data
@Table(name = "T_USER",  uniqueConstraints = {@UniqueConstraint(name = "T_USER_USER_NAME_UNIQUE",columnNames = "userName"),
                                              @UniqueConstraint(name = "T_USER_EMAIL_UNIQUE",columnNames = "email")})
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@Where(clause = "DELETED = '0' and ACTIVE='YES'")
public class User extends AbstractEntity
{
    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String mobilePhone;

    private Integer age;

    private String location;

    private String timeZone;

    @Enumerated(EnumType.STRING)
    private YesNo active = YesNo.YES;

    public User() {
        super();
    }

    @Builder
    public User(String firstName, String lastName, String userName, String email, String mobilePhone, Integer age,
                String location, String timeZone, String objectId
    ) {
        super(objectId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.age = age;
        this.location = location;
        this.timeZone = timeZone;
    }
}
