package br.com.dock.prevention.architecture.infrastracture.persistence;

import br.com.dock.prevention.architecture.domain.model.User;
import br.com.dock.prevention.architecture.domain.UserRepository;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
// DB Access Service
class JpaUserRepository implements UserRepository {

    private final SpringDataUserRepository repository;
    private final UserMapper mapper;

    @Override
    public boolean exists(String name) {
        return this.findByName(name).isPresent();
    }

    @Override
    public List<User> findAll() {
        return Optional.ofNullable(repository.findAll())
                .map(Collection::stream)
                .orElseGet(Stream::empty)
                .map(mapper::toUser)
                .toList();
    }

    public Optional<User> findByName(final String name) {
        return repository.findByName(name)
                .map(mapper::toUser);
    }
}

@Mapper(componentModel = "spring")
interface UserMapper {
    User toUser(UserPO user);
}

@Repository
interface SpringDataUserRepository extends JpaRepository<UserPO, Long> {
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