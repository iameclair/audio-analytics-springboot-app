package uk.co.audioanalytics.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.co.audioanalytics.challenge.model.User;
import uk.co.audioanalytics.challenge.services.UserService;

import java.util.List;

/**
 * Created by ${Eclair} on 5/21/2019.
 */
@RestController
@RequestMapping("api")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return  userService.fidAll();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users/{id}")
    public User retrieveUserById(@PathVariable int id){
        return  userService.findOne(id);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/users")
    public void addUser(@RequestBody User user){
        userService.save(user);
    }
}
