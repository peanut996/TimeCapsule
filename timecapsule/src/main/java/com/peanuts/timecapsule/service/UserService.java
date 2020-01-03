package com.peanuts.timecapsule.service;

import com.peanuts.timecapsule.domain.User;
import com.peanuts.timecapsule.repository.UserRepository;
import com.peanuts.timecapsule.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return  userRepository.findAll();
    }

    public User findById(Long id){
        return  userRepository.getOne(id);
    }

    public  User findByUsername(String username){
        return  userRepository.getByUsername(username);
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    //Fixme
    public void updateUser(String username,User user){
        User u =userRepository.getByUsername(username);
        Utils.copyPropertiesIgnoreNull(user, u);
        userRepository.save(u);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public void deleteByUsername(String username){
        userRepository.deleteByUsername(username);
    }



}
