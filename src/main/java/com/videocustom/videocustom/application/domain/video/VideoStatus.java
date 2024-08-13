package com.videocustom.videocustom.application.domain.video;

public enum VideoStatus {
    CREATED("created"),
    REPROVED("reproved"),
    ACCEPTED("accepted");

    private String status;

    VideoStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
