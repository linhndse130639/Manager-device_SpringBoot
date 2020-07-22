package com.linhnd.managerdevice.controller;


import com.linhnd.managerdevice.config.ApiResponse;
import com.linhnd.managerdevice.config.ApiResponseList;
import com.linhnd.managerdevice.models.rest.UserLogin;
import com.linhnd.managerdevice.models.rest.UserResponse;
import com.linhnd.managerdevice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @RequestMapping("/login")
    public ApiResponse getLogin(@RequestBody UserLogin userLogin) {
        UserResponse userResponse = userService.getLogin(userLogin);
        return ApiResponse.builder().statusCode(200).status("success").result(userResponse).build();
    }


    @GetMapping
    @RequestMapping("/all")
    public ApiResponseList getAll() {
         List all = userService.getAll();
        return ApiResponseList.builder().statusCode(200).status("success").result(all).build();
    }

    @GetMapping
    @RequestMapping("/hello")
    public ApiResponse hello() {
        return ApiResponse.builder().statusCode(200).status("success").result(null).build();
    }


}
