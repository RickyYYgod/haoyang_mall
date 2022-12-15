package com.hsbiopharm.mall.service;


import com.hsbiopharm.mall.pojo.AdminUser;

public interface AdminUserService {

    AdminUser login(String phone, String password);

    /**
     * 获取用户信息
     *
     * @param adminUserId
     * @return
     */
    AdminUser getUserDetailById(Integer adminUserId);

    /**
     * 修改当前登录用户的密码
     *
     * @param loginUserId
     * @param originalPassword
     * @param newPassword
     * @return
     */
    Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword);

    /**
     * 修改当前登录用户的名称信息
     *
     * @param loginUserId
     * @param loginUserName
     * @param nickName
     * @return
     */
    Boolean updateName(Integer loginUserId, String loginUserName, String nickName);

}
