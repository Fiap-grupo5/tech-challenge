package com.videocustom.application.domain.project;
import java.util.UUID;

public record ProjectId(String value) {

    public static ProjectId from(final String value) {
        try {
            return new ProjectId(UUID.fromString(value).toString());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid category id");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}