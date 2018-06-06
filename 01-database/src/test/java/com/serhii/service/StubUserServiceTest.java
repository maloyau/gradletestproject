package com.serhii.service;

import com.serhii.config.DataSourceConfig;
import com.serhii.config.impl.DeveloperDataConfig;
import com.serhii.config.impl.TestDataSourceConfig;
import com.serhii.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataSourceConfig.class)
public class StubUserServiceTest {

    private final static String username = "User1";

    @Autowired
    UserService userService;

    @Before
    public void setUp() throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setPassword("1234");
        userService.save(user);
    }

    @Test
    public void findByUsername() throws Exception {
        assertNotNull(userService.findByUsername(username));
        assertEquals(username, userService.findByUsername(username).getUsername());
    }

}