package br.com.dock.prevention.architecture.infra.dataprovider.http.dockone;


import br.com.dock.prevention.architecture.domain.entity.User;

// TODO poderemos utilizar o OpenFeign
interface DockOneClient {
    UserResponse getUserByName(String name);
}

class DockOneClientImpl implements DockOneClient {

    @Override
    public UserResponse getUserByName(String name) {
        return new UserResponse();
    }
}

class UserResponse {
    String name;
    int age;

    public User toUser() {
        return new User(this.name, this.age);
    }

}


