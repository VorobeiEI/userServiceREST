package com.userServiceREST.validation;

import com.userServiceREST.data.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserValidation {

    private String errorMsg;

    public void validate(User user) {
        errorMsg = "";
        if (user.getUserName() == null || user.getUserName().isEmpty() ||
                user.getPassword() == null || user.getPassword().isEmpty() ||
                user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
            errorMsg = "Error: please fullfill all fields";
        } else if (!user.getPassword().equals(user.getConfirmPassword())) {
            errorMsg = "Error : passwords are not the same";
        }
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public boolean hasErrors() {
        return !errorMsg.isEmpty();
    }
}
