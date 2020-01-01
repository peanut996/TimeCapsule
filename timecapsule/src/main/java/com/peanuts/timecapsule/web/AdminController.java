package com.peanuts.timecapsule.web;


import com.peanuts.timecapsule.domain.Admin;
import com.peanuts.timecapsule.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;


//TODO
@Api(tags = "管理员管理")
@RestController
@RequestMapping("/admin")
public class AdminController {
    static Map<String, Admin> admins = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value = "获取所有管理员")
    @GetMapping("/")
    public List<Admin> getAllAdmin(){
        return new ArrayList<>(admins.values());
    }
    @ApiOperation(value = "添加一个管理员")
    @PostMapping("/")
    public String postAdmin(@RequestBody Admin admin){
        admins.put(admin.getAccount(),admin);
        return "success";
    }

    @ApiOperation(value = "查询管理员")
    @GetMapping("/{account}")
    public  Admin getAdmin(@PathVariable String account){
        return  admins.get(account);
    }

    @ApiOperation(value="更新管理员")
    @PutMapping("/{account}")
    public  String putAdmin(@PathVariable String account,@RequestBody Admin admin){
        Admin a =new Admin();
        a=admin;
        admins.put(account,admin);
        return "success";
    }

    @ApiOperation(value="删除管理员")
    @DeleteMapping("/{account}")
    public  String deleteAdmin(@PathVariable String account){
        admins.remove(account);
        return "success";
    }

}
