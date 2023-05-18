package br.com.dock.prevention.architecture.domain.entity;

public record User(String name, int age) {
    public boolean validateName() {
        return this.name.length() > 5;
    }
}
