package com.thoughtworks.capacity.gtb.mvc.Controller;

import com.thoughtworks.capacity.gtb.mvc.Service.UserService;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

@RestController
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid User user) {
        userService.createUser(user);
    }

    @GetMapping("/login")
    public UserResponse logIn(@RequestParam("username")
                                  @Size(min=3, max=10, message = "username must contain only 3 to 10 characters.")
                                  @NotBlank(message = "username should not be blank")
                                  @Pattern(regexp="[a-zA-Z0-9_]+", message = "username is not valid.") String username,
                              @RequestParam("password")
                              @Size(min=5, max=12, message = "password must be between 5 and 12 characters.")
                              @NotBlank(message = "password should not be blank")
                                      String password) {
        return userService.logIn(username, password);
    }
}
