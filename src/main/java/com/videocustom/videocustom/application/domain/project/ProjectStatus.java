package com.videocustom.videocustom.application.domain.project;

public enum ProjectStatus {
    CREATED("created"),
    IN_PROGRESS("in_progress"),
    DONE("done");

    private String status;

    ProjectStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
