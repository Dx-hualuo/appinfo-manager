package com.night.appinfo.entity;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.StringJoiner;

/**
 * @author night
 */
public class AppInfo {
  private Long id;
  private String softwareName;
  private String apkName;
  private String supportRom;
  private String interfaceLanguage;
  private Double softwareSize;
  private java.sql.Date updateDate;
  private Long devId;
  private String appInfo;
  private Long status;
  private java.sql.Timestamp onSaleDate;
  private java.sql.Timestamp offSaleDate;
  private Long flatformId;
  private Long categoryLevel3;
  private Long downloads;
  private Long createdBy;
  private java.sql.Timestamp creationDate;
  private Long modifyBy;
  private java.sql.Timestamp modifyDate;
  private Long categoryLevel1;
  private Long categoryLevel2;
  private String logoPicPath;
  private String logoLocPath;
  private Long versionId;
  private String flatformName;
  private String versionName;
  private String categoryName1;
  private String categoryName2;
  private String categoryName3;
  private String statusName;

  public Long getId() {
    return id;
  }

  public AppInfo setId(Long id) {
    this.id = id;
    return this;
  }

  public String getSoftwareName() {
    return softwareName;
  }

  public AppInfo setSoftwareName(String softwareName) {
    this.softwareName = softwareName;
    return this;
  }

  public String getApkName() {
    return apkName;
  }

  public AppInfo setApkName(String apkName) {
    this.apkName = apkName;
    return this;
  }

  public String getSupportRom() {
    return supportRom;
  }

  public AppInfo setSupportRom(String supportRom) {
    this.supportRom = supportRom;
    return this;
  }

  public String getInterfaceLanguage() {
    return interfaceLanguage;
  }

  public AppInfo setInterfaceLanguage(String interfaceLanguage) {
    this.interfaceLanguage = interfaceLanguage;
    return this;
  }

  public Double getSoftwareSize() {
    return softwareSize;
  }

  public AppInfo setSoftwareSize(Double softwareSize) {
    this.softwareSize = softwareSize;
    return this;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public AppInfo setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
    return this;
  }

  public Long getDevId() {
    return devId;
  }

  public AppInfo setDevId(Long devId) {
    this.devId = devId;
    return this;
  }

  public String getAppInfo() {
    return appInfo;
  }

  public AppInfo setAppInfo(String appInfo) {
    this.appInfo = appInfo;
    return this;
  }

  public Long getStatus() {
    return status;
  }

  public AppInfo setStatus(Long status) {
    this.status = status;
    return this;
  }

  public Timestamp getOnSaleDate() {
    return onSaleDate;
  }

  public AppInfo setOnSaleDate(Timestamp onSaleDate) {
    this.onSaleDate = onSaleDate;
    return this;
  }

  public Timestamp getOffSaleDate() {
    return offSaleDate;
  }

  public AppInfo setOffSaleDate(Timestamp offSaleDate) {
    this.offSaleDate = offSaleDate;
    return this;
  }

  public Long getFlatformId() {
    return flatformId;
  }

  public AppInfo setFlatformId(Long flatformId) {
    this.flatformId = flatformId;
    return this;
  }

  public Long getCategoryLevel3() {
    return categoryLevel3;
  }

  public AppInfo setCategoryLevel3(Long categoryLevel3) {
    this.categoryLevel3 = categoryLevel3;
    return this;
  }

  public Long getDownloads() {
    return downloads;
  }

  public AppInfo setDownloads(Long downloads) {
    this.downloads = downloads;
    return this;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public AppInfo setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  public Timestamp getCreationDate() {
    return creationDate;
  }

  public AppInfo setCreationDate(Timestamp creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  public Long getModifyBy() {
    return modifyBy;
  }

  public AppInfo setModifyBy(Long modifyBy) {
    this.modifyBy = modifyBy;
    return this;
  }

  public Timestamp getModifyDate() {
    return modifyDate;
  }

  public AppInfo setModifyDate(Timestamp modifyDate) {
    this.modifyDate = modifyDate;
    return this;
  }

  public Long getCategoryLevel1() {
    return categoryLevel1;
  }

  public AppInfo setCategoryLevel1(Long categoryLevel1) {
    this.categoryLevel1 = categoryLevel1;
    return this;
  }

  public Long getCategoryLevel2() {
    return categoryLevel2;
  }

  public AppInfo setCategoryLevel2(Long categoryLevel2) {
    this.categoryLevel2 = categoryLevel2;
    return this;
  }

  public String getLogoPicPath() {
    return logoPicPath;
  }

  public AppInfo setLogoPicPath(String logoPicPath) {
    this.logoPicPath = logoPicPath;
    return this;
  }

  public String getLogoLocPath() {
    return logoLocPath;
  }

  public AppInfo setLogoLocPath(String logoLocPath) {
    this.logoLocPath = logoLocPath;
    return this;
  }

  public Long getVersionId() {
    return versionId;
  }

  public AppInfo setVersionId(Long versionId) {
    this.versionId = versionId;
    return this;
  }

  public String getFlatformName() {
    return flatformName;
  }

  public AppInfo setFlatformName(String flatformName) {
    this.flatformName = flatformName;
    return this;
  }

  public String getVersionName() {
    return versionName;
  }

  public AppInfo setVersionName(String versionName) {
    this.versionName = versionName;
    return this;
  }

  public String getCategoryName1() {
    return categoryName1;
  }

  public AppInfo setCategoryName1(String categoryName1) {
    this.categoryName1 = categoryName1;
    return this;
  }

  public String getCategoryName2() {
    return categoryName2;
  }

  public AppInfo setCategoryName2(String categoryName2) {
    this.categoryName2 = categoryName2;
    return this;
  }

  public String getCategoryName3() {
    return categoryName3;
  }

  public AppInfo setCategoryName3(String categoryName3) {
    this.categoryName3 = categoryName3;
    return this;
  }

  public String getStatusName() {
    return statusName;
  }

  public AppInfo setStatusName(String statusName) {
    this.statusName = statusName;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", AppInfo.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("softwareName='" + softwareName + "'")
            .add("apkName='" + apkName + "'")
            .add("supportRom='" + supportRom + "'")
            .add("interfaceLanguage='" + interfaceLanguage + "'")
            .add("softwareSize=" + softwareSize)
            .add("updateDate=" + updateDate)
            .add("devId=" + devId)
            .add("appInfo='" + appInfo + "'")
            .add("status=" + status)
            .add("onSaleDate=" + onSaleDate)
            .add("offSaleDate=" + offSaleDate)
            .add("flatformId=" + flatformId)
            .add("categoryLevel3=" + categoryLevel3)
            .add("downloads=" + downloads)
            .add("createdBy=" + createdBy)
            .add("creationDate=" + creationDate)
            .add("modifyBy=" + modifyBy)
            .add("modifyDate=" + modifyDate)
            .add("categoryLevel1=" + categoryLevel1)
            .add("categoryLevel2=" + categoryLevel2)
            .add("logoPicPath='" + logoPicPath + "'")
            .add("logoLocPath='" + logoLocPath + "'")
            .add("versionId=" + versionId)
            .add("flatformName='" + flatformName + "'")
            .add("versionName='" + versionName + "'")
            .add("categoryName1='" + categoryName1 + "'")
            .add("categoryName2='" + categoryName2 + "'")
            .add("categoryName3='" + categoryName3 + "'")
            .add("statusName='" + statusName + "'")
            .toString();
  }
}
