package com.tenere_bufo.itis.config;

import com.tenere_bufo.itis.filter.MainFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .csrf().disable();
        http.authorizeRequests()
                .antMatchers("/").permitAll();
    }

    @Bean
    public FilterRegistrationBean<MainFilter> loggingFilter(){
        FilterRegistrationBean<MainFilter> registrationBean
                = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MainFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
