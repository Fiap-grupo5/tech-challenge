package com.videocustom.infrastructure.api.generated.user;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.*;

/**
 * CreateUserDTO
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-08-12T04:10:16.831255200-03:00[America/Sao_Paulo]")


public class CreateUserDTO   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("password")
  private String password = null;

  public CreateUserDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The user name
   * @return name
   **/
  @Schema(example = "John Doe", required = true, description = "The user name")
      @NotNull

  @Size(max=255)   public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateUserDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The user email
   * @return email
   **/
  @Schema(example = "user@email.com", required = true, description = "The user email")
      @NotNull

    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CreateUserDTO password(String password) {
    this.password = password;
    return this;
  }

  /**
   * The user password
   * @return password
   **/
  @Schema(example = "password", required = true, description = "The user password")
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
    CreateUserDTO createUser = (CreateUserDTO) o;
    return Objects.equals(this.name, createUser.name) &&
        Objects.equals(this.email, createUser.email) &&
        Objects.equals(this.password, createUser.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateUserDTO {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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
