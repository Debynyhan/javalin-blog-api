package com.example.blog.model;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.Set;
import jakarta.validation.ConstraintViolation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        User user = new User("", "validPassword123", "valid@email.com", "user");
        user.setId("123");

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertEquals(2, violations.size());
        boolean hasUsernameViolation = violations.stream()
                .anyMatch(v -> v.getPropertyPath().toString().equals("username") &&
                        (v.getMessage().equals("Username is required") ||
                                v.getMessage().equals("Username must be between 3 and 20 characters")));
        assertTrue(hasUsernameViolation, "Expected a violation on username for being blank or too short");
    }


    @Test
    public void whenEmailIsInvalid_thenValidationFails() {
        User user = new User("validUser", "validPassword123", "invalid-email", "user");
        user.setId("123");

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertEquals(1, violations.size());

        boolean hasEmailViolation = violations.stream()
                .anyMatch(v -> v.getPropertyPath().toString().equals("email") &&
                        v.getMessage().equals("Email should be valid"));
        assertTrue(hasEmailViolation, "Expected a violation on email for being invalid");
    }

}
