package com.videocustom.videocustom.infrastructure.mappers;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.videocustom.videocustom.application.domain.video.Video;
import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.usecases.video.create.VideoCreateUseCaseInput;
import com.videocustom.videocustom.application.usecases.video.create.VideoCreateUseCaseOutput;
import com.videocustom.videocustom.application.usecases.video.retrieve.get.VideoGetByIdUseCaseOutput;
import com.videocustom.videocustom.application.usecases.video.retrieve.list.VideoListUseCaseOutput;
import com.videocustom.videocustom.application.usecases.video.update.VideoUpdateUseCaseInput;
import com.videocustom.videocustom.application.usecases.video.update.VideoUpdateUseCaseOutput;
import com.videocustom.videocustom.infrastructure.persistence.entities.VideoJPAEntity;
import com.videocustom.videocustom.application.domain.video.VideoStatus;
import com.videocustom.video.model.VideoDTO;
import com.videocustom.video.model.CreateVideoDTO;
import com.videocustom.video.model.UpdateVideoDTO;

@Mapper(componentModel = "spring")
public interface VideoMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    VideoDTO toDTO(VideoGetByIdUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    VideoDTO toDTO(VideoUpdateUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(video.getId().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(video.getCreatedAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(video.getDeletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(video.getUpdatedAt()))")
    VideoDTO toDTO(Video video);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    VideoDTO toDTO(VideoCreateUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    VideoDTO toDTO(VideoListUseCaseOutput output);

    List<VideoDTO> toDTO(List<VideoListUseCaseOutput> output);

    @Mapping(target = "createdBy", expression = "java(mapBaseId(dto.getCreatedBy()))")
    @Mapping(target = "projectId", expression = "java(mapBaseId(dto.getProjectId()))")
    VideoCreateUseCaseInput fromDTO(CreateVideoDTO dto);

    @Mapping(target = "id", source = "videoId")
    VideoUpdateUseCaseInput fromDTO(String videoId, UpdateVideoDTO dto);

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

    default VideoStatus mapStatus(String status) {
        return VideoStatus.valueOf(status.toUpperCase());
    }
}
