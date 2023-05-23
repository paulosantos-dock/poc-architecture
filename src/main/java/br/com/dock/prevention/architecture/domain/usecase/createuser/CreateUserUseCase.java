package br.com.dock.prevention.architecture.domain.usecase.createuser;

import br.com.dock.prevention.architecture.domain.entity.User;

public interface CreateUserUseCase {
    void create(User user);
}
