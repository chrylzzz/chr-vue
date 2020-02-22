package com.chryl.controller;


import com.chryl.po.AuthUser;
import com.chryl.util.AesCBC;
import com.chryl.util.CookieUtils;
import com.chryl.util.PasswordUtil;
import com.chryl.util.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by Chryl on 2020/2/12.
 */
@RequestMapping("/user")
@RestController
public class AdminController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseResult login(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
        if (!StringUtils.isBlank(token))
            return ResponseResult.build(200, token);
        return ResponseResult.build(500, token);
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestParam String username,
                                @RequestParam String password,
                                @RequestParam(required = false) boolean check, HttpServletRequest request, HttpServletResponse response) {
        try {
            password = PasswordUtil.EncodeByMD5(password);
            ResponseResult result = userLogin(check, username, password, request, response);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.build(500, e.getMessage());
        }
    }


    public ResponseResult userLogin(boolean check, String username, String password, HttpServletRequest request, HttpServletResponse response) {
        //查询列表
        AuthUser user = new AuthUser();
        user.setUsername("chryl");
        //比对密码
       /* if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
            return ResponseResult.build(400, "用户名或密码错误");
		}*/
        //生成token
        String token = UUID.randomUUID().toString();
        //保存用户之前，把用户对象中的密码清空。
        user.setPassword(null);
        //是否记住密码 add by 徐云鹏
        if (check) {
            try {
                password = AesCBC.getInstance().encrypt(password, "utf-8", AesCBC.CBC_KEY, AesCBC.CBC_IV);
                CookieUtils.setCookie(request, response, "UNAME", user.getUsername().toString(), 60 * 60 * 24 * 7);
                CookieUtils.setCookie(request, response, "PWD", password.toString(), 60 * 60 * 24 * 7);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            CookieUtils.deleteCookie(request, response, "UNAME");
            CookieUtils.deleteCookie(request, response, "PWD");
        }
        //写入cookie
        CookieUtils.setCookie(request, response, "TT_TOKEN", token);

        //返回token
        return ResponseResult.ok(token);
    }

}
