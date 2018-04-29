package com.nilezam.rentalmgr.web.user;

import com.nilezam.rentalmgr.model.user.User;
import com.nilezam.rentalmgr.persistence.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Arnaud on 19/11/2017.
 */
@RestController
@CrossOrigin
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "/users/sign-up", method = RequestMethod.POST)
    public UserResponse signUp(@RequestBody SignUpInput signUpInput) {

        final User user = userRepository.add(getUser(signUpInput));
        return getUserResponse(user);
    }

    @RequestMapping(value = "/users/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return userRepository.get(id)
                .map(user -> new ResponseEntity<>(getUserResponse(user), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private User getUser(SignUpInput signUpInput) {
        return new User(null, signUpInput.getFirstName(), signUpInput.getLastName(), signUpInput.getMail(),
                passwordEncoder.encode(signUpInput.getPassword()));
    }

    private static UserResponse getUserResponse(User user) {
        UserResponse userResponse = new UserResponse(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setMail(user.getMail());
        return userResponse;
    }
}
