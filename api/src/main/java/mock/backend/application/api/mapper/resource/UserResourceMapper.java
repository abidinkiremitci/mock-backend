package mock.backend.application.api.mapper.resource;

import mock.backend.domain.model.User;
import mock.backend.application.api.resource.UserResource;
import mock.backend.infra.mapper.Mapper;

public class UserResourceMapper implements Mapper<User, UserResource> {
    @Override
    public UserResource map(User entity) {
        return UserResource.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .userName(entity.getUserName())
                .email(entity.getEmail())
                .mobilePhone(entity.getMobilePhone())
                .age(entity.getAge())
                .location(entity.getLocation())
                .timeZone(entity.getTimeZone())
                .createTime(entity.getCreateTime())
                .updateTime(entity.getUpdateTime())
                .build();
    }
}
