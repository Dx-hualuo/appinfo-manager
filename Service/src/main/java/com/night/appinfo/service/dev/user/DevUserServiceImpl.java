package com.night.appinfo.service.dev.user;

import com.night.appinfo.mapper.dev.user.DevUserDao;
import com.night.appinfo.entity.DevUser;
import com.night.appinfo.exception.DaoException;
import com.night.appinfo.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *  开发者用户服务
 * @author night
 * @date 2020/12/5 12:16
 */
@Service
public class DevUserServiceImpl implements DevUserService {
    @Autowired
    DevUserDao devUserDao;

    /**
     *  登录
     * @param devCode 用户名
     * @param devPassword 密码
     * @return DevUser
     * @throws ServiceException ServiceException
     * @throws DaoException DaoException
     */
    @Override
    @Transactional(readOnly = true)
    public String login(String devCode, String devPassword, DevUser user, Model model) {
        //如果已经登录就重定向到开发者主页
        if (user != null) {
            return "redirect:/dev/main";
        }else{
            //进行登录验证
            DevUser devUser = new DevUser();
            devUser.setDevCode(devCode);
            devUser.setDevPassword(devPassword);
            List<DevUser> devUsers = devUserDao.queryDevUser(devUser);
            DevUser loginUser = null;
            if(devUsers.size() == 1){
                loginUser = devUsers.get(0);
            }
            if(loginUser != null){
                //将通过登录验证的用户塞入Session
                model.addAttribute(DevUserService.DEV_USER, loginUser);
                return "redirect:/dev/main";
            }else{
                model.addAttribute("error","用户名或密码错误！");
                return "devlogin";
            }
        }
    }

    /**
     *  登出
     * @param session HttpSession
     */
    @Override
    public void logout(HttpSession session) {
        //将session中的User移除
        session.removeAttribute(DevUserService.DEV_USER);
    }
}
