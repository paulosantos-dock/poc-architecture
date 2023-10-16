package br.com.dock.prevention.architecture.application.usecase;

import br.com.dock.prevention.architecture.application.exception.UserNotFoundException;
import br.com.dock.prevention.architecture.domain.FindUserOutputPort;
import br.com.dock.prevention.architecture.domain.model.User;
import br.com.dock.prevention.architecture.domain.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

// In Port
public interface FindUserUseCase {
    boolean exists(String name, String issuer);

    User findByName(String name, String issuer);

    List<User> findAll();
}

@RequiredArgsConstructor
class FindUserApplicationService implements FindUserUseCase {

    private final UserRepository userRepository;
    private final FindUserOutputPort findUser;

    @Override
    public boolean exists(final String name, final String issuer) {
        return userRepository
                .exists(name);
    }

    @Override
    public User findByName(final String name, final String issuer) {
        return findUser
                .findByName(name)
                .orElseThrow(() -> new UserNotFoundException("User with (" + name + ") name not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}