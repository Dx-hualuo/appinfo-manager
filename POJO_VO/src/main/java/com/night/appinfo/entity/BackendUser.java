package com.night.appinfo.entity;


import java.sql.Timestamp;
import java.util.StringJoiner;

/**
 * @author night
 */
public class BackendUser {
  private Long id;
  private String userCode;
  private String userName;
  private Long userType;
  private Long createdBy;
  private java.sql.Timestamp creationDate;
  private Long modifyBy;
  private java.sql.Timestamp modifyDate;
  private String userPassword;

  public Long getId() {
    return id;
  }

  public BackendUser setId(Long id) {
    this.id = id;
    return this;
  }

  public String getUserCode() {
    return userCode;
  }

  public BackendUser setUserCode(String userCode) {
    this.userCode = userCode;
    return this;
  }

  public String getUserName() {
    return userName;
  }

  public BackendUser setUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public Long getUserType() {
    return userType;
  }

  public BackendUser setUserType(Long userType) {
    this.userType = userType;
    return this;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public BackendUser setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  public Timestamp getCreationDate() {
    return creationDate;
  }

  public BackendUser setCreationDate(Timestamp creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  public Long getModifyBy() {
    return modifyBy;
  }

  public BackendUser setModifyBy(Long modifyBy) {
    this.modifyBy = modifyBy;
    return this;
  }

  public Timestamp getModifyDate() {
    return modifyDate;
  }

  public BackendUser setModifyDate(Timestamp modifyDate) {
    this.modifyDate = modifyDate;
    return this;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public BackendUser setUserPassword(String userPassword) {
    this.userPassword = userPassword;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", BackendUser.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("userCode='" + userCode + "'")
            .add("userName='" + userName + "'")
            .add("userType=" + userType)
            .add("createdBy=" + createdBy)
            .add("creationDate=" + creationDate)
            .add("modifyBy=" + modifyBy)
            .add("modifyDate=" + modifyDate)
            .add("userPassword='" + userPassword + "'")
            .toString();
  }
}
