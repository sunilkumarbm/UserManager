package com.sunnytech.usermanager.exceptions;

public class UserNotFoundException extends Exception {
  public UserNotFoundException() {
    super("User not found");
  }
}
