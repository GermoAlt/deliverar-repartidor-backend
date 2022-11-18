package com.uade.repartidorback.models;

import java.util.List;

public class InfoResponse {
  private String id;
  private String username;
  private String email;
  private List<String> roles;

  private Object data;
  private int status;

  private String message;



  public InfoResponse(int status, Object obj, String message) {
    this.status = status;
    this.data = obj;
    this.message = message;
  }

  public InfoResponse(String id, String username, String email, List<String> roles) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.roles = roles;
  }

  public InfoResponse(String id, String username, String email) {
    this.id = id;
    this.username = username;
    this.email = email;
  }


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public Object getData() {
    return data;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
