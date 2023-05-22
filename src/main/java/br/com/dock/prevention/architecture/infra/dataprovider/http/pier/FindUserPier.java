package br.com.dock.prevention.architecture.infra.dataprovider.http.pier;

import br.com.dock.prevention.architecture.domain.entity.User;
import br.com.dock.prevention.architecture.domain.usecase.DataProviderEnum;
import br.com.dock.prevention.architecture.domain.usecase.finduser.FindUserDataProvider;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class FindUserPier implements FindUserDataProvider {

    @Override
    public Optional<User> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean supports(DataProviderEnum dataProviderEnum) {
        return dataProviderEnum == DataProviderEnum.PIER;
    }
}
