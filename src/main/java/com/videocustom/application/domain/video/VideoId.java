package com.videocustom.application.domain.video;
import java.util.UUID;

public record VideoId(String value) {

    public static VideoId from(final String value) {
        try {
            return new VideoId(UUID.fromString(value).toString());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid category id");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
