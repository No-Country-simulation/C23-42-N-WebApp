package org.nctry.server.Exceptions;

public class NoAuthorizedException extends RuntimeException {
  public NoAuthorizedException(String message) {
    super(message);
  }
}
