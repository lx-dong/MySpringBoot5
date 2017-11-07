package com.china317.myspringboot5.web.config;

import com.china317.myspringboot5.web.filter.UserAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by lx-dong on 2017/11/6.
 */
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean userAuthenticationFilter(){
        FilterRegistrationBean register = new FilterRegistrationBean();
        register.setFilter(new UserAuthenticationFilter());
        register.setEnabled(true);
        register.setName("userAuthenticationFilter");
        register.addUrlPatterns("/*");
        register.addInitParameter("targetFilterLifecycle","true");
        register.setOrder(1);
        return register;
    }

}
