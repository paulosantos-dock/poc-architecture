package br.com.dock.prevention.architecture.domain.model.user;

import br.com.dock.prevention.architecture.domain.model.user.User;

import java.util.Optional;

public interface FindUserExternal {
    Optional<User> findByName(String name);
}
