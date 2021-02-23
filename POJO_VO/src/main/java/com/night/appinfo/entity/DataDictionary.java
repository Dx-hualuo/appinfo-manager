package com.night.appinfo.entity;


import java.sql.Timestamp;
import java.util.StringJoiner;

/**
 * @author night
 */
public class DataDictionary {
  private Long id;
  private String typeCode;
  private String typeName;
  private Long valueId;
  private String valueName;
  private Long createdBy;
  private java.sql.Timestamp creationDate;
  private Long modifyBy;
  private java.sql.Timestamp modifyDate;

  public Long getId() {
    return id;
  }

  public DataDictionary setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTypeCode() {
    return typeCode;
  }

  public DataDictionary setTypeCode(String typeCode) {
    this.typeCode = typeCode;
    return this;
  }

  public String getTypeName() {
    return typeName;
  }

  public DataDictionary setTypeName(String typeName) {
    this.typeName = typeName;
    return this;
  }

  public Long getValueId() {
    return valueId;
  }

  public DataDictionary setValueId(Long valueId) {
    this.valueId = valueId;
    return this;
  }

  public String getValueName() {
    return valueName;
  }

  public DataDictionary setValueName(String valueName) {
    this.valueName = valueName;
    return this;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public DataDictionary setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  public Timestamp getCreationDate() {
    return creationDate;
  }

  public DataDictionary setCreationDate(Timestamp creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  public Long getModifyBy() {
    return modifyBy;
  }

  public DataDictionary setModifyBy(Long modifyBy) {
    this.modifyBy = modifyBy;
    return this;
  }

  public Timestamp getModifyDate() {
    return modifyDate;
  }

  public DataDictionary setModifyDate(Timestamp modifyDate) {
    this.modifyDate = modifyDate;
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", DataDictionary.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("typeCode='" + typeCode + "'")
            .add("typeName='" + typeName + "'")
            .add("valueId=" + valueId)
            .add("valueName='" + valueName + "'")
            .add("createdBy=" + createdBy)
            .add("creationDate=" + creationDate)
            .add("modifyBy=" + modifyBy)
            .add("modifyDate=" + modifyDate)
            .toString();
  }
}
