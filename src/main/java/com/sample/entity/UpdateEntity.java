package com.sample.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class UpdateEntity implements Serializable {

  private long id;
  private String payload;

  @JsonProperty("id")
  public long getId() {
    return id;
  }

  public void setId(long Id) {
    this.id = id;
  }

  @JsonProperty("payload")
  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  @Override
  public String toString() {

    String jsonInString = "";
    ObjectMapper mapper = new ObjectMapper();

    try {
      jsonInString = mapper.writeValueAsString(this);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return jsonInString;
  }
}
