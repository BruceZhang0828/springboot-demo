package com.zhy.org.springbootdemo.controller;


import com.zhy.org.springbootdemo.Repository.UserRepository;
import com.zhy.org.springbootdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    private final UserRepository userRepository;

    /**
     * 构造器注入
     * @param userRepository
     */

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping("/user/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setName(name);
        if(userRepository.save(user)){
            System.out.println("存储成功"+user);
        };

        return user;
    }
}
