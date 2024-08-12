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
 * CreateInviteDTO
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-08-12T04:10:18.699258900-03:00[America/Sao_Paulo]")


public class CreateInviteDTO   {
  @JsonProperty("guestId")
  private UUID guestId = null;

  @JsonProperty("projectId")
  private UUID projectId = null;

  @JsonProperty("inviteBy")
  private UUID inviteBy = null;

  public CreateInviteDTO guestId(UUID guestId) {
    this.guestId = guestId;
    return this;
  }

  /**
   * The guest ID
   * @return guestId
   **/
  @Schema(example = "123e4567-e89b-12d3-a456-426614174000", required = true, description = "The guest ID")
      @NotNull

    @Valid
    public UUID getGuestId() {
    return guestId;
  }

  public void setGuestId(UUID guestId) {
    this.guestId = guestId;
  }

  public CreateInviteDTO projectId(UUID projectId) {
    this.projectId = projectId;
    return this;
  }

  /**
   * The project ID
   * @return projectId
   **/
  @Schema(example = "123e4567-e89b-12d3-a456-426614174000", required = true, description = "The project ID")
      @NotNull

    @Valid
    public UUID getProjectId() {
    return projectId;
  }

  public void setProjectId(UUID projectId) {
    this.projectId = projectId;
  }

  public CreateInviteDTO inviteBy(UUID inviteBy) {
    this.inviteBy = inviteBy;
    return this;
  }

  /**
   * The user Id
   * @return inviteBy
   **/
  @Schema(example = "123e4567-e89b-12d3-a456-426614174000", required = true, description = "The user Id")
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
    CreateInviteDTO createInvite = (CreateInviteDTO) o;
    return Objects.equals(this.guestId, createInvite.guestId) &&
        Objects.equals(this.projectId, createInvite.projectId) &&
        Objects.equals(this.inviteBy, createInvite.inviteBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(guestId, projectId, inviteBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateInviteDTO {\n");
    
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
