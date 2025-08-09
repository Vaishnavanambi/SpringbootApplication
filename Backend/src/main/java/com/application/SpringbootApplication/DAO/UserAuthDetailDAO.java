package com.application.SpringbootApplication.DAO;

import com.application.SpringbootApplication.PO.UserAuthDetailPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthDetailDAO extends JpaRepository<UserAuthDetailPO, Integer>{
}
