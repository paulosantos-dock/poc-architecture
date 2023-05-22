package br.com.dock.prevention.architecture.infra.dataprovider.database;

import br.com.dock.prevention.architecture.domain.entity.User;
import br.com.dock.prevention.architecture.domain.usecase.DataProviderEnum;
import br.com.dock.prevention.architecture.domain.usecase.finduser.FindUserDataProvider;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@RequiredArgsConstructor
class FindUserDataBase implements FindUserDataProvider {

    private final FindUserRepository repository;
    private final UserMapper mapper;

    @Override
    public Optional<User> findByName(final String name) {
        return repository.findByName(name)
                .map(mapper::toUser);
    }

    @Override
    public List<User> findAll() {
        return Optional.ofNullable(repository.findAll())
                .map(Collection::stream)
                .orElseGet(Stream::empty)
                .map(mapper::toUser)
                .toList();
    }

    @Override
    public boolean supports(final DataProviderEnum dataProviderEnum) {
        return dataProviderEnum == DataProviderEnum.DATABASE;
    }
}

@Mapper(componentModel = "spring")
interface UserMapper {
    User toUser(UserPO user);
}

@Repository
interface FindUserRepository extends JpaRepository<UserPO, Long> {
    Optional<UserPO> findByName(String name);
}

@Entity
@Table(schema = "user")
@Value
class UserPO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
    int age;
}