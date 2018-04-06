package com.serhii.repository;

import com.serhii.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends AbstractRepository<User> {
    User findUserByUsername(String username);
}
