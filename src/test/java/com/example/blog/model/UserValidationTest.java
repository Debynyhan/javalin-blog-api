package com.example.blog.model;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.example.blog.model.User;

import java.util.Set;
import jakarta.validation.ConstraintViolation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserValidationTest {

    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void whenAllConstraintsAreSatisfied_thenValidationsSucceeds() {
        User user = new User("validUser", "validPassword123", "valid@email.com", "user");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals(0, violations.size());
    }

    @Test
    public void whenUsernameIsMissing_thenValidationFails() {
        User user = new User("", "validpass", "valid@email.com", "user");
        user.setId("123");

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertEquals(1, violations.size());
        assertEquals("Username is required", violations.iterator().next().getMessage());
    }

    @Test
    public void whenEmailIsInvalid_thenValidationFails() {
        User user = new User("validuser", "validpass", "invalid-email", "user");
        user.setId("123");

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertEquals(2, violations.size());
        assertEquals("Email should be valid", violations.iterator().next().getMessage());
    }

}
