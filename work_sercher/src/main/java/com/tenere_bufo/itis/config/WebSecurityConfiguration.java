package com.tenere_bufo.itis.config;

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

        http.formLogin().loginPage("/signIn").loginProcessingUrl("/signIn").permitAll();

        http.authorizeRequests()
                .antMatchers("/css/**","/img/**","/fonts/**","/js/**","/scss/**","/signUp").permitAll()
                .antMatchers("/**").authenticated();
    }
}
