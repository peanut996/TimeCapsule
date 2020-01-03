package com.peanuts.timecapsule.service;


import com.peanuts.timecapsule.domain.Admin;
import com.peanuts.timecapsule.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> findAll(){
        return  adminRepository.findAll();
    }

    public  Admin getById(Long id){
        return adminRepository.getOne(id);
    }

    public  Admin getByAccount(String account){
        return  adminRepository.getByAccount(account);
    }

    public void addAdmin(Admin admin){
        adminRepository.save(admin);
    }

    //fixme
    public void updateAdmin(Admin admin){
        Admin a =new Admin();
        a=admin;
        adminRepository.save(a);
    }

    public void deleteById(Long id){
        adminRepository.deleteById(id);
    }

    public void deleteAdmin(Admin admin){
        adminRepository.delete(admin);
    }

    public void deleteByAccount(String account){
        adminRepository.deleteByAccount(account);
    }
}
