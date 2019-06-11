package com.junhow.gp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 在SpringBoot2.0及Spring 5.0中WebMvcConfigurerAdapter以被废弃，建议实现WebMvcConfigurer接口
 * @author linjunhao
 * @date 2019/1/24 19:17
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Value("${resourcelocation}")
    public String resourceLocation;

    @Value("${ip}")
    private String ip;

    /**
     * 设置首页
     * @param registry
     * @return void
     * @author linjunhao
     * @date 2019/1/24 19:18
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login.shtml");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:"+ resourceLocation);
    }
    /*注意在nginx方向代理下这里失效了，返回403，如果不是反向代理是正常的。通过nginx的root配置项目映射的真实目录*/
    /* 注意这里的urlpath和pathPatterns都是以context-path的路径开始*/
}
