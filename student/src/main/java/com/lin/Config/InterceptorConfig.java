package com.lin.Config;

import com.lin.interceptor.CentreInterceptor;
import com.lin.interceptor.StudentInterceptor;

import com.lin.interceptor.TeacherInterceptor;
import com.lin.interceptor.TotalInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {

            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TotalInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/student/**", "/teacher/**","/login.html", "/centre/**");
        registry.addInterceptor(new StudentInterceptor()).addPathPatterns("/student/*").excludePathPatterns();
        registry.addInterceptor(new TeacherInterceptor()).addPathPatterns("/teacher/*").excludePathPatterns();
        registry.addInterceptor(new CentreInterceptor()).addPathPatterns("/centre/*").excludePathPatterns();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        if (!registry.hasMappingForPattern("/webjars/**")) {

            registry.addResourceHandler("/webjars/**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/");
        }
        if (!registry.hasMappingForPattern("/**")) {

            registry.addResourceHandler("/**").addResourceLocations(
                    CLASSPATH_RESOURCE_LOCATIONS);
        }


    }
}
