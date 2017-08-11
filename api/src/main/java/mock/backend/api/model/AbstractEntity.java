package mock.backend.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Version;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.Date;
import java.util.UUID;

/**
 * Created by semihunaldi on 09.09.2016.
 */

@Data
@MappedSuperclass
@ToString(of = {"id"})
@EqualsAndHashCode(of = {"internalId", "id"})
public class AbstractEntity
{
    public static String DEFAULT_DELETED_VALUE = "0";

    @Transient
    private String internalId;

    public AbstractEntity()
    {
        this.internalId = UUID.randomUUID().toString();
    }

    /**
     * globally unique identifier for the entity
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "mock.backend.api.util.UpperCaseUUIDGenerator")
    @Access(AccessType.PROPERTY)
    private String id;

    public void setId(String id)
    {
        this.id = id;
        this.internalId = id;
    }
    private Date createTime;
    private String createUserIP;
    private Date updateTime;
    private String updateUserIP;

    /**
     * defines record deleted or not if value is zero then record is not deleted all other values denotes deleted record.
     */
    private String deleted = DEFAULT_DELETED_VALUE;

    @Transient
    public boolean isRecordDeleted()
    {
        return !DEFAULT_DELETED_VALUE.equals(getDeleted());
    }

}
