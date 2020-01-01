package com.peanuts.timecapsule;

import com.peanuts.timecapsule.domain.User;

public class Test {
    public static void main(String[] args) {
        User user1 =new User();
        user1.setId(1);
        user1.setUsername("Peanuts");
        System.out.println(user1.getId()+": "+user1.getUsername());
        User user2 =new User();
        user2.setId(2);
        user2.setUsername("Godw");
        System.out.println(user2.getId()+": "+user2.getUsername());
        user1=user2;
        System.out.println(user1.getId()+": "+user1.getUsername());
    }
}
