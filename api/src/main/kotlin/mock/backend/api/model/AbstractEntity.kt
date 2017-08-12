package mock.backend.api.model

import lombok.Data
import lombok.EqualsAndHashCode
import lombok.ToString
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Data
@MappedSuperclass
@ToString(of = arrayOf("id"))
@EqualsAndHashCode(of = arrayOf("internalId", "id"))
abstract class AbstractEntity
{
    companion object {
        const val DEFAULT_DELETED_VALUE = "0"
    }

    @Transient private var internalId: String? = null

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "mock.backend.api.util.UpperCaseUUIDGenerator")
    @Access(AccessType.PROPERTY)
    private var id: String? = null

    fun setId(id: String?) {
        this.id = id
        this.internalId = id
    }

    fun getId() : String? {
        return this.id
    }

    private val deleted = DEFAULT_DELETED_VALUE
        get() = field

    @Transient
    fun isRecordDeleted(): Boolean {
        return DEFAULT_DELETED_VALUE != deleted
    }

}