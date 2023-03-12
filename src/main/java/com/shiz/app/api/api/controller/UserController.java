package com.shiz.app.api.api.controller;

import com.shiz.app.api.api.model.Picture;
import com.shiz.app.api.api.model.User;
import com.shiz.app.api.service.PictureService;
import com.shiz.app.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

private UserService userService;
private PictureService pictureService;

@Autowired
public UserController(UserService userService){
    this.userService=userService;
}

@GetMapping("/user")
    public User getUser(@RequestParam Integer id){

    Optional user = userService.getUser(id);
    if(user.isPresent()){
            return (User) user.get();
    }
    return null;
    }


}
