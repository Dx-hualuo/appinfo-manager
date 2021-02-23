package com.night.appinfo.service.dev.user;

import com.night.appinfo.entity.DevUser;
import com.night.appinfo.exception.DaoException;
import com.night.appinfo.exception.ServiceException;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * @author xiao yao
 * @date 2020/12/5 12:09
 */
public interface DevUserService {
    /**
     *  开发者用户登录URL
     */
    String LOGIN_PATH = "/dev/user/toLogin";
    /**
     *  session中存User对象的名字
     */
    String DEV_USER = "dev_user";

    /**
     *  登录
     * @param devCode 开发者编号
     * @param devPassword 密码
     * @param devUser 当前登录用户（可为空）
     * @param model Model
     * @return controller返回值
     * @throws ServiceException ServiceException
     * @throws DaoException DaoException
     */
    String login(String devCode, String devPassword, DevUser devUser, Model model);

    /**
     *  登出指定Session中的用户
     * @param session HttpSession
     */
    void logout(HttpSession session);
}
