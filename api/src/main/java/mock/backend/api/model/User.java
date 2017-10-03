package mock.backend.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mock.backend.api.model.enums.YesNo;
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
    private YesNo active;

}
