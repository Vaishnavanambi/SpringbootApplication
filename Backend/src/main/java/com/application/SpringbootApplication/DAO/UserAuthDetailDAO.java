package com.application.SpringbootApplication.DAO;

import com.application.SpringbootApplication.PO.UserAuthDetailPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthDetailDAO extends JpaRepository<UserAuthDetailPO, Integer>{
    Optional<UserAuthDetailPO> findByUsername(@Param("userName") String userName);
}
