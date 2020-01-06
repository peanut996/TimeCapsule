package com.peanuts.timecapsule.web;

import com.peanuts.timecapsule.domain.Admin;
import com.peanuts.timecapsule.domain.Capsule;
import com.peanuts.timecapsule.domain.User;
import com.peanuts.timecapsule.service.CapsuleService;
import com.peanuts.timecapsule.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@Api(tags = "胶囊管理")
@CrossOrigin
@RestController
@RequestMapping("/capsule")
//TODO
public class CapsuleController {

    @Autowired
    private  CapsuleService capsuleService ;

    @ApiOperation(value = "获取所有的胶囊")
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Capsule> getAllCapsule(){
        return capsuleService.findAll();
    }

    @ApiOperation(value = "添加胶囊")
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String postCapsule(@RequestBody Capsule capsule ){
        capsuleService.addCapsule(capsule);
        return "success";
    }

    @ApiOperation(value = "查询胶囊")
    @GetMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @ApiImplicitParam(paramType = "path", dataType = "String", name = "uuid", value = "Key", required = true, example = "1")
    public Capsule getCapsule(@PathVariable String uuid){
        return  capsuleService.findByUuid(uuid);
    }

    @ApiOperation(value="更新胶囊")
    @PutMapping("/{uuid}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiImplicitParam(paramType = "path", dataType = "String", name = "uuid", value = "Key", required = true, example = "1")
    public String putCapsule(@PathVariable String  uuid,@RequestBody Capsule capsule){
        Capsule c=capsuleService.findByUuid(uuid);
        Utils.copyPropertiesIgnoreNull(capsule,c);
        capsuleService.updateCapsule(c);
        return  "success";
    }

    @ApiOperation(value = "删除胶囊")
    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiImplicitParam(paramType = "path", dataType = "String", name = "uuid", value = "Key", required = true, example = "1")
    public  String deleteCapsule(@PathVariable String uuid){
        capsuleService.deleteByUuid(uuid);
        return "success";
    }
}
