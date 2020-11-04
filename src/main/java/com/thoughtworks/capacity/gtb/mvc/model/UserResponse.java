package com.thoughtworks.capacity.gtb.mvc.model;

public class UserResponse {

    private final Integer id;
    private final String username;
    private final String password;
    private final String email;

    public UserResponse(Integer id, User user) {
        this.id = id;
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }

    public Integer getId() {
        return id;
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
