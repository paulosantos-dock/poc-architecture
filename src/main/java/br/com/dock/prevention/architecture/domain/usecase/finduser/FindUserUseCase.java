package br.com.dock.prevention.architecture.domain.usecase.finduser;

import br.com.dock.prevention.architecture.domain.entity.User;
import java.util.List;

public interface FindUserUseCase {
    boolean exists(String name, String issuer);

    User findByName(String name, String issuer);

    List<User> findAll();
}
