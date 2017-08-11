package mock.backend.api.model.user;

import mock.backend.api.enums.YesNo;
import mock.backend.api.model.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/** T_USER
 * Created by semihunaldi on 10.09.2016.
 */

@Entity
@Data
@Table(name = "T_USER",  uniqueConstraints = {@UniqueConstraint(name = "T_USER_USER_NAME_UNIQUE",columnNames = "userName"),
                                              @UniqueConstraint(name = "T_USER_EMAIL_UNIQUE",columnNames = "email")})
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@Where(clause = "DELETED = '0' and ACTIVE='YES'")
public class User extends AbstractEntity
{
    private String password;

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String mobilePhone;

    private String token;

    private Integer age;

    private String location;

    private String timeZone;

    @Enumerated(EnumType.STRING)
    private YesNo active;

}
