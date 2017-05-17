package com.theironyard.charlotte.AngularSpring.controllers;

import com.theironyard.charlotte.AngularSpring.entities.User;
import com.theironyard.charlotte.AngularSpring.services.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Rest controller indicates that this is a controller that handles JSON requests.
@RestController
public class AngularSpringController {
    @Autowired //autowire to save/retrieve data about users
    UserRepo users;

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> getUsers() { //"List" indicates the type of info we send back in the method.
        //Spring will turn this object into JSON for us.
        return (List<User>) users.findAll();
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    //what I expect from the request body is a json representation of a user.
    //user has no id, a new object will be created. Request has "null" id from JSON.
    public void addUser(@RequestBody User user) {
        users.save(user);
    }

    @RequestMapping(path = "/user", method = RequestMethod.PUT) //put updates existing object. Only supported by AJAX browser
    public void updateUser(@RequestBody User user) {
        //in this method, the user will have an ID, when we save this user Hibernate will find it and
        // overwrite values with this object.
        users.save(user);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") int id) {
        users.delete(id);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id) {
        return users.findOne(id);
    }
}
