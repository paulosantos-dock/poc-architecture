package br.com.dock.prevention.architecture.application.user;

import br.com.dock.prevention.architecture.domain.model.user.User;

public interface CreateUserUseCase {
    void create(User user);
}
