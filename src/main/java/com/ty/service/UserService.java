
package com.ty.service;

import java.util.List;

import com.ty.dto.UserDTO;
import com.ty.entity.User;

public interface UserService {

    // Register a new user
    User save(UserDTO userDTO);

    // Get all users
    List<User> getAllUsers();

    // Get user by ID
    User getUserById(Long id);

    // Update user details
    User updateUser(Long id, UserDTO userDTO);

    // Delete user
    void deleteUser(Long id);

}