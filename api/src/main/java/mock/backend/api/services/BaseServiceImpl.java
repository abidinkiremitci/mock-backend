package mock.backend.api.services;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import mock.backend.api.config.AppProperties;
import mock.backend.api.model.AbstractEntity;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by semihunaldi on 09.09.2016.
 */

@Transactional(readOnly = true)
public class BaseServiceImpl
{
    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected AppProperties appProperties;

    protected void adjustEntityForDeletion(AbstractEntity entity)
    {
        checkNotNull(entity, "entity can not be null");
        checkArgument(StringUtils.isNotBlank(entity.getId()), "The record you want to delete must already be saved.");
        entity.setDeleted(UUID.randomUUID().toString());
    }

    public <T> Set<ConstraintViolation<T>> executeValidations(T bean)
    {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        return validator.validate(bean);
    }

    public <T> void executeValidationsAndThrow(T bean)
    {
        Set<ConstraintViolation<T>> constraintViolations = executeValidations(bean);
        List<String> exceptionMessages = Lists.newArrayList();
        for(ConstraintViolation constraintViolation : constraintViolations)
        {
            exceptionMessages.add(constraintViolation.getMessage());
        }
        String message = Joiner.on(", ").skipNulls().join(exceptionMessages);
        if (StringUtils.isNotBlank(message))
        {
            throw new ValidationException(message);
        }
    }
}
