package br.com.dock.prevention.architecture.domain;

import br.com.dock.prevention.architecture.domain.model.User;

import java.util.Optional;

// Out Port
public interface FindUserOutputPort {
    Optional<User> findByName(String name);
}
