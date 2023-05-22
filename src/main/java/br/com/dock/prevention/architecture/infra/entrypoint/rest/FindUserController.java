package br.com.dock.prevention.architecture.infra.entrypoint.rest;

import br.com.dock.prevention.architecture.domain.entity.User;
import br.com.dock.prevention.architecture.domain.usecase.createuser.CreateUserUseCase;
import br.com.dock.prevention.architecture.domain.usecase.finduser.FindUserUseCase;
import br.com.dock.prevention.architecture.domain.usecase.finduser.UserNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
class FindUserController {

    private final CreateUserUseCase createUserUseCase;
    private final FindUserUseCase findUserUseCase;
    private final UserMapper mapper;

    @PostMapping(value = "/users")
    ResponseEntity<Void> create(@RequestBody final UserRequest userRequest) {
        boolean exists = findUserUseCase.exists(userRequest.getName(), userRequest.getIssuer());
        if (exists) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        createUserUseCase.create(mapper.toUser(userRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/users/{name}")
    ResponseEntity<UserResponse> findByName(
            @PathVariable("name") final String name, @PathVariable("issuer") final String issuer) {
        try {
            User user = findUserUseCase.findByName(name, issuer);
            return ResponseEntity.ok(mapper.toUserResponse(user));
        } catch (UserNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

@Mapper(componentModel = "spring")
interface UserMapper {
    UserResponse toUserResponse(User user);
    User toUser(UserRequest user);
}

record UserResponse(String name) {
}

@Getter
record UserRequest(String name, String issuer) {
}
