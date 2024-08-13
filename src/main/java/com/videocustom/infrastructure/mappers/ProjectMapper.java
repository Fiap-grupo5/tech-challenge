package com.videocustom.infrastructure.mappers;

import com.videocustom.application.domain.project.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(project.getId().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(project.getCreatedAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(project.getDeletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(project.getUpdatedAt()))")
   // ProjectDTO toDTO(Project project);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
  //  ProjectDTO toDTO(CategoryCreateUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
   // ProjectDTO toDTO(ProjectListUseCaseOutput output);

   // List<ProjectDTO> toDTO(List<ProjectListUseCaseOutput> output);

    @Mapping(target = "active", source = "isActive")
    //ProjectDTO toDTO(ProjectGetByIdUseCaseOutput output);

    @Mapping(target = "active", source = "isActive")
   // ProjectDTO toDTO(ProjectUpdateUseCaseOutput output);

   // ProjectCreateUseCaseInput fromDTO(CreateCategoryDTO dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "isActive", source = "dto.active")
    //ProjectUpdateUseCaseInput fromDTO(String categoryId, UpdateProjectDTO dto);

    default OffsetDateTime mapOffsetDateTime(Instant instant) {
        if (instant == null) {
            return null;
        }
        return OffsetDateTime.ofInstant(instant, java.time.ZoneOffset.UTC);
    }

    //default String map(id value) {
        //return value.toString();
    //}


}
