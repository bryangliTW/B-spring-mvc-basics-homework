package com.thoughtworks.capacity.gtb.mvc.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
    @Pattern(regexp="[a-zA-Z0-9_]+", message="username must only contain numbers, letters and underscores.")
    @Size(min=3, max=10, message="username must contain only 3 to 10 characters.")
    @NotBlank(message = "Username cannot be blank.")
    private final String username;

    @Size(min=5, max=12, message="password must be between 5 and 12 characters.")
    @NotBlank(message = "password should not be blank.")
    private final String password;

    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message="email is not valid")
    private final String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
