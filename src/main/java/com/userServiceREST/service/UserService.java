package com.userServiceREST.service;

import com.userServiceREST.data.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(User user);

    List getAll();

    Page<User> showAllUsers(Pageable pageable);

    Optional<User> getUserById(Long id);

    Optional<User> updateUser(User updatedUser, Long id);

    void deleteUser(Long id);

}
