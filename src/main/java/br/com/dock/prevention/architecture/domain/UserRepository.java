package br.com.dock.prevention.architecture.domain;

import br.com.dock.prevention.architecture.domain.model.User;

import java.util.List;

// Out Port
public interface UserRepository {
    List<User> findAll();

    boolean exists(String name);
}
