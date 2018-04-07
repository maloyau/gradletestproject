package com.serhii.service;

import com.serhii.entity.User;
import com.serhii.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StubUserService implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void save(List<User> entities) {
        userRepository.save(entities);
    }

    @Override
    public void save(User entity) {
        userRepository.save(entity);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
