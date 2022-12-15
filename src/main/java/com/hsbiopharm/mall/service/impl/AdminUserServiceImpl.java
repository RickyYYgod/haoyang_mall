package com.hsbiopharm.mall.service.impl;

import com.hsbiopharm.mall.AdminUserRepository;
import com.hsbiopharm.mall.pojo.AdminUser;
import com.hsbiopharm.mall.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserRepository adminUserRepository;


    @Override
    public AdminUser login(String phone, String password) {
        return adminUserRepository.findByPhoneAndPassword(phone, password);
    }

    @Override
    public AdminUser getUserDetailById(Integer loginUserId) {
        return null;
    }

    @Override
    public Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword) {
        return null;
    }

    @Override
    public Boolean updateName(Integer loginUserId, String loginUserName, String nickName) {
        return null;
    }
}
