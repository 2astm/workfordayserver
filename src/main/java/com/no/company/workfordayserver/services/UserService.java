package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
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

    public User saveUser(User user) throws DataFormatException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void editUser(User user, Long userID) throws UsernameNotFoundException {
        if (user.getPassword()!=null)
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        User oldUser = userRepository.getOne(userID);
        oldUser.setUser(user);
        userRepository.save(oldUser);
    }

    public void changeIsUser(Boolean isUser, String email){
        userRepository.updateIsUser(isUser, email);
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
