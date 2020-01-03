package com.peanuts.timecapsule.web;



import com.peanuts.timecapsule.domain.User;
import com.peanuts.timecapsule.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

@Api(tags = "用户管理")
@RestController
@RequestMapping(value="/user")
//TODO
public class UserController {

    @Autowired
    private  UserService userService ;

//
//    public void init() {
//        serverHandler = this;
//        serverHandler.healthDataService = this.healthDataService;
//        // 初使化时将已静态化的testService实例化
//    }


    /*
    function:getUserList()
    return: map
    mapping: value="/user/",method=get
     */
    @ApiOperation(value = "列举所有的用户")
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUser(){
        return userService.findAll();
    }

    /*
    function:postUser()
    return: String
    mapping: value="/user/",method=post
     */
    @ApiOperation(value = "添加用户")
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public  String postUser(@RequestBody User user){
        userService.addUser(user);
        return "success";
    }

    /*
    function:getUser()
    para: String:username
    return: User
    mapping: value="/user/{username}",method=get
     */
    @ApiOperation(value = "查询用户")
    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    @ApiImplicitParam(paramType = "path", dataType = "String", name = "username", value = "用户名", required = true, example = "1")
    public User getUser(@PathVariable String username) {
        // handle the request from "/users/{username}"，get the User by username in url
        // username from url can bind the variable by '@PathVariable'
        return userService.findByUsername(username);
    }


    /*
    function:putUser()
    para: String:username
    return: String
    mapping: value="/user/{username}",method=put
    */
    @ApiOperation(value = "更新用户")
    @PutMapping("/{username}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiImplicitParam(paramType = "path", dataType = "String", name = "username", value = "用户名", required = true, example = "1")
    public String putUser(@PathVariable String username, @RequestBody User user) {
        userService.updateUser(username,user);
        return "success";
    }

    //@PatchMapping("/{username}")


    /*
    @function:putUser()
    @para: String:username
    @return: String
    @mapping: value="/user/{username}",method=delete
     */
    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiImplicitParam(paramType = "path", dataType = "String", name = "username", value = "用户名", required = true, example = "1")
    public String deleteUser(@PathVariable String  username) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        userService.deleteByUsername(username);
        return "success";
    }


}
