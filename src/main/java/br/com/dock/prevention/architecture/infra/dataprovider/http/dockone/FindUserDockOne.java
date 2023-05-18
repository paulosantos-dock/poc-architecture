package br.com.dock.prevention.architecture.infra.dataprovider.http.dockone;

import br.com.dock.prevention.architecture.domain.entity.User;
import br.com.dock.prevention.architecture.domain.usecase.DataProviderEnum;
import br.com.dock.prevention.architecture.domain.usecase.finduser.FindUserDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class FindUserDockOne implements FindUserDataProvider {

    DockOneClient dockOneClient;

    @Override
    public Optional<User> findByName(String name) {
        return Optional.of(dockOneClient.getUserByName(name).toUser());
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean supports(DataProviderEnum dataProviderEnum) {
        return dataProviderEnum == DataProviderEnum.DOCK_ONE;
    }
}
