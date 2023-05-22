package br.com.dock.prevention.architecture.infra.entrypoint.rest;

import br.com.dock.prevention.architecture.domain.entity.User;
import br.com.dock.prevention.architecture.domain.usecase.finduser.FindUser;
import br.com.dock.prevention.architecture.domain.usecase.finduser.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class FindUserController {

    private final FindUser findUser;
    private final UserMapper mapper;

    @GetMapping(value = "/user/{name}")
    ResponseEntity<UserResponse> findByName(
            @PathVariable("name") final String name, @PathVariable("issuer") final String issuer) {
        try {
            User user = findUser.findByName(name, issuer);
            return ResponseEntity.ok(mapper.toUserResponse(user));
        } catch (UserNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

@Mapper(componentModel = "spring")
interface UserMapper {
    UserResponse toUserResponse(User user);
}

record UserResponse(String name) {
}
