package com.chryl.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

/**
 * Created By Chr on 2019/7/30.
 */
//@Configuration
public class MultipartFileConfig extends WebMvcConfigurerAdapter {


    /**5F44D9DA9194A7E8F2E88CA017AC9EE4.jpg
     * springboot默认可以访问resources下的static文件夹下的静态资源，
     * 我们一般将图片指定上传到static下的某个文件夹，例如images,开发阶段可以使用,
     * 但是当项目打成jar包就无法使用，运行会报出无法找到文件路径。
     * 这时候就需要配置虚拟路径，用来指定到硬盘下的固定地址。
     */
    /**
     * 上面/images/**表示的是服务器请求图片的地址
     * 例如：http://localhost:8888/images/xxx.jpg 都会去映射到本地D:/test2/xxx.jpg
     * 注意location必须有前缀:file
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:/Users/chryl/images/");
        //
//        registry.addResourceHandler(IMG_HTTP_PATH)
//                .addResourceLocations(IMG_SAVE_PATH);
        super.addResourceHandlers(registry);

    }

    /**
     * 文件上传配置
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize("50MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("300MB");
        return factory.createMultipartConfig();
    }
}
