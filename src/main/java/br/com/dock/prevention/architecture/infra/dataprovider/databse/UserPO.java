package br.com.dock.prevention.architecture.infra.dataprovider.databse;

import br.com.dock.prevention.architecture.domain.entity.User;
import jakarta.persistence.*;
import lombok.Value;

@Entity
@Table(schema = "user")
@Value
// TODO ANALISAR REGRA PARA DEIXAR ESSE PACOTE VISIVEL SOMENTE PARA O ADAPTER
public class UserPO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String name;
    int age;

    public User toUser() {
        return new User(this.name, this.age);
    }
}
