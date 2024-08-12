package com.videocustom.domain.model;

import java.util.UUID;

public class UpdateUserCommand {

    private UUID id;
    private String name;
    private String password;

    public UpdateUserCommand(UUID id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
