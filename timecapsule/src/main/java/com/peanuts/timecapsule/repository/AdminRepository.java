package com.peanuts.timecapsule.repository;

import com.peanuts.timecapsule.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

    @Query("From Admin a where a.account = :account")
    Admin getByAccount(@Param("account") String account);

    @Query("delete  from Admin a where a.account = :account")
    void deleteByAccount(@Param("account") String account);

}
