package com.serhii.service;

import com.serhii.entity.User;

public interface UserService extends AbstractService<User> {
    User findByUsername(String username);
}
