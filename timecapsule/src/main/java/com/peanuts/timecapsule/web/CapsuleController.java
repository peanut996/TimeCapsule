package com.peanuts.timecapsule.web;

import com.peanuts.timecapsule.domain.Admin;
import com.peanuts.timecapsule.domain.Capsule;
import com.peanuts.timecapsule.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@Api(tags = "胶囊管理")
@RestController
@RequestMapping("/capsule")
//TODO
public class CapsuleController {
    //represent the collections
    static Map<Long, Capsule> capsules = Collections.synchronizedMap(new HashMap<>());
    @ApiOperation(value = "获取所有的胶囊")
    @GetMapping("/")
    public List<Capsule> getAllCapsule(){
        ArrayList<Capsule> capsules = new ArrayList<>(CapsuleController.capsules.values());
        return capsules;
    }

    @ApiOperation(value = "添加胶囊")
    @PostMapping("/")
    public String postCapsule(@RequestBody Capsule capsule ){
        capsules.put(capsule.getId(),capsule);
        return "success";
    }

    @ApiOperation(value = "查询胶囊")
    @GetMapping("/{id}")
    public Capsule getCapsule(@PathVariable Long id){
        return  capsules.get(id);
    }

    @ApiOperation(value="更新胶囊")
    @PutMapping("/{id}")
    public String putCapsule(@PathVariable Long id,@RequestBody Capsule capsule){
        Capsule c=capsules.get(id);
        c=capsule;
        capsules.put(id,c);
        return  "success";
    }

    @ApiOperation(value = "删除胶囊")
    @DeleteMapping("/{id}")
    public  String deleteCapsule(@PathVariable Long id,@RequestBody Capsule capsule){
        capsules.remove(id);
        return "success";
    }
}
