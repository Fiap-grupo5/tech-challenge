package com.videocustom.domain.model;

public class CreateUserCommand {

    private String name;
    private String email;
    private String password;

    public CreateUserCommand(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
