package com.videocustom.videocustom.infrastructure.mappers;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.videocustom.videocustom.application.domain.project.Project;
import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.usecases.project.create.ProjectCreateUseCaseInput;
import com.videocustom.videocustom.application.usecases.project.create.ProjectCreateUseCaseOutput;
import com.videocustom.videocustom.application.usecases.project.retrieve.get.ProjectGetByIdUseCaseOutput;
import com.videocustom.videocustom.application.usecases.project.retrieve.list.ProjectListUseCaseOutput;
import com.videocustom.videocustom.application.usecases.project.update.ProjectUpdateUseCaseInput;
import com.videocustom.videocustom.application.usecases.project.update.ProjectUpdateUseCaseOutput;
import com.videocustom.videocustom.infrastructure.persistence.entities.ProjectJPAEntity;
import com.videocustom.videocustom.application.domain.project.ProjectStatus;
import com.videocustom.project.model.ProjectDTO;
import com.videocustom.project.model.CreateProjectDTO;
import com.videocustom.project.model.UpdateProjectDTO;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    ProjectDTO toDTO(ProjectGetByIdUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    ProjectDTO toDTO(ProjectUpdateUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(project.getId().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(project.getCreatedAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(project.getDeletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(project.getUpdatedAt()))")
    ProjectDTO toDTO(Project project);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    ProjectDTO toDTO(ProjectCreateUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    ProjectDTO toDTO(ProjectListUseCaseOutput output);

    List<ProjectDTO> toDTO(List<ProjectListUseCaseOutput> output);

    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "description", source = "dto.description")
    @Mapping(target = "createdBy", expression = "java(mapBaseId(dto.getCreatedBy()))")
    ProjectCreateUseCaseInput fromDTO(CreateProjectDTO dto);

    @Mapping(target = "id", source = "projectId")
    ProjectUpdateUseCaseInput fromDTO(String projectId, UpdateProjectDTO dto);

    default OffsetDateTime mapOffsetDateTime(Instant instant) {
        if (instant == null) {
            return null;
        }
        return OffsetDateTime.ofInstant(instant, java.time.ZoneOffset.UTC);
    }

    default String map(BaseId value) {
        return value.toString();
    }

    default BaseId mapBaseId(UUID uuid) {
        return BaseId.from(uuid.toString());
    }

    default ProjectStatus mapStatus(String status) {
        return ProjectStatus.valueOf(status.toUpperCase());
    }
}
