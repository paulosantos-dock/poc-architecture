package br.com.dock.prevention.architecture.domain.usecase.finduser;

import br.com.dock.prevention.architecture.domain.entity.User;
import br.com.dock.prevention.architecture.domain.usecase.DataProviderEnum;
import java.util.List;
import java.util.Optional;

public interface FindUserDataProvider {
    Optional<User> findByName(String name);

    List<User> findAll();

    boolean supports(DataProviderEnum dataProviderEnum);
}
