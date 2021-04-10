package com.inonusosyal.api.controller;

import com.inonusosyal.api.dto.UserProfileDto;
import com.inonusosyal.api.entity.UserEntity;
import com.inonusosyal.api.entity.UserFollow;
import com.inonusosyal.api.jwt.JwtUtil;
import com.inonusosyal.api.service.RegistrationService;
import com.inonusosyal.api.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;


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

    @GetMapping("/profile/{userid}")
    public ResponseEntity<UserProfileDto> fetchUserProfile(@PathVariable String userid) {
        UserProfileDto profileDto = userService.getUserProfileById(userid);
        return profileDto == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(profileDto, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        if (!authenticationRequest.getUsername().contains("@")) {
            Optional<UserEntity> temp = userService.getEmailByUsername(authenticationRequest.getUsername());
            temp.ifPresent(userEntity -> authenticationRequest.setUsername(userEntity.getEmail()));
        }
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        Optional<UserEntity> user = userService.getUserByEmail(authenticationRequest.getUsername());
        if (user.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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

    @PostMapping(path = "requestfollow")
    public ResponseEntity<Void> userFollowRequest(@RequestBody UuidForRequest reqBody) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity follower = (UserEntity) authentication.getPrincipal();
        UserFollow userFollow = new UserFollow();
        userFollow.setUserId(UUID.fromString(reqBody.getUuid()));
        userFollow.setFollowerId(follower.getId());
        return userService.addFollowRequest(userFollow) == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "acceptrequestfollow")
    public ResponseEntity<?> acceptUserFollowRequest(@RequestBody UuidForRequest reqBody) {
        return   new ResponseEntity<>(userService.acceptFollowRequest(UUID.fromString(reqBody.getUuid())),HttpStatus.OK);
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class UuidForRequest {
    private String uuid;
}