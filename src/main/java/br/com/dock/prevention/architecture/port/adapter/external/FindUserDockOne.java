package br.com.dock.prevention.architecture.port.adapter.external;

import br.com.dock.prevention.architecture.domain.model.user.User;
import br.com.dock.prevention.architecture.domain.model.user.FindUserExternal;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class FindUserDockOne implements FindUserExternal {

    private final DockOneClient dockOneClient;
    private final UserMapper mapper;

    @Override
    public Optional<User> findByName(String name) {
        return Optional.ofNullable(dockOneClient.getUserByName(name))
                .map(mapper::toUser);
    }
}

@FeignClient(value = "dockone", url = "${app.dockone.api.url}")
interface DockOneClient {
    UserResponse getUserByName(String name);
}

@Mapper(componentModel = "spring")
interface UserMapper {
    User toUser(UserResponse user);
}

class UserResponse {
    String name;
    int age;
}