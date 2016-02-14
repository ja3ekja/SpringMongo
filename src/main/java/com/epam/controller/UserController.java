package com.epam.controller;

import com.epam.model.User;
import com.epam.repository.UserRepository;
import com.epam.service.UserGenerator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by HP on 2016-02-14.
 */
@RestController
public class UserController {

    Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserGenerator userGenerator;

    @RequestMapping(value = "/saveuser", method = RequestMethod.GET)
    public String saveUser() {
        User user = new User("101", "nic", "Jur", "Wale", "gorzalajurek@gmail.com", "secret1");
        userRepository.save(user);
        User newUser = userRepository.findByName("Jur");
        return newUser.toString();
    }

    @RequestMapping(value = "/save300users", method = RequestMethod.GET)
    public void save300Users() throws IOException {
        userGenerator.generate300Users();
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public String getUser() {
        User newUser1 = userRepository.findByName("Jureczek1");
        return newUser1.toString();
    }
}
