package com.userServiceREST.controller;

import com.userServiceREST.data.User;
import com.userServiceREST.service.UserService;
import com.userServiceREST.validation.UserValidation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private UserValidation userValidation;

    public UserController(UserService userService, UserValidation userValidation) {
        this.userService = userService;
        this.userValidation = userValidation;
    }

    @PostMapping("/registration")
    public ResponseEntity addUser(@RequestBody User user) {
        userValidation.validate(user);
        if (userValidation.hasErrors()) {
            return new ResponseEntity<>(userValidation.getErrorMsg(), HttpStatus.BAD_REQUEST);
        } else {
            userService.save(user);
            return new ResponseEntity<>(user.getId(), HttpStatus.CREATED);
        }
    }

    @GetMapping("/getUsers")
    public ResponseEntity showUsersWithPagination(Pageable pageable) {
        return new ResponseEntity<>(userService.showAllUsers(pageable), HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity updateUser(@RequestBody User updatedUser, @PathVariable("id") Long id) {
        userValidation.validate(updatedUser);
        if (userValidation.hasErrors()) {
            return new ResponseEntity<>(userValidation.getErrorMsg(), HttpStatus.BAD_REQUEST);
        } else {
            Optional<User> userOpt = userService.updateUser(updatedUser, id);
            return userOpt.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        }
    }

    @DeleteMapping("/{id}/delete")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }
}
