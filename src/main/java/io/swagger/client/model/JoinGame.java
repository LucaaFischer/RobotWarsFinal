/*
 * Robot Wars API
 * Eine Api für das Spiel Robot Wars
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * JoinGame
 */


public class JoinGame {
  @SerializedName("robotId")
  private String robotId = null;

  public JoinGame robotId(String robotId) {
    this.robotId = robotId;
    return this;
  }

   /**
   * Roboter ID
   * @return robotId
  **/
  @Schema(example = "1234", description = "Roboter ID")
  public String getRobotId() {
    return robotId;
  }

  public void setRobotId(String robotId) {
    this.robotId = robotId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JoinGame joinGame = (JoinGame) o;
    return Objects.equals(this.robotId, joinGame.robotId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(robotId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JoinGame {\n");
    
    sb.append("    robotId: ").append(toIndentedString(robotId)).append("\n");
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
