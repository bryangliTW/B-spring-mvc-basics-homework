package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.model.UserResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<Integer, User> userMap = new HashMap<>();

    public UserService() { }

    public void createUser(User user) {
        this.userMap.put(userMap.size() + 1, user);
    }

    public UserResponse logIn(String username, String password) {
        int[] userId = new int[1];
        this.userMap.forEach((id, user) -> {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) ) {
                userId[0] = id;
            }
        });
        if (userId[0] != 0) {
            return new UserResponse(userId[0], userMap.get(userId[0]));
        } else {
            return null;
        }
    }
}
