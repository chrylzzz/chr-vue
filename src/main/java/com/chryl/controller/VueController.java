package com.chryl.controller;

import com.chryl.mapper.UserMapper;
import com.chryl.po.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Chryl on 2019/10/27.
 */
@RestController
@RequestMapping("vue")
public class VueController {


    @Resource
    private UserMapper userMapper;


    @GetMapping("/getUsers")
    public Object show0(String id) {
        List<User> users = userMapper.queryUsers();

        Map<String, Object> respData = new HashMap<>();
        respData.put("status", "200");
        respData.put("data", users);
        return respData;
    }

    @GetMapping("/getUser")
    public Object show(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @PostMapping("/insetUser")
    public Object show2(User user) {
        String userId = UUID.randomUUID().toString().replace("-", "");
        String userPassword = userId.substring(2, 20);
        user.setUserDate(new Date());
        user.setId(userId);
        user.setUserPassword(userPassword);
        int i = userMapper.insertUser(user);
        Map<String, Object> respData = new HashMap<>();
        respData.put("status", "200");
        respData.put("data", "添加成功");
        return respData;
    }

    @PostMapping("/deleteUser")
    public Object show3(String id) {
        int i = userMapper.deleteByPrimaryKey(id);
        Map<String, Object> respData = new HashMap<>();

        respData.put("status", "200");
        respData.put("data", "删除成功");
        return respData;
    }

    @PostMapping("/updateUser")
    public Object show4(User user) {
        int i = userMapper.updateUser(user);
        Map<String, Object> respData = new HashMap<>();

        respData.put("status", "200");
        respData.put("data", "更新成功");
        return respData;
    }
}
