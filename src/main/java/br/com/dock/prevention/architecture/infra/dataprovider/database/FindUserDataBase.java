package br.com.dock.prevention.architecture.infra.dataprovider.database;

import br.com.dock.prevention.architecture.domain.entity.User;
import br.com.dock.prevention.architecture.domain.usecase.DataProviderEnum;
import br.com.dock.prevention.architecture.domain.usecase.finduser.FindUserDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class FindUserDataBase implements FindUserDataProvider {

    private final FindUserCustom customFindUser;

    @Override
    public Optional<User> findByName(String name) {
        // TODO analisar mapper struct
         return customFindUser.findByName(name).map(UserPO::toUser);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean supports(DataProviderEnum dataProviderEnum) {
        return dataProviderEnum == DataProviderEnum.DATABASE;
    }
}


@Repository
interface FindUserCustom extends JpaRepository<UserPO, Long> {
       Optional<UserPO> findByName(String name);
}
