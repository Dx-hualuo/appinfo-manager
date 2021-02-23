package com.night.appinfo.entity;


import java.sql.Timestamp;
import java.util.StringJoiner;

/**
 * @author night
 */
public class AppCategory {
  private Long id;
  private String categoryCode;
  private String categoryName;
  private Long parentId;
  private Long createdBy;
  private java.sql.Timestamp creationTime;
  private Long modifyBy;
  private java.sql.Timestamp modifyDate;

  public Long getId() {
    return id;
  }

  public AppCategory setId(Long id) {
    this.id = id;
    return this;
  }

  public String getCategoryCode() {
    return categoryCode;
  }

  public AppCategory setCategoryCode(String categoryCode) {
    this.categoryCode = categoryCode;
    return this;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public AppCategory setCategoryName(String categoryName) {
    this.categoryName = categoryName;
    return this;
  }

  public Long getParentId() {
    return parentId;
  }

  public AppCategory setParentId(Long parentId) {
    this.parentId = parentId;
    return this;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public AppCategory setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  public Timestamp getCreationTime() {
    return creationTime;
  }

  public AppCategory setCreationTime(Timestamp creationTime) {
    this.creationTime = creationTime;
    return this;
  }

  public Long getModifyBy() {
    return modifyBy;
  }

  public AppCategory setModifyBy(Long modifyBy) {
    this.modifyBy = modifyBy;
    return this;
  }

  public Timestamp getModifyDate() {
    return modifyDate;
  }

  public AppCategory setModifyDate(Timestamp modifyDate) {
    this.modifyDate = modifyDate;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", AppCategory.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("categoryCode='" + categoryCode + "'")
            .add("categoryName='" + categoryName + "'")
            .add("parentId=" + parentId)
            .add("createdBy=" + createdBy)
            .add("creationTime=" + creationTime)
            .add("modifyBy=" + modifyBy)
            .add("modifyDate=" + modifyDate)
            .toString();
  }
}
