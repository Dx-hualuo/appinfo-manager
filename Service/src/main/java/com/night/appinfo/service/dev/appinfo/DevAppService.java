package com.night.appinfo.service.dev.appinfo;

import com.night.appinfo.entity.AppCategory;
import com.night.appinfo.entity.AppInfo;
import com.night.appinfo.entity.DataDictionary;
import com.night.appinfo.pojo.AppStatus;
import com.night.appinfo.util.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 *  开发者App管理Service
 * @author night
 */
public interface DevAppService {

    /**
     *  查询分页的App信息
     * @param info 查询条件
     * @param page 分页数据
     * @return List<AppInfo>
     */
    Page<AppInfo> queryAppInfoPagination(AppInfo info, Page<AppInfo> page);

    /**
     * 查询所有软件状态
     * @return DataDictionary
     */
    List<DataDictionary> queryAllAppStatus();

    /**
     * 查询所有软件平台
     * @return DataDictionary 集合
     */
    List<DataDictionary> queryAllAppFlatform();

    /**
     * 查询所有的一级分类
     * @return AppCategory 集合
     */
    List<AppCategory> queryAppCategoryLevel1();

    /**
     *  查询指定父级ID下的子分类
     * @param fatherId 父级Id
     * @return List<AppCategory>
     */
    List<AppCategory> queryAppCategoryListByFatherId(Long fatherId);

    /**
     *  更改App状态
     * @param id AppId
     * @return 是否成功
     */
    boolean changeAppStatus(Long id);

    /**
     *  判断指定ApkName名字在数据库中是否重复
     * @param apkName ApkName
     * @return 是否重复
     */
    boolean apkNameIsExist(String apkName);

    /**
     *  根据typeCode查询数据字典
     * @param typeCode 类型代码
     * @return List<DataDictionary>
     */
    List<DataDictionary> queryDataDictionaryByTypeCode(String typeCode);

    /**
     *  添加应用信息
     * @param appInfo 应用信息实体（前端数据）
     * @param logoFile 图标文件
     * @return 是否添加成功
     */
    boolean addAppInfo(AppInfo appInfo, MultipartFile logoFile);
}
