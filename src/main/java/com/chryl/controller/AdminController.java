package com.chryl.controller;

import com.chryl.po.AuthUser;
import com.chryl.util.AesCBC;
import com.chryl.util.CookieUtils;
import com.chryl.util.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * Created by Chryl on 2020/2/12.
 */
@RequestMapping("/user")
@RestController
public class AdminController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {


        //模拟解密成功
        if (true) {
            String uname = CookieUtils.getCookieValue(request, "UNAME", "utf-8");
            String pwd = CookieUtils.getCookieValue(request, "PWD", "utf-8");
            if (uname.trim().equals("chryl") && pwd.trim().toUpperCase().equals("40A32D0BBDD411A2EA698C65E237DBBC")) {
                String token = CookieUtils.getCookieValue(request, "TT_TOKEN", "utf-8");
                if (token != null) {
                    return token;
                }
            }
        }


        //AES 加密使用
        model.addAttribute("key", AesCBC.CBC_KEY);
        model.addAttribute("iv", AesCBC.CBC_IV);
        return "sys/admin/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseResult login(@RequestParam boolean check, @RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {
        try {
            password = "40A32D0BBDD411A2EA698C65E237DBBC";
            //对密码解密
            password = AesCBC.getInstance().decrypt(password, "utf-8", AesCBC.CBC_KEY, AesCBC.CBC_IV);


            ResponseResult result = userLogin(check, username, password, request, response);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.build(500, e.getMessage());
        }
    }


    public ResponseResult userLogin(boolean check, String username, String password, HttpServletRequest request, HttpServletResponse response) {
        //查询列表
//        AuthUserExample example = new AuthUserExample();
//        Criteria criteria = example.createCriteria();
//        criteria.andUsernameEqualTo(username);
//        criteria.andStatusEqualTo("T");
//        List<AuthUser> list = authUserMapper.selectByExample(example);
        //如果没有此用户名
//        if (null == list || list.size() == 0) {
//            return ResponseResult.build(400, "用户不存在");
//        }
//        AuthUser user = list.get(0);
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
