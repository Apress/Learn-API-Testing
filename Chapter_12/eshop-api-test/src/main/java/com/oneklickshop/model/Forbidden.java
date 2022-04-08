package com.oneklickshop.model;

import java.util.Date;

/**
 * Forbidden Access Model
 *
 * @author Jagdeep Jain
 */
public class Forbidden {
  public Date timestamp;
  public int status;
  public String error;
  public String message;
  public String path;

  public Forbidden() {}

  public Forbidden(Date timestamp, int status, String error, String message, String path) {
    this.timestamp = timestamp;
    this.status = status;
    this.error = error;
    this.message = message;
    this.path = path;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public Forbidden setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  public int getStatus() {
    return status;
  }

  public Forbidden setStatus(int status) {
    this.status = status;
    return this;
  }

  public String getError() {
    return error;
  }

  public Forbidden setError(String error) {
    this.error = error;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public Forbidden setMessage(String message) {
    this.message = message;
    return this;
  }

  public String getPath() {
    return path;
  }

  public Forbidden setPath(String path) {
    this.path = path;
    return this;
  }
}
