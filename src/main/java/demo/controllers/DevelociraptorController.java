package demo.controllers;

import demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevelociraptorController {

    @GetMapping(value = "/api/user/{userId}")
    public User getUser(@PathVariable Integer userId){
        //TODO search user in database
        User user = new User(userId, "user1", "develociraptor");
        return user;

    }
}
