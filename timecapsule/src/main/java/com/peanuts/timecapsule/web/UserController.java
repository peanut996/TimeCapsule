package com.peanuts.timecapsule.web;


import com.peanuts.timecapsule.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value="/user")
//TODO
public class UserController {
    //A Thread-safe Map
    static Map<String, User> users = Collections.synchronizedMap(new HashMap<>());


    /*
    function:getUserList()
    return: map
    mapping: value="/user/",method=get
     */
    @GetMapping("/")
    public List<User> getAllUser(){
        //TODO
        return new ArrayList<>(users.values());
    }

    /*
    function:postUser()
    return: String
    mapping: value="/user/",method=post
     */
    @PostMapping("/")
    public  String postUser(@RequestBody User user){
        users.put(user.getUsername(),user);
        return "success";
    }

    /*
    function:getUser()
    para: String:username
    return: User
    mapping: value="/user/{username}",method=get
     */
    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        // handle the request from "/users/{username}"，get the User by username in url
        // username from url can bind the variable by '@PathVariable'
        return users.get(username);
    }


    /*
    function:putUser()
    para: String:username
    return: String
    mapping: value="/user/{username}",method=put
    */

    @PutMapping("/{username}")
    public String putUser(@PathVariable String username, @RequestBody User user) {
        User u = users.get(username);
        //update message
        try {
            /*
            u.setAttribute(user.getAttribute)

             */
            u=user;
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            System.out.println("Catch a  UpdateUserException! ");

        }
        users.put(username, u);
        return "success";
    }

    //@PatchMapping("/{username}")


    /*
    @function:putUser()
    @para: String:username
    @return: String
    @mapping: value="/user/{username}",method=delete
     */
    @DeleteMapping("/{username}")
    public String deleteUser(@PathVariable String  username) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(username);
        return "success";
    }


}
