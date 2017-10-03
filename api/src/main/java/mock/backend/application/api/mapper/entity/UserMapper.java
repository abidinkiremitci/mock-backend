package mock.backend.application.api.mapper.entity;

import mock.backend.application.api.resource.UserResource;
import mock.backend.domain.model.User;
import mock.backend.infra.mapper.Mapper;

/**
 * Created by AbidinK on 3.10.2017.
 */
public class UserMapper implements Mapper<UserResource, User> {
    @Override
    public User map(UserResource resource) {
        return User.builder()
                .objectId(resource.getId())
                .firstName(resource.getFirstName())
                .lastName(resource.getLastName())
                .userName(resource.getUserName())
                .email(resource.getEmail())
                .mobilePhone(resource.getMobilePhone())
                .age(resource.getAge())
                .location(resource.getLocation())
                .timeZone(resource.getTimeZone())
                .build();
    }
}
