package br.com.dock.prevention.architecture.infra.dataprovider.http.dockone;

import br.com.dock.prevention.architecture.domain.entity.User;
import br.com.dock.prevention.architecture.domain.usecase.DataProviderEnum;
import br.com.dock.prevention.architecture.domain.usecase.finduser.FindUserDataProvider;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class FindUserDockOne implements FindUserDataProvider {

    private final DockOneClient dockOneClient;
    private final UserMapper mapper;

    @Override
    public Optional<User> findByName(String name) {
        return Optional.ofNullable(dockOneClient.getUserByName(name))
                .map(mapper::toUser);
    }

    @Override
    public List<User> findAll() {
        return Optional.ofNullable(dockOneClient.findAll())
                .map(Collection::stream)
                .orElseGet(Stream::empty)
                .map(mapper::toUser)
                .toList();
    }

    @Override
    public boolean supports(DataProviderEnum dataProviderEnum) {
        return dataProviderEnum == DataProviderEnum.DOCK_ONE;
    }
}

@FeignClient(value = "dockone", url = "${app.dockone.api.url}")
interface DockOneClient {
    UserResponse getUserByName(String name);

    List<UserResponse> findAll();
}

@Mapper(componentModel = "spring")
interface UserMapper {
    User toUser(UserResponse user);
}

class UserResponse {
    String name;
    int age;
}