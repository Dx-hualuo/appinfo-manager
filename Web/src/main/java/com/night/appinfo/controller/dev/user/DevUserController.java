package com.night.appinfo.controller.dev.user;

import com.night.appinfo.entity.DevUser;
import com.night.appinfo.service.dev.user.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 *  开发者平台入口
 * @author night
 */
@Controller
@SessionAttributes(DevUserService.DEV_USER)
public class DevUserController {
    /**
     *  DevUserService 注入
     */
    @Autowired
    private DevUserService userService;

    /**
     *  进入登录jsp
     * @return path
     */
    @RequestMapping(DevUserService.LOGIN_PATH)
    public String toLogin(){
        return "devlogin";
    }

    /**
     * 登录请求
     * @param model 返回的错误数据
     * @param devCode 用户代号
     * @param devPassword 密码
     * @param devUser 当前登录用户（可为空）
     * @return 根据结果跳转页面
     */
    @RequestMapping("/dev/user/login")
    public String login(Model model, String devCode, String devPassword, @SessionAttribute(value = DevUserService.DEV_USER, required = false) DevUser devUser){
       return userService.login(devCode, devPassword, devUser, model);
    }

    /**
     *  登出
     * @param session 用户Session
     * @return 登录页面
     */
    @RequestMapping("/dev/user/logout")
    public String logout(HttpSession session){
        userService.logout(session);
        return "redirect:"+DevUserService.LOGIN_PATH;
    }
}
