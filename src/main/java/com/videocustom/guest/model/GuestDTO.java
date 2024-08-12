package com.videocustom.guest.model;

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
 * GuestDTO
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-08-12T04:10:18.235256800-03:00[America/Sao_Paulo]")


public class GuestDTO   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("createdAt")
  private OffsetDateTime createdAt = null;

  @JsonProperty("updatedAt")
  private OffsetDateTime updatedAt = null;

  @JsonProperty("deletedAt")
  private OffsetDateTime deletedAt = null;

  public GuestDTO id(UUID id) {
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

  public GuestDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The guest name
   * @return name
   **/
  @Schema(example = "John Doe", description = "The guest name")
      @NotNull

  @Size(max=255)   public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GuestDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The guest email
   * @return email
   **/
  @Schema(example = "guest@email.com", description = "The guest email")
      @NotNull

    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public GuestDTO createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * The date and time the guest was created
   * @return createdAt
   **/
  @Schema(example = "2021-06-01T10:00Z", description = "The date and time the guest was created")
      @NotNull

    @Valid
    public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public GuestDTO updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * The date and time the guest was updated
   * @return updatedAt
   **/
  @Schema(example = "2021-06-01T10:00Z", description = "The date and time the guest was updated")
      @NotNull

    @Valid
    public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public GuestDTO deletedAt(OffsetDateTime deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  /**
   * The date and time the guest was deleted
   * @return deletedAt
   **/
  @Schema(example = "2021-06-01T10:00Z", description = "The date and time the guest was deleted")
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
    GuestDTO guest = (GuestDTO) o;
    return Objects.equals(this.id, guest.id) &&
        Objects.equals(this.name, guest.name) &&
        Objects.equals(this.email, guest.email) &&
        Objects.equals(this.createdAt, guest.createdAt) &&
        Objects.equals(this.updatedAt, guest.updatedAt) &&
        Objects.equals(this.deletedAt, guest.deletedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, createdAt, updatedAt, deletedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GuestDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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
