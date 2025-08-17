package com.application.SpringbootApplication.Services;


import com.application.SpringbootApplication.DAO.UserAuthDetailDAO;
import com.application.SpringbootApplication.Interfaces.UserDetailInterface;
import com.application.SpringbootApplication.PO.UserAuthDetailPO;
import com.application.SpringbootApplication.Data.UserDetailData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService, UserDetailInterface {
    private final UserAuthDetailDAO userAuthDetailDAO;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(UserDetailData userDetailData) {
        UserAuthDetailPO userAuthDetailPO = new UserAuthDetailPO(0, userDetailData.getName(), userDetailData.getUserName(), userDetailData.getEmail(), passwordEncoder.encode(userDetailData.getPassword()), "USER");
        userAuthDetailDAO.save(userAuthDetailPO);
    }

    @Override
    public UserAuthDetailPO loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAuthDetailDAO.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not Found"));
    }
}
