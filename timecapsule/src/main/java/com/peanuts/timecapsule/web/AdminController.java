package com.peanuts.timecapsule.web;


import com.peanuts.timecapsule.domain.Admin;
import com.peanuts.timecapsule.domain.User;
import com.peanuts.timecapsule.service.AdminService;
import com.peanuts.timecapsule.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;



@Api(tags = "管理员管理")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "获取所有管理员")
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> getAllAdmin(){
        return adminService.findAll();
    }


    @ApiOperation(value = "添加一个管理员")
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String postAdmin(@RequestBody Admin admin){
        adminService.addAdmin(admin);
        return "success";
    }

    @ApiOperation(value = "查询管理员")
    @GetMapping("/{account}")
    @ResponseStatus(HttpStatus.OK)
    @ApiImplicitParam(paramType = "path", dataType = "String", name = "account", value = "账号", required = true, example = "1")
    public  Admin getAdmin(@PathVariable String account){
        return  adminService.getByAccount(account);
    }



    @ApiOperation(value="更新管理员")
    @PutMapping("/{account}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiImplicitParam(paramType = "path", dataType = "String", name = "account", value = "账号", required = true, example = "1")
    public  String putAdmin(@PathVariable String account,@RequestBody Admin admin){
        Admin a =adminService.getByAccount(account);
        Utils.copyPropertiesIgnoreNull(admin,a);
        adminService.updateAdmin(a);
        return "success";
    }

    @ApiOperation(value="删除管理员")
    @DeleteMapping("/{account}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiImplicitParam(paramType = "path", dataType = "String", name = "account", value = "账号", required = true, example = "1")
    public  String deleteAdmin(@PathVariable String account){
        adminService.deleteByAccount(account);
        return "success";
    }

}
