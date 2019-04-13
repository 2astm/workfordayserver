package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.consts.SecurityRoles;
import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.util.Arrays;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByEmail(@Email String email){
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = getUserByEmail(email);
        if (!userOptional.isPresent()) {
            System.out.println(email);
            throw new UsernameNotFoundException("User not found");
        }
        User user = userOptional.get();
        GrantedAuthority authority = new SimpleGrantedAuthority(SecurityRoles.USER);
        return (UserDetails) new org.springframework.security.core.userdetails.User(user.getEmail(), "{noop}" + user.getPassword(), Arrays.asList(authority));
    }
}
