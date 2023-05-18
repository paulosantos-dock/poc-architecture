package br.com.dock.prevention.architecture.domain.usecase.finduser;

import br.com.dock.prevention.architecture.domain.entity.User;

import java.util.List;

public interface FindUser {
    boolean exists(String name);
    User findByName(String name);
    List<User> findAll();
}

