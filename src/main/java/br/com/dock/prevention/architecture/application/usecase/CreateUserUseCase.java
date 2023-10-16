package br.com.dock.prevention.architecture.application.usecase;

import br.com.dock.prevention.architecture.domain.model.User;

// In Port
public interface CreateUserUseCase {
    void create(User user);
}

class CreateUserApplicationService implements CreateUserUseCase {
    @Override
    public void create(User user) {

    }
}
