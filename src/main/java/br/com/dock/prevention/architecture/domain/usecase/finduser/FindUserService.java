package br.com.dock.prevention.architecture.domain.usecase.finduser;

import br.com.dock.prevention.architecture.domain.entity.User;
import br.com.dock.prevention.architecture.domain.usecase.DataProviderEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class FindUserService implements FindUser {

    @Autowired
    List<FindUserDataProvider> findUserDataProviders;

    @Override
    public boolean exists(String name) {
        return false;
    }

    @Override
    public User findByName(String name) {
        // TODO FORMA DE INVOCAR O DOCKONE, PODE SER BASEADO EM UMA CONFIG OU UM DADO DO PAYLOD
        Optional<User> user = Optional.of(getDataProvider(DataProviderEnum.DOCK_ONE)
                .findByName(name)
                .orElseThrow());

        // TODO FORMA DE INVOCAR O PIER, PODE SER BASEADO EM UMA CONFIG OU UM DADO DO PAYLOD
        return getDataProvider(DataProviderEnum.PIER)
                .findByName(name)
                .orElseThrow();
    }

    private FindUserDataProvider getDataProvider(DataProviderEnum dataProviderEnum){
        return findUserDataProviders.stream()
                .filter(findUserDataProvider -> findUserDataProvider.supports(dataProviderEnum))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
