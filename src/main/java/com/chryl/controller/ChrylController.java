package com.chryl.controller;

import com.chryl.mapper.UserMapper;
import com.chryl.po.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

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

    @GetMapping("/showimg")
    public void showimg(String path, HttpServletResponse response) {
        //从本地读取文件并返回到网页中
        FileInputStream in = null;
        ServletOutputStream out = null;
        try {
            File file = new File(path);
            in = new FileInputStream(file);
            out = response.getOutputStream();
            byte[] bytes = new byte[1024 * 10];
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @GetMapping("showimg2")
    public void show2(String path, HttpServletResponse response) {

        File file = new File(path);
        try (InputStream inputStream = new FileInputStream(file);
             OutputStream outputStream = response.getOutputStream()
        ) {
            if (file.exists()) {

                byte[] bytes = new byte[inputStream.available()];
                int length = 0;
                while ((length = inputStream.read(bytes)) != -1) {
                    System.out.println("length in ::" + length);
                    outputStream.write(bytes, 0, length);
                }
                System.out.println("length::" + length);
                outputStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("showimg3")
    public void show4(String path, HttpServletResponse response) throws IOException {

        InputStream inputStream = null;
        try (
                OutputStream outputStream = response.getOutputStream()
        ) {
            File file = new File(path);
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            System.out.println("inputStream.available()::" + inputStream.available());
            inputStream.read(bytes);
            outputStream.write(bytes);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }
    }

    @RequestMapping(value = "/showimg4", method = RequestMethod.GET)
    public void showimg4(HttpServletResponse response, String path) throws Exception {
        try {
            String filePath = "根路径" + path;
            File file = new File(filePath);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                int i = fis.available(); // 得到文件大小   
                byte data[] = new byte[i];
                fis.read(data); // 读数据
                response.setContentType("image/*"); // 设置返回的文件类型   
                OutputStream toClient = response.getOutputStream();// 得到向客户端输出二进制数据的对象   
                toClient.write(data);// 输出数据
                toClient.flush();
                toClient.close();
                fis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("图片不存在");
        }
    }
}
