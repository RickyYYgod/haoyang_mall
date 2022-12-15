package com.hsbiopharm.mall.controller;

import com.hsbiopharm.mall.pojo.AdminUser;
import com.hsbiopharm.mall.service.AdminUserService;
import com.hsbiopharm.mall.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author dlq
 */
@RestController
@Api("登录控制类")
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminUserService adminUserService;

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ApiOperation(value = "后台登录", notes = "后台登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="phone",value="手机号",required=true,dataType="String"),
            @ApiImplicitParam(name="password",value="密码",required=true,dataType="String"),
            @ApiImplicitParam(name="verifyCode",value="验证码",required=true,dataType="String")
    })
    public Result login(@RequestParam("phone") String phone,
                        @RequestParam("password") String password,
                        @RequestParam("verifyCode") String verifyCode,
                        HttpSession session) {
        if (StringUtils.isEmpty(verifyCode)) {
            return Result.ok().data("验证码不能为空");
        }
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
            return Result.ok().data("手机号或密码不能为空");
        }
        String kaptchaCode = session.getAttribute("verifyCode") + "";
        if (StringUtils.isEmpty(kaptchaCode) || !verifyCode.equals(kaptchaCode)) {
            return Result.ok().data("验证码错误");
        }
        AdminUser adminUser = adminUserService.login(phone, password);
        if (adminUser != null) {
            session.setAttribute("phone", adminUser.getPhone());
            session.setAttribute("displayName", adminUser.getDisplayName());
            session.setAttribute("adminUserId", adminUser.getAdminUserId());
            //session过期时间设置为7200秒 即两小时
            session.setMaxInactiveInterval(60 * 60 * 2);
            return Result.ok().data("登录成功");
        } else {
            return Result.ok().data("登陆失败，请联系管理员");
        }
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET})
    @ApiOperation(value = "后台注销", notes = "后台注销")
    public Result logout(HttpServletRequest request) {
        request.getSession().removeAttribute("phone");
        request.getSession().removeAttribute("displayName");
        request.getSession().removeAttribute("adminUserId");
        return Result.ok().data("注销成功");
    }

    @RequestMapping(value = "/profile", method = {RequestMethod.GET})
    @ApiOperation(value = "查询用户信息", notes = "查询用户信息")
    public Result profile(HttpServletRequest request) {
        Integer adminUserId = (int) request.getSession().getAttribute("adminUserId");
        AdminUser adminUser = adminUserService.getUserDetailById(adminUserId);
        if (adminUser == null) {
            return "admin/login";
        }
        request.setAttribute("path", "profile");
        request.setAttribute("loginUserName", adminUser.getLoginUserName());
        request.setAttribute("nickName", adminUser.getNickName());
        return "admin/profile";
    }

    @PostMapping("/profile/password")
    @ResponseBody
    public String passwordUpdate(HttpServletRequest request, @RequestParam("originalPassword") String originalPassword,
                                 @RequestParam("newPassword") String newPassword) {
        if (StringUtils.isEmpty(originalPassword) || StringUtils.isEmpty(newPassword)) {
            return "参数不能为空";
        }
        Integer loginUserId = (int) request.getSession().getAttribute("loginUserId");
        if (adminUserService.updatePassword(loginUserId, originalPassword, newPassword)) {
            //修改成功后清空session中的数据，前端控制跳转至登录页
            request.getSession().removeAttribute("loginUserId");
            request.getSession().removeAttribute("loginUser");
            request.getSession().removeAttribute("errorMsg");
            return ServiceResultEnum.SUCCESS.getResult();
        } else {
            return "修改失败";
        }
    }

    @PostMapping("/profile/name")
    @ResponseBody
    public String nameUpdate(HttpServletRequest request, @RequestParam("loginUserName") String loginUserName,
                             @RequestParam("nickName") String nickName) {
        if (StringUtils.isEmpty(loginUserName) || StringUtils.isEmpty(nickName)) {
            return "参数不能为空";
        }
        Integer loginUserId = (int) request.getSession().getAttribute("loginUserId");
        if (adminUserService.updateName(loginUserId, loginUserName, nickName)) {
            return ServiceResultEnum.SUCCESS.getResult();
        } else {
            return "修改失败";
        }
    }


}
