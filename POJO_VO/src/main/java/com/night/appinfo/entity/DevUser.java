package com.night.appinfo.entity;

import java.sql.Timestamp;
import java.util.StringJoiner;

/**
 *  User实体类
 * @author night
 */
public class DevUser {
  private Long id;
  private String devCode;
  private String devName;
  private String devPassword;
  private String devEmail;
  private String devInfo;
  private Long createdBy;
  private java.sql.Timestamp creationDate;
  private Long modifyBy;
  private java.sql.Timestamp modifyDate;

  public Long getId() {
    return id;
  }

  public DevUser setId(Long id) {
    this.id = id;
    return this;
  }

  public String getDevCode() {
    return devCode;
  }

  public DevUser setDevCode(String devCode) {
    this.devCode = devCode;
    return this;
  }

  public String getDevName() {
    return devName;
  }

  public DevUser setDevName(String devName) {
    this.devName = devName;
    return this;
  }

  public String getDevPassword() {
    return devPassword;
  }

  public DevUser setDevPassword(String devPassword) {
    this.devPassword = devPassword;
    return this;
  }

  public String getDevEmail() {
    return devEmail;
  }

  public DevUser setDevEmail(String devEmail) {
    this.devEmail = devEmail;
    return this;
  }

  public String getDevInfo() {
    return devInfo;
  }

  public DevUser setDevInfo(String devInfo) {
    this.devInfo = devInfo;
    return this;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public DevUser setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  public Timestamp getCreationDate() {
    return creationDate;
  }

  public DevUser setCreationDate(Timestamp creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  public Long getModifyBy() {
    return modifyBy;
  }

  public DevUser setModifyBy(Long modifyBy) {
    this.modifyBy = modifyBy;
    return this;
  }

  public Timestamp getModifyDate() {
    return modifyDate;
  }

  public DevUser setModifyDate(Timestamp modifyDate) {
    this.modifyDate = modifyDate;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", DevUser.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("devCode='" + devCode + "'")
            .add("devName='" + devName + "'")
            .add("devPassword='" + devPassword + "'")
            .add("devEmail='" + devEmail + "'")
            .add("devInfo='" + devInfo + "'")
            .add("createdBy=" + createdBy)
            .add("creationDate=" + creationDate)
            .add("modifyBy=" + modifyBy)
            .add("modifyDate=" + modifyDate)
            .toString();
  }
}
