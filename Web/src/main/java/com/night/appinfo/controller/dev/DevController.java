package com.night.appinfo.controller.dev;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * DevController
 * @author night
 * @date 2020/12/15 20:53
 */
@Controller
public class DevController{
    /**
     *  进入开发者控制台
     * @param session HttpSession
     * @return 开发者jsp
     */
    @RequestMapping("/dev/main")
    public String toMain(HttpSession session){
        return "developer/main";
    }
}
