package com.peanuts.timecapsule.web;

import com.peanuts.timecapsule.domain.Admin;
import com.peanuts.timecapsule.domain.Capsule;
import com.peanuts.timecapsule.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/capsule")
//TODO
public class CapsuleController {
    //represent the collections
    static Map<Long, Capsule> capsules = Collections.synchronizedMap(new HashMap<>());

    @GetMapping("/")
    public List<Capsule> getAllCapsule(){
        ArrayList<Capsule> capsules = new ArrayList<>(CapsuleController.capsules.values());
        return capsules;
    }
    @PostMapping("/")
    public String postCapsule(@RequestBody Capsule capsule ){
        capsules.put(capsule.getId(),capsule);
        return "success";
    }
    @GetMapping("/{id}")
    public Capsule getCapsule(@PathVariable Long id){
        return  capsules.get(id);
    }

    @PutMapping("/{id}")
    public String putCapsule(@PathVariable Long id,@RequestBody Capsule capsule){
        Capsule c=capsules.get(id);
        c=capsule;
        capsules.put(id,c);
        return  "success";
    }

    @DeleteMapping("/{id}")
    public  String deleteCapsule(@PathVariable Long id,@RequestBody Capsule capsule){
        capsules.remove(id);
        return "success";
    }
}
