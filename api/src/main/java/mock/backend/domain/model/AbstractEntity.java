package mock.backend.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
@ToString(of = {"id"})
@EqualsAndHashCode(of = {"objectId", "id"})
public class AbstractEntity
{
    public static String DEFAULT_DELETED_VALUE = "0";

    @Transient
    private String objectId;

    public AbstractEntity()
    {
        this.objectId = UUID.randomUUID().toString();
    }

    /**
     * globally unique identifier for the entity
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "mock.backend.domain.model.util.UpperCaseUUIDGenerator")
    @Access(AccessType.PROPERTY)
    private String id;

    public void setId(String id)
    {
        this.id = id;
        this.objectId = id;
    }
    private Date createTime;
    private Date updateTime;

    private String createUserIP;
    private String updateUserIP;

    /**
     * defines record deleted or not if value is zero then record is not deleted all other values denotes deleted record.
     */
    private String deleted = DEFAULT_DELETED_VALUE;

    @PrePersist
    protected void onCreate() {
        createTime = new Date();
        //TODO: get createUserIp info from request bean
    }

    @PreUpdate
    protected void onUpdate() {
        updateTime = new Date();
        //TODO: get updateUserIp info from request bean
    }

    public AbstractEntity(String objectId) {
        this.objectId = objectId;
    }
}
