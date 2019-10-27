package com.chryl.controller;

import com.alibaba.fastjson.JSON;
import com.chryl.mapper.UserMapper;
import com.chryl.po.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Chryl on 2019/10/26.
 */
@RestController
public class ChrylController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/get1")
    public Object show(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @GetMapping("/jsonp1")
    public Object show4() {
        User user = userMapper.selectByPrimaryKey("2");
        return user;
    }

    @PostMapping("/post1")
    public Object show2(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @PostMapping("/post2")
    public Object show3(@RequestBody User u) {
        User user = userMapper.selectByPrimaryKey(u.getId());
        return user;
    }

    //

    public static void main(String[] args) {
        String s = "absocltq";
        String target = "b";
        String target0 = "q";
        String target2 = "z";
        int i = s.indexOf(target);
        System.out.println(i);
        int i0 = s.indexOf(target0);
        System.out.println(i0);

        int i1 = s.indexOf(target2);
        System.out.println(i1);
        int zb = s.indexOf("zb");
        System.out.println(zb);
        boolean contains = s.contains(target);
        System.out.println(contains);
        boolean contains2 = s.contains("");
        System.out.println(contains2);

    }
}
