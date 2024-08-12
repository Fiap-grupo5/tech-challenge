package com.videocustom.infrastructure.api.generated.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * LoginDTO
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-08-12T04:10:17.883258200-03:00[America/Sao_Paulo]")


public class LoginDTO   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("isGuest")
  private Boolean isGuest = null;

  @JsonProperty("createdAt")
  private OffsetDateTime createdAt = null;

  @JsonProperty("updatedAt")
  private OffsetDateTime updatedAt = null;

  @JsonProperty("deletedAt")
  private OffsetDateTime deletedAt = null;

  public LoginDTO id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * The user or guest ID
   * @return id
   **/
  @Schema(example = "123e4567-e89b-12d3-a456-426614174000", description = "The user or guest ID")
      @NotNull

    @Valid
    public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public LoginDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The user or guest name
   * @return name
   **/
  @Schema(example = "John Doe", description = "The user or guest name")
      @NotNull

  @Size(max=255)   public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LoginDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The user or guest email
   * @return email
   **/
  @Schema(example = "user@email.com", description = "The user or guest email")
      @NotNull

    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LoginDTO isGuest(Boolean isGuest) {
    this.isGuest = isGuest;
    return this;
  }

  /**
   * Indicates if the user is a guest
   * @return isGuest
   **/
  @Schema(example = "false", description = "Indicates if the user is a guest")
      @NotNull

    public Boolean isIsGuest() {
    return isGuest;
  }

  public void setIsGuest(Boolean isGuest) {
    this.isGuest = isGuest;
  }

  public LoginDTO createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * The date and time the user or guest was created
   * @return createdAt
   **/
  @Schema(example = "2021-06-01T10:00Z", description = "The date and time the user or guest was created")
      @NotNull

    @Valid
    public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LoginDTO updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * The date and time the user or guest was updated
   * @return updatedAt
   **/
  @Schema(example = "2021-06-01T10:00Z", description = "The date and time the user or guest was updated")
      @NotNull

    @Valid
    public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public LoginDTO deletedAt(OffsetDateTime deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  /**
   * The date and time the user or guest was deleted
   * @return deletedAt
   **/
  @Schema(example = "2021-06-01T10:00Z", description = "The date and time the user or guest was deleted")
      @NotNull

    @Valid
    public OffsetDateTime getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(OffsetDateTime deletedAt) {
    this.deletedAt = deletedAt;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginDTO login = (LoginDTO) o;
    return Objects.equals(this.id, login.id) &&
        Objects.equals(this.name, login.name) &&
        Objects.equals(this.email, login.email) &&
        Objects.equals(this.isGuest, login.isGuest) &&
        Objects.equals(this.createdAt, login.createdAt) &&
        Objects.equals(this.updatedAt, login.updatedAt) &&
        Objects.equals(this.deletedAt, login.deletedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, isGuest, createdAt, updatedAt, deletedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    isGuest: ").append(toIndentedString(isGuest)).append("\n");
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
