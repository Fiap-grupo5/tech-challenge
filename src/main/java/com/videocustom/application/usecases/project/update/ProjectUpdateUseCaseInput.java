package com.videocustom.application.usecases.project.update;

public record ProjectUpdateUseCaseInput(String id, String name, String description, String status, boolean isActive) {

}
