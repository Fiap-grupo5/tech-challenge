package com.videocustom.videocustom.infrastructure.mappers;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.videocustom.guest.model.GuestDTO;
import com.videocustom.guest.model.CreateGuestDTO;
import com.videocustom.guest.model.UpdateGuestDTO;
import com.videocustom.videocustom.application.domain.guest.Guest;
import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.usecases.guest.create.GuestCreateUseCaseInput;
import com.videocustom.videocustom.application.usecases.guest.create.GuestCreateUseCaseOutput;
import com.videocustom.videocustom.application.usecases.guest.retrieve.get.GuestGetByIdUseCaseOutput;
import com.videocustom.videocustom.application.usecases.guest.retrieve.list.GuestListUseCaseOutput;
import com.videocustom.videocustom.application.usecases.guest.update.GuestUpdateUseCaseInput;
import com.videocustom.videocustom.application.usecases.guest.update.GuestUpdateUseCaseOutput;

@Mapper(componentModel = "spring")
public interface GuestMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    GuestDTO toDTO(GuestGetByIdUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    GuestDTO toDTO(GuestUpdateUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(guest.getId().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(guest.getCreatedAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(guest.getDeletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(guest.getUpdatedAt()))")
    GuestDTO toDTO(Guest guest);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    GuestDTO toDTO(GuestCreateUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    GuestDTO toDTO(GuestListUseCaseOutput output);

    List<GuestDTO> toDTO(List<GuestListUseCaseOutput> output);

    GuestCreateUseCaseInput fromDTO(CreateGuestDTO dto);

    @Mapping(target = "id", source = "userId")
    GuestUpdateUseCaseInput fromDTO(String userId, UpdateGuestDTO dto);

    default OffsetDateTime mapOffsetDateTime(Instant instant) {
        if (instant == null) {
            return null;
        }
        return OffsetDateTime.ofInstant(instant, java.time.ZoneOffset.UTC);
    }

    default String map(BaseId value) {
        return value.toString();
    }

}
