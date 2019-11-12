package com.netcracker.interviewscheduleridprovider.controllers;

import com.netcracker.interviewscheduleridprovider.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddUser {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/do")
    @ResponseBody
    public int doStuffMethod() {
        return userService.createUser("q","q");
    }

    @RequestMapping(value="/doDelete")
    @ResponseBody
    public int doDelete() {
        return userService.deleteUser("a89625f0-0ff3-4ca4-a021-4e1ee68dc6be");
    }

    @RequestMapping(value="/doEdit")
    @ResponseBody
    public void doEdit() {
        userService.editUser("1da3b0bb-2c0e-4b25-aeeb-b33fba2e87a0");
    }
}
