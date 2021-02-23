package com.night.appinfo.vo;

import com.night.appinfo.entity.AppInfo;

import java.util.StringJoiner;

/**
 *  AppListParameter 前台参数类
 * @author night
 * @date  2020/12/15 19:06
 */
public class AppListParameter {
    private String querySoftwareName;
    private Long queryStatus;
    private Long queryFlatformId;
    private Long queryCategoryLevel1;
    private Long queryCategoryLevel2;
    private Long queryCategoryLevel3;

    public Long getQueryCategoryLevel1() {
        return queryCategoryLevel1;
    }

    public AppListParameter setQueryCategoryLevel1(Long queryCategoryLevel1) {
        this.queryCategoryLevel1 = queryCategoryLevel1;
        return this;
    }

    public Long getQueryCategoryLevel2() {
        return queryCategoryLevel2;
    }

    public AppListParameter setQueryCategoryLevel2(Long queryCategoryLevel2) {
        this.queryCategoryLevel2 = queryCategoryLevel2;
        return this;
    }

    public Long getQueryCategoryLevel3() {
        return queryCategoryLevel3;
    }

    public AppListParameter setQueryCategoryLevel3(Long queryCategoryLevel3) {
        this.queryCategoryLevel3 = queryCategoryLevel3;
        return this;
    }

    public String getQuerySoftwareName() {
        return querySoftwareName;
    }

    public AppListParameter setQuerySoftwareName(String querySoftwareName) {
        this.querySoftwareName = querySoftwareName;
        return this;
    }

    public Long getQueryStatus() {
        return queryStatus;
    }

    public AppListParameter setQueryStatus(Long queryStatus) {
        this.queryStatus = queryStatus;
        return this;
    }

    public Long getQueryFlatformId() {
        return queryFlatformId;
    }

    public AppListParameter setQueryFlatformId(Long queryFlatformId) {
        this.queryFlatformId = queryFlatformId;
        return this;
    }

    /**
     *  将前台参数填充至实体类
     * @param appInfo AppInfo 实体类
     */
    public void fullAppInfo(AppInfo appInfo){
        appInfo.setStatus(this.getQueryStatus());
        appInfo.setFlatformId(this.getQueryFlatformId());
        appInfo.setSoftwareName(this.getQuerySoftwareName() == null? null: "%"+this.getQuerySoftwareName()+"%");
        appInfo.setCategoryLevel1(this.getQueryCategoryLevel1());
        appInfo.setCategoryLevel2(this.getQueryCategoryLevel2());
        appInfo.setCategoryLevel3(this.getQueryCategoryLevel3());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AppListParameter.class.getSimpleName() + "[", "]")
                .add("querySoftwareName='" + querySoftwareName + "'")
                .add("queryStatus=" + queryStatus)
                .add("queryFlatformId=" + queryFlatformId)
                .toString();
    }
}
