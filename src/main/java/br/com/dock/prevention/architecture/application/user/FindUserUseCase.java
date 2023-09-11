package br.com.dock.prevention.architecture.application.user;

import br.com.dock.prevention.architecture.domain.model.user.User;
import java.util.List;

public interface FindUserUseCase {
    boolean exists(String name, String issuer);

    User findByName(String name, String issuer);

    List<User> findAll();
}
