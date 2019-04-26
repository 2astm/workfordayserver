package com.no.company.workfordayserver.services;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.no.company.workfordayserver.consts.SecurityRoles;
import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.repos.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public User getUserByEmail(@Email String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent())
            return userOptional.get();
        else
            throw new UsernameNotFoundException("User not found");
    }

    public void saveUser(User user) throws DataFormatException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void editUser(User user, String email) throws UsernameNotFoundException {
        if (user.getPassword()!=null)
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        User olduser = getUserByEmail(email);
        olduser.setUser(user);
        userRepository.save(olduser);
    }

    public void removeUser(@Email String email){
        userRepository.deleteByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return getUserByEmail(email);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
