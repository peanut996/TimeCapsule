package com.peanuts.timecapsule.service;

import com.peanuts.timecapsule.domain.Capsule;
import com.peanuts.timecapsule.repository.CapsuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapsuleService {

    @Autowired
    private CapsuleRepository capsuleRepository;

    public List<Capsule> findAll(){
        return capsuleRepository.findAll();
    }

    public  Capsule findById(Long id){
        return  capsuleRepository.getOne(id);
    }

    public  Capsule findByUuid(String uuid){
        return  capsuleRepository.getByUuid(uuid);
    }

    public  void addCapsule(Capsule capsule){
        capsuleRepository.save(capsule);
    }

    //fixme
    public  void updateCapsule(Capsule capsule){
        Capsule c = new Capsule();
        c=capsule;
        capsuleRepository.save(c);
    }

    public  void deleteById(Long id){
        capsuleRepository.deleteById(id);
    }
    public  void deleteCapsule(Capsule capsule){
        capsuleRepository.delete(capsule);
    }
    public  void deleteByUuid(String uuid){
        capsuleRepository.deleteByUuid(uuid);
    }


}
