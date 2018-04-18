package com.dharma.junit5;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {

    public boolean login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new IllegalArgumentException("Username and password must not be null or empty");
        } else if (username.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }

    public boolean changePassword(long userId, String oldPassword, String newPassword) {
        return userId == 1 &&
                StringUtils.isNotBlank(newPassword) &&
                StringUtils.isNotBlank(newPassword) &&
                !newPassword.equals(oldPassword);
    }

    public boolean resetPassword(long userId) {
        List<Long> existingUsers = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        return existingUsers.contains(userId);
    }

    public boolean logout(long userId) {
        List<Long> existingUsers = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        if (existingUsers.contains(userId)) {
            System.out.println("log out done!");
        }
        return true;
    }


}
