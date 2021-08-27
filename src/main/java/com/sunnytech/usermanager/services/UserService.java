package com.sunnytech.usermanager.services;

import com.sunnytech.usermanager.exceptions.UserNotFoundException;
import com.sunnytech.usermanager.model.User;
import com.sunnytech.usermanager.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;
  public List<User> getAllUsers() {
    List<User> allUsers = userRepository.findAll();

    return allUsers;
  }

  public User addUser(User user) {
    return userRepository.save(user);
  }

  public User getUser(Integer userId) throws UserNotFoundException {
    Optional<User> userOpt = userRepository.findById(userId);

    if (userOpt.isPresent()) {
      return userOpt.get();
    } else {
      throw new UserNotFoundException();
    }
  }
}
