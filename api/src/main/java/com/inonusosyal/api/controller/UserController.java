package com.inonusosyal.api.controller;

import com.inonusosyal.api.service.RegistrationService;
import com.inonusosyal.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final RegistrationService registrationService;


    @GetMapping("{userid}")
    public ResponseEntity<?> fetchUser(@PathVariable String userid) {
        return userService.getUserById(userid).<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("user " + userid + " was not found"));
    }

    @PostMapping("register")
    public String registerUser(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
