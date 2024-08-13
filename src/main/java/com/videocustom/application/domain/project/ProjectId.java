package com.videocustom.application.domain.project;
import java.util.UUID;

public record ProjectId(String value) {

        public ProjectId {
            if (value == null) {
                throw new IllegalArgumentException("Project id cannot be null");
            }
        }

        public static ProjectId generate() {
            return new ProjectId(UUID.randomUUID().toString());
        }

        public static ProjectId from(final String value) {
            try {
                return new ProjectId(UUID.fromString(value).toString());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid project id");
            }
        }

        @Override
        public String toString() {
            return value;
        }
}
