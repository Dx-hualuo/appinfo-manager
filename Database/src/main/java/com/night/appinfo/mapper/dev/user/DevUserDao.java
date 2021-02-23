package com.night.appinfo.mapper.dev.user;

import com.night.appinfo.entity.DevUser;
import com.night.appinfo.exception.DaoException;
import java.util.List;

/**
 * @author night
 * @date 2020/12/5 11:58
 */
public interface DevUserDao {
    /**
     * 查询全部开发者用户
     * @param devUser devUser
     * @return DevUser
     * @throws DaoException DaoException
     */
    List<DevUser> queryDevUser(DevUser devUser) throws DaoException;
}
