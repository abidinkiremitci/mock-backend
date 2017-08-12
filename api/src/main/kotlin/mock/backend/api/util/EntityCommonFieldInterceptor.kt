package mock.backend.api.util

import org.hibernate.EmptyInterceptor
import org.hibernate.type.Type
import org.slf4j.LoggerFactory
import java.io.Serializable

class EntityCommonFieldInterceptor : EmptyInterceptor() {

    override fun onSave(entity: Any?, id: Serializable?, state: Array<out Any>?, propertyNames: Array<out String>?, types: Array<out Type>?): Boolean {
        updateCommonFieldsOnInsert(entity,state,propertyNames)
        return true
    }

    override fun onFlushDirty(entity: Any?, id: Serializable?, currentState: Array<out Any>?, previousSstate: Array<out Any>?, propertyNames: Array<out String>?, types: Array<out Type>?): Boolean {
        return true
    }

    private fun updateCommonFieldsOnInsert(p_entity: Any?, p_state: Array<out Any>?, p_propertyNames: Array<out String>?) {
        /*try {
            if (p_entity is AbstractEntity) {
                val abstractEntity = p_entity
                if (abstractEntity.getCreateTime() == null) {
                    abstractEntity.setCreateTime(Date())
                    setPropertyState(p_state, p_propertyNames, "createTime", abstractEntity.getCreateTime())
                }
            }
        } catch (e: Exception) {
            log.error("Failed to set common fields.", e)
            throw RuntimeException(e)
        }*/

    }

    private fun setPropertyState(propertyStates: Array<Any>, propertyNames: Array<String>, propertyName: String, propertyState: Any) {
        for (i in propertyNames.indices) {
            if (propertyName == propertyNames[i]) {
                propertyStates[i] = propertyState
                return
            }
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(EntityCommonFieldInterceptor::class.java)
    }
}
