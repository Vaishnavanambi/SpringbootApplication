package com.application.SpringbootApplication.Services;


import com.application.SpringbootApplication.DAO.UserAuthDetailDAO;
import com.application.SpringbootApplication.PO.UserAuthDetailPO;
import com.application.SpringbootApplication.TransferObjects.UserDetailReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailService {
    private final UserAuthDetailDAO userAuthDetailDAO;
    public void registerUser(UserDetailReq userDetailReq){
        UserAuthDetailPO userAuthDetailPO = new UserAuthDetailPO(0, userDetailReq.getUserName(), userDetailReq.getPassword(), "USER");
            userAuthDetailDAO.save(userAuthDetailPO);
    }
}
