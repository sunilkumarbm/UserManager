package com.sunnytech.usermanager.controller;

import com.sunnytech.usermanager.exceptions.UserNotFoundException;
import com.sunnytech.usermanager.model.User;
import com.sunnytech.usermanager.services.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @PostMapping("")
  public User addUser(
      @RequestBody User user
  ) {
    return userService.addUser(user);
  }

  @GetMapping("/{userId}")
  public User getUserById(
      @PathVariable
      Integer userId, HttpServletResponse response) throws IOException {
    try {
      User user = userService.getUser(userId);

      return user;
    } catch(UserNotFoundException exception) {
      response.sendError(HttpStatus.BAD_REQUEST.value(), "User not found");

      return null;
    }
  }
}
