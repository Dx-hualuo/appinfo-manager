package com.night.appinfo.mapper.dev.appinfo;

import com.night.appinfo.entity.AppCategory;
import com.night.appinfo.entity.AppInfo;
import com.night.appinfo.entity.DataDictionary;
import com.night.appinfo.pojo.AppStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author xiaohuashen
 * @date 2020/12/7 12:13
 */
public interface AppInfoDao {

    /**
     *  查询全部queryAllApp
     * @param map map
     * @return A
     */
    List<AppInfo> queryAllApp(Map<String, Object> map);

    /**
     *  查询指定类型代码下的所有字典数据
     * @param typeCode 类型代码
     * @return List<DataDictionary>
     */
    List<DataDictionary> queryDataDictionaryByTypeCode(@Param("typeCode") String typeCode);

    /**
     *  查询指定一级分类下二级分类
     * @param parentId 一级分类id
     * @return AppCategory 集合
     */
    List<AppCategory> queryAppCategoryByParentId(@Param("parentId") Long parentId);

    /**
     *  查询指定App状态
     * @param id AppId
     * @return AppStatus Pojo
     */
    AppStatus queryAppStatus(@Param("id") Long id);

    /**
     *  更改App状态
     * @param id AppId
     * @param status 状态
     * @return 受影响行数
     */
    int updateAppStatus(@Param("id") Long id, @Param("status") Long status);

    /**
     *  查询指定ApkName的数据
     * @param apkName ApkName
     * @return List<AppInfo>
     */
    List<AppInfo> queryAppInfoByApkName(@Param("apkName")String apkName);
}
