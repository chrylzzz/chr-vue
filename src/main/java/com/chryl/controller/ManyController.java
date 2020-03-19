package com.chryl.controller;

import com.chryl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Chryl on 2020/3/19.
 */
@RestController
@RequestMapping("/many")
public class ManyController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/delUsers")
    public void delUsers(@RequestParam(value = "ids", required = false) List<String> ids) {
        int i = userMapper.deleteUserListByIds(ids);
        System.out.println(i);

    }
}
