package com.videocustom.guest.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * CreateGuestDTO
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-08-12T04:10:18.235256800-03:00[America/Sao_Paulo]")


public class CreateGuestDTO   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("password")
  private String password = null;

  public CreateGuestDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The guest name
   * @return name
   **/
  @Schema(example = "John Doe", required = true, description = "The guest name")
      @NotNull

  @Size(max=255)   public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateGuestDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The guest email
   * @return email
   **/
  @Schema(example = "guest@email.com", required = true, description = "The guest email")
      @NotNull

    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CreateGuestDTO password(String password) {
    this.password = password;
    return this;
  }

  /**
   * The guest password
   * @return password
   **/
  @Schema(example = "password", required = true, description = "The guest password")
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
    CreateGuestDTO createGuest = (CreateGuestDTO) o;
    return Objects.equals(this.name, createGuest.name) &&
        Objects.equals(this.email, createGuest.email) &&
        Objects.equals(this.password, createGuest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateGuestDTO {\n");
    
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
