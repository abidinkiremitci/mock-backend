package mock.backend.api.util;

import mock.backend.api.model.AbstractEntity;
import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.UUIDGenerator;

import java.io.Serializable;

/**
 * Created by semihunaldi on 27.10.2015.
 */
public class UpperCaseUUIDGenerator extends UUIDGenerator
{
    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException
    {
        if (object instanceof AbstractEntity) {
            AbstractEntity abstractEntity = (AbstractEntity)object;
            if (abstractEntity.getId() != null) {
                return abstractEntity.getId();
            }
        }
        Serializable generated = super.generate(session, object);
        return StringUtils.upperCase((String) generated);
    }
}

