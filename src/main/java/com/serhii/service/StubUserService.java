package com.serhii.service;

import com.serhii.entity.User;
import com.serhii.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userService")
public class StubUserService implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void save(User entity) {
        userRepository.save(entity);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
