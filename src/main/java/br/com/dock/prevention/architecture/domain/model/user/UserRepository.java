package br.com.dock.prevention.architecture.domain.model.user;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    boolean exists(String name);
}
