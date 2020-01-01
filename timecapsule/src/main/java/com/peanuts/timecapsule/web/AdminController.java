package com.peanuts.timecapsule.web;


import com.peanuts.timecapsule.domain.Admin;
import com.peanuts.timecapsule.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//TODO
@RestController
@RequestMapping("/admin")
public class AdminController {
    static Map<String, Admin> admins = Collections.synchronizedMap(new HashMap<>());

    @GetMapping("/")
    public List<Admin> getAllAdmin(){
        return new ArrayList<>(admins.values());
    }

    @PostMapping("/")
    public String postAdmin(@RequestBody Admin admin){
        admins.put(admin.getAccount(),admin);
        return "success";
    }

    @GetMapping("/{account}")
    public  Admin getAdmin(@PathVariable String account){
        return  admins.get(account);
    }

    @PutMapping("/{account}")
    public  String putAdmin(@PathVariable String account,@RequestBody Admin admin){
        Admin a =new Admin();
        a=admin;
        admins.put(account,admin);
        return "success";
    }

    @DeleteMapping("/{account}")
    public  String deleteAdmin(@PathVariable String account){
        admins.remove(account);
        return "success";
    }

}
