package com.no.company.workfordayserver.config;

import com.no.company.workfordayserver.consts.SecurityRoles;
import com.no.company.workfordayserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.persistence.OneToMany;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles(SecurityRoles.USER)
//                .and()
//                .withUser("admin").password("{noop}password").roles(SecurityRoles.ADMIN, SecurityRoles.USER);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/user/get/").hasRole(SecurityRoles.USER)
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
