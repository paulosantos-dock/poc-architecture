package br.com.dock.prevention.architecture.domain.model.user;

public record User(String name, int age) {
    public boolean validateName() {
        return this.name.length() > 5;
    }
}
