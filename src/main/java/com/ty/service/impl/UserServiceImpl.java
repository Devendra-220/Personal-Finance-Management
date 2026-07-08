package com.ty.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.dto.UserDTO;
import com.ty.entity.User;
import com.ty.repository.UserRepository;
import com.ty.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserDTO userDTO) {

        User user = new User();

        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(Long id, UserDTO userDTO) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {

        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }

    }

}