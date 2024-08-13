package com.videocustom.videocustom.infrastructure.mappers;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.videocustom.videocustom.application.domain.request.Request;
import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.usecases.request.create.RequestCreateUseCaseInput;
import com.videocustom.videocustom.application.usecases.request.create.RequestCreateUseCaseOutput;
import com.videocustom.videocustom.application.usecases.request.retrieve.get.RequestGetByIdUseCaseOutput;
import com.videocustom.videocustom.application.usecases.request.retrieve.list.RequestListUseCaseOutput;
import com.videocustom.videocustom.application.usecases.request.update.RequestUpdateUseCaseInput;
import com.videocustom.videocustom.application.usecases.request.update.RequestUpdateUseCaseOutput;
import com.videocustom.videocustom.infrastructure.persistence.entities.RequestJPAEntity;
import com.videocustom.request.model.RequestDTO;
import com.videocustom.request.model.CreateRequestDTO;
import com.videocustom.request.model.UpdateRequestDTO;

@Mapper(componentModel = "spring")
public interface RequestMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    RequestDTO toDTO(RequestGetByIdUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    RequestDTO toDTO(RequestUpdateUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(request.getId().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(request.getCreatedAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(request.getDeletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(request.getUpdatedAt()))")
    RequestDTO toDTO(Request request);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    RequestDTO toDTO(RequestCreateUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    RequestDTO toDTO(RequestListUseCaseOutput output);

    List<RequestDTO> toDTO(List<RequestListUseCaseOutput> output);

    @Mapping(target = "videoId", expression = "java(mapBaseId(dto.getVideoId()))")
    @Mapping(target = "requestBy", expression = "java(mapBaseId(dto.getRequestBy()))")
    RequestCreateUseCaseInput fromDTO(CreateRequestDTO dto);

    @Mapping(target = "id", source = "requestId")
    RequestUpdateUseCaseInput fromDTO(String requestId, UpdateRequestDTO dto);

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
}
