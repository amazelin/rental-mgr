package com.nilezam.rentalmgr.web.user;

import com.nilezam.rentalmgr.model.user.User;
import com.nilezam.rentalmgr.model.user.UserRepository;
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

    @RequestMapping(value= "/users/sign-up", method = RequestMethod.POST)
    public UserResponse signUp(@RequestBody SignUpInput signUpInput) {

        final User user = userRepository.add(new User(null, signUpInput.getFirstName(), signUpInput.getLastName(), signUpInput.getMail(), passwordEncoder.encode(signUpInput.getPassword())));

        UserResponse userResponse = new UserResponse(user.getId());
        userResponse.setFirstName(userResponse.getFirstName());
        userResponse.setLastName(userResponse.getLastName());
        userResponse.setMail(userResponse.getMail());

        return userResponse;
    }


    @RequestMapping(value = "/users/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        userRepository.find();


    }

}
