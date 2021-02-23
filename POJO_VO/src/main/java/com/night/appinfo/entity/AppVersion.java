package com.night.appinfo.entity;

import java.sql.Timestamp;
import java.util.StringJoiner;

/**
 * @author night
 */
public class AppVersion {
  private Long id;
  private Long appId;
  private String versionNo;
  private String versionInfo;
  private Long publishStatus;
  private String downloadLink;
  private Double versionSize;
  private Long createdBy;
  private java.sql.Timestamp creationDate;
  private Long modifyBy;
  private java.sql.Timestamp modifyDate;
  private String apkLocPath;
  private String apkFileName;

  public Long getId() {
    return id;
  }

  public AppVersion setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getAppId() {
    return appId;
  }

  public AppVersion setAppId(Long appId) {
    this.appId = appId;
    return this;
  }

  public String getVersionNo() {
    return versionNo;
  }

  public AppVersion setVersionNo(String versionNo) {
    this.versionNo = versionNo;
    return this;
  }

  public String getVersionInfo() {
    return versionInfo;
  }

  public AppVersion setVersionInfo(String versionInfo) {
    this.versionInfo = versionInfo;
    return this;
  }

  public Long getPublishStatus() {
    return publishStatus;
  }

  public AppVersion setPublishStatus(Long publishStatus) {
    this.publishStatus = publishStatus;
    return this;
  }

  public String getDownloadLink() {
    return downloadLink;
  }

  public AppVersion setDownloadLink(String downloadLink) {
    this.downloadLink = downloadLink;
    return this;
  }

  public Double getVersionSize() {
    return versionSize;
  }

  public AppVersion setVersionSize(Double versionSize) {
    this.versionSize = versionSize;
    return this;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public AppVersion setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  public Timestamp getCreationDate() {
    return creationDate;
  }

  public AppVersion setCreationDate(Timestamp creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  public Long getModifyBy() {
    return modifyBy;
  }

  public AppVersion setModifyBy(Long modifyBy) {
    this.modifyBy = modifyBy;
    return this;
  }

  public Timestamp getModifyDate() {
    return modifyDate;
  }

  public AppVersion setModifyDate(Timestamp modifyDate) {
    this.modifyDate = modifyDate;
    return this;
  }

  public String getApkLocPath() {
    return apkLocPath;
  }

  public AppVersion setApkLocPath(String apkLocPath) {
    this.apkLocPath = apkLocPath;
    return this;
  }

  public String getApkFileName() {
    return apkFileName;
  }

  public AppVersion setApkFileName(String apkFileName) {
    this.apkFileName = apkFileName;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", AppVersion.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("appId=" + appId)
            .add("versionNo='" + versionNo + "'")
            .add("versionInfo='" + versionInfo + "'")
            .add("publishStatus=" + publishStatus)
            .add("downloadLink='" + downloadLink + "'")
            .add("versionSize=" + versionSize)
            .add("createdBy=" + createdBy)
            .add("creationDate=" + creationDate)
            .add("modifyBy=" + modifyBy)
            .add("modifyDate=" + modifyDate)
            .add("apkLocPath='" + apkLocPath + "'")
            .add("apkFileName='" + apkFileName + "'")
            .toString();
  }
}
