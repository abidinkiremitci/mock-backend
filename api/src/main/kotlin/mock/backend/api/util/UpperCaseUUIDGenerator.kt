package mock.backend.api.util

import mock.backend.api.model.AbstractEntity
import org.apache.commons.lang.StringUtils
import org.hibernate.HibernateException
import org.hibernate.engine.spi.SessionImplementor
import org.hibernate.id.UUIDGenerator
import java.io.Serializable

internal class UpperCaseUUIDGenerator : UUIDGenerator()
{
    @Throws(HibernateException::class)
    override fun generate(session: SessionImplementor, `object`: Any?): Serializable {
        if (`object` is AbstractEntity)
        {
            val abstractEntity = `object` as AbstractEntity?
            if (abstractEntity != null)
            {
                return abstractEntity.getId()!!
            }
        }
        val generated = super.generate(session, `object`)
        return StringUtils.upperCase(generated as String)
    }
}