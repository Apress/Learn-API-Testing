package com.contact.mgmt.exceptions;

/**
 * InvalidResponseException is a custom exception class extends the RuntimeException.
 *
 * <p>Wrapping RuntimeException for throwing during http response.
 *
 * @author Jagdeep Jain
 */
public class InvalidResponseException extends RuntimeException {
  public InvalidResponseException(String errorMessage, Throwable err) {
    super(errorMessage, err);
  }
}
