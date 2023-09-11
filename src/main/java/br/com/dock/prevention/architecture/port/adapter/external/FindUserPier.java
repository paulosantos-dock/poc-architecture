package br.com.dock.prevention.architecture.port.adapter.external;

import br.com.dock.prevention.architecture.domain.model.user.User;
import br.com.dock.prevention.architecture.domain.model.user.FindUserExternal;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindUserPier implements FindUserExternal {

    @Override
    public Optional<User> findByName(String name) {
        return Optional.empty();
    }

}
