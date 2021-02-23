package com.night.appinfo.service.dev.appinfo;

import com.night.appinfo.mapper.dev.appinfo.AppInfoDao;
import com.night.appinfo.entity.AppCategory;
import com.night.appinfo.entity.AppInfo;
import com.night.appinfo.entity.DataDictionary;
import com.night.appinfo.pojo.AppStatus;
import com.night.appinfo.util.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  开发者App管理Service实现
 * @author night
 * @date 2020/12/13 13:57
 */
@Service
public class DevAppServiceImpl implements DevAppService {
    /**
     *  DAO层注入
     */
    @Autowired
    private AppInfoDao appInfoDao;
    /**
     *  日志
     */
    private static final Logger logger = LogManager.getLogger(DevAppServiceImpl.class);

    @Override
    public Page<AppInfo> queryAppInfoPagination(AppInfo info, Page<AppInfo> page){
        Map<String,Object> map = new HashMap<>(10);
        map.put("appInfo", info);
        map.put("Page", page);
        page.setResultList(this.appInfoDao.queryAllApp(map));
        return page;
    }

    @Override
    public List<DataDictionary> queryAllAppStatus() {
        return this.queryDataDictionaryByTypeCode("APP_STATUS");
    }

    @Override
    public List<DataDictionary> queryAllAppFlatform() {
        return this.queryDataDictionaryByTypeCode("APP_FLATFORM");
    }

    @Override
    public List<AppCategory> queryAppCategoryLevel1() {
        return this.appInfoDao.queryAppCategoryByParentId(null);
    }

    @Override
    public List<AppCategory> queryAppCategoryListByFatherId(Long fatherId) {
        return appInfoDao.queryAppCategoryByParentId(fatherId);
    }

    @Override
    public boolean changeAppStatus(Long id) {
        try{
            //查询App状态
            AppStatus appStatus = appInfoDao.queryAppStatus(id);
            //反向更新App状态
            appInfoDao.updateAppStatus(id, appStatus.getChangeStatus());
        }catch (Exception e){
            logger.debug("更新AppStatus出错！",e);
        }
        return true;
    }

    @Override
    public boolean apkNameIsExist(String apkName) {
        List<AppInfo> appInfos = appInfoDao.queryAppInfoByApkName(apkName.trim());
        if(appInfos == null || appInfos.size() == 0){
            return false;
        }else if(appInfos.size() > 1){
            StringBuilder append = new StringBuilder().append(apkName).append("数据库中出现重名ApkName！").append("\n").append("id分别为[");
            for (AppInfo appInfo : appInfos) {
                append.append(appInfo.getId()).append(",");
            }
            append.append("]");
            logger.error(append);
        }
        return true;
    }

    @Override
    public List<DataDictionary> queryDataDictionaryByTypeCode(String typeCode) {
        return appInfoDao.queryDataDictionaryByTypeCode(typeCode);
    }

    @Override
    public boolean addAppInfo(AppInfo appInfo, MultipartFile logoFile) {
        return false;
    }
}
