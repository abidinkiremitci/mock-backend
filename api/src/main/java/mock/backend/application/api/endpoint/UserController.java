package mock.backend.application.api.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import mock.backend.application.api.mapper.entity.UserMapper;
import mock.backend.application.api.mapper.resource.UserResourceMapper;
import mock.backend.application.api.resource.UserPageResource;
import mock.backend.application.api.resource.UserResource;
import mock.backend.application.service.UserService;
import mock.backend.infra.exception.InvalidRequestException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "User controller", description = "This API provides actions to create, read, update, list and delete users",
        basePath = "/api/v1/users", produces = "application/json")
@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
    @Setter
    @Resource(name = "userService")
    private UserService userService;

    @ApiOperation(value = "Create a User with the given request object", response = UserResource.class)
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<UserResource> create(@RequestBody final UserResource request) {
        return new ResponseEntity<>(new UserResourceMapper().map(userService.save(new UserMapper().map(request))), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Find a user with the given id", response = UserResource.class)
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<UserResource> findById(@PathVariable(value = "userId") final String userId) {
        return new ResponseEntity<>(new UserResourceMapper().map(userService.findUserById(userId)), HttpStatus.OK);
    }

    @ApiOperation(value = "Find a user with the given email", response = UserResource.class)
    @RequestMapping(value = "/search-with-parameter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<UserResource> findByParameter(
            @RequestParam(value = "userEmail", required = false) final String userEmail,
            @RequestParam(value = "userName", required = false) final String userName ) {
        if (StringUtils.isNotBlank(userEmail)) {
            return new ResponseEntity<>(new UserResourceMapper().map(userService.findUserByEmail(userEmail)), HttpStatus.OK);
        } else if (StringUtils.isNotBlank(userName)) {
            return new ResponseEntity<>(new UserResourceMapper().map(userService.findUserByUserName(userName)), HttpStatus.OK);
        } else {
            throw new InvalidRequestException("User search parameters cannot be empty");
        }
    }

    @ApiOperation(value = "Find a User with the given id", response = UserResource.class)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<UserResource> list(@RequestParam(value = "page", defaultValue = "0") final Integer page,
                                                     @RequestParam(value = "size", defaultValue = "10") final Integer size) {
        return new ResponseEntity(new UserPageResource(new UserResourceMapper()
                .mapToRestResponsePage(userService.findAll(new PageRequest(page, size)))), HttpStatus.OK);
    }

    @ApiOperation(value = "Update a User with the given id and request object", response = UserResource.class)
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<UserResource> update(@PathVariable(value = "userId") final String userId, @RequestBody final UserResource request) {
        return new ResponseEntity<>(new UserResourceMapper().map(userService.update(userId, new UserMapper().map(request))), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a User with the given id", response = HttpStatus.class)
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(value = "userId") final String userId) {
        userService.delete(userId);
    }

}
