package com.peanuts.timecapsule.repository;

import com.peanuts.timecapsule.domain.Capsule;
import com.peanuts.timecapsule.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface CapsuleRepository extends JpaRepository<Capsule,Long> {

    @Query("From Capsule  c where c.uuid= :uuid")
    Capsule getByUuid(@Param("uuid") String uuid);


    @Modifying
    @Transactional
    @Query("delete  from  Capsule  c where c.uuid= :uuid")
    void deleteByUuid(@Param("uuid") String uuid);

}
