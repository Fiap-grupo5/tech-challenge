package com.videocustom.infrastructure.api.generated.user;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * UpdateUserDTO
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-08-12T04:10:16.831255200-03:00[America/Sao_Paulo]")


public class UpdateUserDTO   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("password")
  private String password = null;

  public UpdateUserDTO id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * The user ID
   * @return id
   **/
  @Schema(example = "123e4567-e89b-12d3-a456-426614174000", description = "The user ID")
      @NotNull

    @Valid
    public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UpdateUserDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The user name
   * @return name
   **/
  @Schema(example = "John Doe", description = "The user name")
      @NotNull

  @Size(max=255)   public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UpdateUserDTO password(String password) {
    this.password = password;
    return this;
  }

  /**
   * The user password
   * @return password
   **/
  @Schema(example = "password", description = "The user password")
      @NotNull

    public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateUserDTO updateUser = (UpdateUserDTO) o;
    return Objects.equals(this.id, updateUser.id) &&
        Objects.equals(this.name, updateUser.name) &&
        Objects.equals(this.password, updateUser.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateUserDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
