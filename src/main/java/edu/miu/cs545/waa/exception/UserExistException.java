package edu.miu.cs545.waa.exception;

public class UserExistException extends RuntimeException {

  public UserExistException(String message) {
    super(message);
  }
}
