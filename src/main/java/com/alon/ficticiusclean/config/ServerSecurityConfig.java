package com.alon.ficticiusclean.config;

import com.alon.ficticiusclean.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserService userService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers( HttpMethod.OPTIONS, "/**" );
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean  
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder) throws Exception {        
        builder.userDetailsService(userService)
               .passwordEncoder(this.passwordEncoder());
    }
 
}