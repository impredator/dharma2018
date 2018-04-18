package com.dharma.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
class UserServiceTest {
  private UserService userService = null;

  @BeforeEach
  void init() {
    userService = new UserService();
  }

  @Test
  void logoutSuccess() {
    long userId = 1L;
    assertTrue(userService.logout(userId));

  }

  @Test
  void resetPasswordExistingUser() {
    long userId = 1l;
    assertTrue(userService.resetPassword(userId));

  }

  @Test
  void resetPasswordUserNotExist() {
    long userId = 5l;
    assertFalse(userService.resetPassword(userId));

  }

  @Nested
  @DisplayName("Test Login Feature")
  class LoginFeature {

    @Test
    void loginUsernamePasswordAreCorrect() {
      boolean actual = userService.login("admin", "admin");
      assertTrue(actual);
    }

    @Test
    void loginUsernamePasswordAreInCorrect() {
      boolean actual = userService.login("admin", "admin");
      assertFalse(actual);
    }

    @Test
    void loginUsernamePasswordAreNulls() {
      IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        userService.login(null, null);
      });
      assertEquals("Username and password must not be null or empty", exception.getMessage());

    }

    @Test
    void loginUsernamePasswordAreEmpty() {

      assertThrows(IllegalArgumentException.class, () -> {
        userService.login("", "");
      });

    }
  }
  @Nested
  @DisplayName("Test ChangePassword Feature")
  class ChangePasswordFeature {
    @Test
    void changePasswordUserExistOldPasswordNewPasswordCorrect() {
      long userId = 1L; // existed user
      assertTrue(userService.changePassword(userId, "admin", "admin123"));
    }

    @Test
    void changePasswordUserNotExist() {
      long userId = 999L;
      assertFalse(userService.changePassword(userId, "admin", "admin123"));
    }

    @Test
    void changePasswordUserExistOldPasswordAndNewPasswordEmpty() {
      long userId = 1L;
      assertFalse(userService.changePassword(userId, "", ""));
    }

    @Test
    void changePasswordUserExistOldPasswordEqualNewPassword() {
      long userId = 1L;
      assertTrue(userService.changePassword(userId, "admin", "admin123"));
    }
  }

}
