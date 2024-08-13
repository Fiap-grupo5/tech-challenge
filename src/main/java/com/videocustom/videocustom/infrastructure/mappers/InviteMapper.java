package com.videocustom.videocustom.infrastructure.mappers;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.videocustom.videocustom.application.domain.invite.Invite;
import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.usecases.invite.create.InviteCreateUseCaseInput;
import com.videocustom.videocustom.application.usecases.invite.create.InviteCreateUseCaseOutput;
import com.videocustom.videocustom.application.usecases.invite.retrieve.get.InviteGetByIdUseCaseOutput;
import com.videocustom.videocustom.application.usecases.invite.retrieve.list.InviteListUseCaseOutput;
import com.videocustom.videocustom.application.usecases.invite.update.InviteUpdateUseCaseInput;
import com.videocustom.videocustom.application.usecases.invite.update.InviteUpdateUseCaseOutput;
import com.videocustom.videocustom.infrastructure.persistence.entities.InviteJPAEntity;
import com.videocustom.invite.model.InviteDTO;
import com.videocustom.invite.model.CreateInviteDTO;
import com.videocustom.invite.model.UpdateInviteDTO;

@Mapper(componentModel = "spring")
public interface InviteMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    InviteDTO toDTO(InviteGetByIdUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    InviteDTO toDTO(InviteUpdateUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(invite.getId().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(invite.getCreatedAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(invite.getDeletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(invite.getUpdatedAt()))")
    InviteDTO toDTO(Invite invite);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    InviteDTO toDTO(InviteCreateUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    InviteDTO toDTO(InviteListUseCaseOutput output);

    List<InviteDTO> toDTO(List<InviteListUseCaseOutput> output);

    @Mapping(target = "guestId", expression = "java(mapBaseId(dto.getGuestId()))")
    @Mapping(target = "projectId", expression = "java(mapBaseId(dto.getProjectId()))")
    @Mapping(target = "inviteBy", expression = "java(mapBaseId(dto.getInviteBy()))")
    InviteCreateUseCaseInput fromDTO(CreateInviteDTO dto);

    @Mapping(target = "id", source = "inviteId")
    InviteUpdateUseCaseInput fromDTO(String inviteId, UpdateInviteDTO dto);

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
