package com.no.company.workfordayserver.config;

import com.no.company.workfordayserver.consts.SecurityRoles;
import com.no.company.workfordayserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.OneToMany;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/user/get/","/user/delete/").hasAnyRole(SecurityRoles.USER, SecurityRoles.ADMIN)
                .antMatchers(HttpMethod.POST, "/user/edit/", "/work/addwork", "/work/changework").hasAnyRole(SecurityRoles.USER, SecurityRoles.ADMIN)
                .antMatchers(HttpMethod.POST, "/user/addAdmin/").hasRole(SecurityRoles.ADMIN)
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }
}
