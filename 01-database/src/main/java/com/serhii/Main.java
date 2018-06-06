package com.serhii;

import com.serhii.entity.User;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("user");
        user.setPassword("1234");
        user.setEmail("user@gmail.com");
        int hCode = user.hashCode();
        System.out.println(hCode);
        User user1 = new User();
        user1.setUsername("user");
        user1.setPassword("1234");
        user1.setEmail("user@gmail.com");
        int hCode1 = user1.hashCode();
        System.out.println(hCode1);
        System.out.println(user.equals(user1));
    }
}
