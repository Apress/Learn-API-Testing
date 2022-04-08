package com.oneklickshop.exceptions;

/**
 * InvalidRequestException is a custom exception class extends the RuntimeException.
 *
 * <p>Wrapping RuntimeException for throwing during http request.
 *
 * @author Jagdeep Jain
 */
public class InvalidRequestException extends RuntimeException {
  public InvalidRequestException(String errorMessage, Throwable err) {
    super(errorMessage, err);
  }
}
