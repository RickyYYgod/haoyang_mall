package com.hsbiopharm.mall;

import com.hsbiopharm.mall.pojo.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser,Integer> {

    AdminUser findByPhoneAndPassword(String phone, String password);

}
