/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alon.ficticiusclean.service.security;

import com.alon.ficticiusclean.service.core.UpdateException;
import com.alon.ficticiusclean.service.core.CrudService;
import com.alon.ficticiusclean.service.core.CreateException;
import com.alon.ficticiusclean.model.security.User;
import com.alon.ficticiusclean.repository.security.UserRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author paulo
 */
@Service
public class UserService extends CrudService<User, UserRepository>
                         implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    public UserService(UserRepository repository) {
        this.addBeforeCreateHook(this::checkUniqueUsername);
        this.addBeforeCreateHook(this::passwordEncrypt);
        this.addBeforeUpdateHook(this::prepareUserForUpdate);
    }

    @Override
    public List<Sort.Order> getDefaultSort() {
        return Collections.singletonList(Order.asc("username"));
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = this.repository.findByUsername(username);
        
        if (userOpt.isEmpty())
            throw new UsernameNotFoundException(String.format("The user '%s' not exists.", username));
        
        return userOpt.get();
    }
    
    private User checkUniqueUsername(User user) throws CreateException {
        boolean userExists = this.repository.existsByUsername(user.getUsername());
        
        if (userExists)
            throw new CreateException(String.format("User '%s' already exists.", user.getUsername()));
        
        return user;
    }
    
    private User passwordEncrypt(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return user;
    }
    
    private User prepareUserForUpdate(User user) {
        User databaseUser = this.repository.findById(user.getId()).get();
        databaseUser.setActive(user.isActive());
        
        return databaseUser;
    }
    
    public User changePassword(String username, String password, String newPassword) throws UpdateException {
        User user;
        
        try {
            user = this.loadUserByUsername(username);
        } catch (UsernameNotFoundException ex) {
            throw new UpdateException(ex.getMessage());
        }
        
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new UpdateException(String.format("Incorrect password for user '%s'.", username));
        
        newPassword = this.passwordEncoder.encode(newPassword);
        
        user.setPassword(newPassword);
        
        return this.repository.save(user);
    }
    
}
