package com.inonusosyal.api.controller;

import com.inonusosyal.api.entity.Dto.UserDto;
import com.inonusosyal.api.entity.User;
import com.inonusosyal.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(
        path = "/api/users"
)
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<User> fetchUsers() {
        return userService.selectAllUsers();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "{id}"
    )
    public ResponseEntity<?> fetchUser(@PathVariable("id") UUID id) {
        return userService.getUserById(id).<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorMessage("user" + id + " was not found")));
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public boolean register(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public boolean update(@RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{id}"
    )
    public boolean deleteUser(@PathVariable("id") UUID id) {
        return userService.deleteUser(id);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "search"
    )
    public List<UserDto> searchAllUsers(@RequestParam String term) {
        return userService.searchUsers(term);
    }

}

class ErrorMessage {
    String message;

    public ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}

