package com.nilezam.rentalmgr.web.user.subscribe;

import com.nilezam.rentalmgr.web.user.UserDto;
import com.nilezam.rentalmgr.model.user.User;
import com.nilezam.rentalmgr.model.user.UserRepository;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Arnaud on 19/11/2017.
 */
@RestController
@CrossOrigin
public class SubscribeController {


    private final UserRepository userRepository;

    public SubscribeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value= "/users/subscribe", method = RequestMethod.POST)
    public UserDto subscribe(@RequestBody SubscriberDto subscriber) {

        final User user = userRepository.add(new User(null, subscriber.getFirstName(), subscriber.getLastName(), subscriber.getMail(), subscriber.getPassword()));

        UserDto userDto = new UserDto(user.getId());

        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setMail(user.getMail());

        return userDto;
    }

}