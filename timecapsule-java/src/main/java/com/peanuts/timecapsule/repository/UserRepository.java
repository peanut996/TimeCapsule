package com.peanuts.timecapsule.repository;

import com.peanuts.timecapsule.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


//    Extends from JpaRepository
//    List<User> findAll();

    @Query(value = "from User  u where  u.username = :username")
    User getByUsername(@Param("username") String username);

//    Extends from JpaRepository
//    <S extends User> S save(S s);




    @Modifying
    @Transactional
    @Query("delete from User  u where u.username= :username ")
    void deleteByUsername(@Param("username") String username);

}
