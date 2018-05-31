package com.gupao.controller;

import com.gupao.domain.User;
import com.gupao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 用户的控制器
 *
 */
@RestController
public class UserController {

    private final UserRepository userRepositpry;

    @Autowired
    public UserController(UserRepository userRepositpry) {
        this.userRepositpry = userRepositpry;
    }

    //@PostMapping("/user/save")
    @RequestMapping("/user/save")
    public User user(@RequestParam String name){
        User user = new User();
        user.setName(name);
        userRepositpry.save(user);
        return user;
    }

}
