package com.cook.baolema.config;

import com.cook.baolema.interceptors.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 徐亮
 */
@Configuration
public class JwtConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                //添加拦截路径:拦截所有请求
                .addPathPatterns("/**")
                //添加放行路径:仅对login相关资源放行
                .excludePathPatterns("/login/*");
    }
}
