package com.userServiceREST.service;

import com.userServiceREST.data.User;
import com.userServiceREST.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Page<User> showAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);

    }

    @Override
    public Optional<User> updateUser(User updatedUser, Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        userOpt.ifPresent(user -> {
            user.setUserName(updatedUser.getUserName());
            user.setPassword(updatedUser.getPassword());
            user.setConfirmPassword(updatedUser.getConfirmPassword());
            userRepository.save(user);
        });

        return userOpt;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}