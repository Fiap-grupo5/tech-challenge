package com.videocustom.invite.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * UpdateInviteDTO
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-08-12T04:10:18.699258900-03:00[America/Sao_Paulo]")


public class UpdateInviteDTO   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("guestId")
  private UUID guestId = null;

  @JsonProperty("projectId")
  private UUID projectId = null;

  @JsonProperty("inviteBy")
  private UUID inviteBy = null;

  public UpdateInviteDTO id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * The guest ID
   * @return id
   **/
  @Schema(example = "123e4567-e89b-12d3-a456-426614174000", description = "The guest ID")
      @NotNull

    @Valid
    public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UpdateInviteDTO guestId(UUID guestId) {
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

  public UpdateInviteDTO projectId(UUID projectId) {
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

  public UpdateInviteDTO inviteBy(UUID inviteBy) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateInviteDTO updateInvite = (UpdateInviteDTO) o;
    return Objects.equals(this.id, updateInvite.id) &&
        Objects.equals(this.guestId, updateInvite.guestId) &&
        Objects.equals(this.projectId, updateInvite.projectId) &&
        Objects.equals(this.inviteBy, updateInvite.inviteBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, guestId, projectId, inviteBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateInviteDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    guestId: ").append(toIndentedString(guestId)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    inviteBy: ").append(toIndentedString(inviteBy)).append("\n");
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
