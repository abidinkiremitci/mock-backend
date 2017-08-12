package mock.backend.api.model.user

import lombok.Data
import lombok.EqualsAndHashCode
import mock.backend.api.enums.YesNo
import mock.backend.api.model.AbstractEntity
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.Where
import javax.persistence.*

@Entity
@Data
@Table(name = "T_USER", uniqueConstraints = arrayOf(UniqueConstraint(name = "T_USER_USER_NAME_UNIQUE", columnNames = arrayOf("userName")),
        UniqueConstraint(name = "T_USER_EMAIL_UNIQUE", columnNames = arrayOf("email"))))
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@Where(clause = "DELETED = '0'")
class User : AbstractEntity()
{
    internal var password: String? = null

    internal var firstName: String? = null

    internal var lastName: String? = null

    internal var userName: String? = null

    internal var email: String? = null

    internal var mobilePhone: String? = null

    internal var token: String? = null

    internal var age: Int? = null

    internal var location: String? = null

    internal var timeZone: String? = null

    @Enumerated(EnumType.STRING)
    internal var active: YesNo? = null
}
