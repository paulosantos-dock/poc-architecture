package br.com.dock.prevention.architecture.domain.usecase.finduser;

import br.com.dock.prevention.architecture.domain.entity.User;
import br.com.dock.prevention.architecture.domain.usecase.DataProviderEnum;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class FindUserService implements FindUserUseCase {

    private final List<FindUserDataProvider> findUserDataProviders;

    @Override
    public boolean exists(final String name, final String issuer) {
        return getDataProvider(DataProviderEnum.fromValue(issuer))
                .findByName(name)
                .isPresent();
    }

    @Override
    public User findByName(final String name, final String issuer) {
        return getDataProvider(DataProviderEnum.fromValue(issuer))
                .findByName(name)
                .orElseThrow(() -> new UserNotFoundException("User with (" + name + ") name not found"));
    }

    @Override
    public List<User> findAll() {
        return getDataProvider(DataProviderEnum.PIER).findAll();
    }

    private FindUserDataProvider getDataProvider(final DataProviderEnum dataProviderEnum) {
        return findUserDataProviders.stream()
                .filter(findUserDataProvider -> findUserDataProvider.supports(dataProviderEnum))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Enum invalid"));
    }
}
