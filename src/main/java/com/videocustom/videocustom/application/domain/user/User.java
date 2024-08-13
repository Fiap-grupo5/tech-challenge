package com.videocustom.videocustom.application.domain.user;

import java.time.Instant;
import java.util.Objects;

import com.videocustom.videocustom.application.domain.base.BaseId;

import lombok.Getter;

@Getter
public class User {
    private BaseId id;
    private String name;
    private String email;
    private String password;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private User(final BaseId id, final String name, final String email, final String password,
            final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static User newUser(final String name, final String email, final String password) {
        final var id = BaseId.generate();
        final var now = Instant.now();
        return new User(id, name, email, password, now, now, null);
    }

    public static User with(final BaseId id, final String name, final String email,
            final String password, final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
        return new User(id, name, email, password, createdAt, updatedAt, deletedAt);
    }

    public User update(final String name, final String email, final String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.updatedAt = Instant.now();
        return this;
    }
}
