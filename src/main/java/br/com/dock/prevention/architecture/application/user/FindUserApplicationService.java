package br.com.dock.prevention.architecture.application.user;

import br.com.dock.prevention.architecture.domain.model.user.User;
import br.com.dock.prevention.architecture.domain.model.user.FindUserExternal;
import br.com.dock.prevention.architecture.domain.model.user.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class FindUserApplicationService implements FindUserUseCase {

    private final UserRepository userRepository;
    private final FindUserExternal findUserExternal;

    @Override
    public boolean exists(final String name, final String issuer) {
        return userRepository
                .exists(name);
    }

    @Override
    public User findByName(final String name, final String issuer) {
        return findUserExternal
                .findByName(name)
                .orElseThrow(() -> new UserNotFoundException("User with (" + name + ") name not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
