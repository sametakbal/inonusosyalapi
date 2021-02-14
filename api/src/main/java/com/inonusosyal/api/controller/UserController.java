package com.inonusosyal.api.controller;

import com.inonusosyal.api.entity.UserEntity;
import com.inonusosyal.api.jwt.JwtUtil;
import com.inonusosyal.api.service.RegistrationService;
import com.inonusosyal.api.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Optional;


@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final RegistrationService registrationService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtTokenUtil;

    @GetMapping("{userid}")
    public ResponseEntity<?> fetchUser(@PathVariable String userid) {
        return userService.getUserById(userid).<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("user " + userid + " was not found"));
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        Optional<UserEntity> user = userService.getUserByEmail(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(user.get());

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("register")
    public String registerUser(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @GetMapping(path = "usertest")
    public String testingLogin(){
        return "successful login";
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class AuthenticationRequest implements Serializable {
    private String username;
    private String password;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class AuthenticationResponse implements Serializable {
    private String jwt;
}