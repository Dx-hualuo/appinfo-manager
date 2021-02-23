package com.night.appinfo.controller.dev.user.interceptor;

import com.night.appinfo.entity.DevUser;
import com.night.appinfo.service.dev.user.DevUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  开发者用户拦截器
 * @author night
 */
public class DevUserInterceptor implements HandlerInterceptor {
    private static Logger logger = LogManager.getLogger(DevUserInterceptor.class);

    /**
     *  拦截所有未登录的开发者用户进行登录
     * @param request request
     * @param response response
     * @param handler handler
     * @return 是否继续执行请求
     * @throws Exception 可能发生的异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        DevUser loginUser = (DevUser)request.getSession().getAttribute(DevUserService.DEV_USER);
        if (loginUser == null) {
            logger.debug("IP:"+ request.getRemoteAddr()+"，未登录请求路径："+ request.getServletPath());
            response.sendRedirect(DevUserService.LOGIN_PATH);
            return false;
        }
        return true;
    }
}
