package com.serhii;

import com.serhii.config.HsqlDataConfig;
import com.serhii.entity.User;
import com.serhii.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HsqlDataConfig.class)
public class TestUserService {

    public static final String USERNAME = "admin";
    public static final String PASSWORD = "password";

    @Autowired
    UserService userService;

    public void init() {
        User user = new User();
        user.setUsername(USERNAME);
        user.setPassword(PASSWORD);
        userService.save(user);
    }

    @Before
    public void setup() {
        init();
    }


    @Test
    public void TestUserService() {
        String expectedValue = USERNAME;
        assertNotNull(userService.findByUsername(USERNAME));
        String actualValue = userService.findByUsername(expectedValue).getUsername();
        assertEquals(expectedValue, actualValue);
    }
}
