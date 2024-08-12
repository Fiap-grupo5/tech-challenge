package com.videocustom.invite.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * InviteDTO
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-08-12T04:10:18.699258900-03:00[America/Sao_Paulo]")


public class InviteDTO   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("guestId")
  private UUID guestId = null;

  @JsonProperty("projectId")
  private UUID projectId = null;

  @JsonProperty("inviteBy")
  private UUID inviteBy = null;

  @JsonProperty("createdAt")
  private OffsetDateTime createdAt = null;

  @JsonProperty("updatedAt")
  private OffsetDateTime updatedAt = null;

  @JsonProperty("deletedAt")
  private OffsetDateTime deletedAt = null;

  public InviteDTO id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * The invite ID
   * @return id
   **/
  @Schema(example = "123e4567-e89b-12d3-a456-426614174000", description = "The invite ID")
      @NotNull

    @Valid
    public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public InviteDTO guestId(UUID guestId) {
    this.guestId = guestId;
    return this;
  }

  /**
   * The guest ID
   * @return guestId
   **/
  @Schema(example = "123e4567-e89b-12d3-a456-426614174000", description = "The guest ID")
      @NotNull

    @Valid
    public UUID getGuestId() {
    return guestId;
  }

  public void setGuestId(UUID guestId) {
    this.guestId = guestId;
  }

  public InviteDTO projectId(UUID projectId) {
    this.projectId = projectId;
    return this;
  }

  /**
   * The project ID
   * @return projectId
   **/
  @Schema(example = "123e4567-e89b-12d3-a456-426614174000", description = "The project ID")
      @NotNull

    @Valid
    public UUID getProjectId() {
    return projectId;
  }

  public void setProjectId(UUID projectId) {
    this.projectId = projectId;
  }

  public InviteDTO inviteBy(UUID inviteBy) {
    this.inviteBy = inviteBy;
    return this;
  }

  /**
   * The user Id
   * @return inviteBy
   **/
  @Schema(example = "123e4567-e89b-12d3-a456-426614174000", description = "The user Id")
      @NotNull

    @Valid
    public UUID getInviteBy() {
    return inviteBy;
  }

  public void setInviteBy(UUID inviteBy) {
    this.inviteBy = inviteBy;
  }

  public InviteDTO createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * The date and time the invite was created
   * @return createdAt
   **/
  @Schema(example = "2021-06-01T10:00Z", description = "The date and time the invite was created")
      @NotNull

    @Valid
    public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public InviteDTO updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * The date and time the invite was updated
   * @return updatedAt
   **/
  @Schema(example = "2021-06-01T10:00Z", description = "The date and time the invite was updated")
      @NotNull

    @Valid
    public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public InviteDTO deletedAt(OffsetDateTime deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  /**
   * The date and time the invite was deleted
   * @return deletedAt
   **/
  @Schema(example = "2021-06-01T10:00Z", description = "The date and time the invite was deleted")
      @NotNull

    @Valid
    public OffsetDateTime getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(OffsetDateTime deletedAt) {
    this.deletedAt = deletedAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InviteDTO invite = (InviteDTO) o;
    return Objects.equals(this.id, invite.id) &&
        Objects.equals(this.guestId, invite.guestId) &&
        Objects.equals(this.projectId, invite.projectId) &&
        Objects.equals(this.inviteBy, invite.inviteBy) &&
        Objects.equals(this.createdAt, invite.createdAt) &&
        Objects.equals(this.updatedAt, invite.updatedAt) &&
        Objects.equals(this.deletedAt, invite.deletedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, guestId, projectId, inviteBy, createdAt, updatedAt, deletedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InviteDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    guestId: ").append(toIndentedString(guestId)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    inviteBy: ").append(toIndentedString(inviteBy)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    deletedAt: ").append(toIndentedString(deletedAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
