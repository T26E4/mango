package com.louis.mango.admin.obj.dao;

import java.util.Date;

public class SysConfig {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_config.id
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_config.value
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    private String value;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_config.label
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    private String label;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_config.type
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_config.description
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_config.sort
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    private Long sort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_config.create_by
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    private String createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_config.create_time
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_config.last_update_by
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    private String lastUpdateBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_config.last_update_time
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_config.remarks
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    private String remarks;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_config.del_flag
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    private Byte delFlag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_config.id
     *
     * @return the value of sys_config.id
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_config.id
     *
     * @param id the value for sys_config.id
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_config.value
     *
     * @return the value of sys_config.value
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_config.value
     *
     * @param value the value for sys_config.value
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_config.label
     *
     * @return the value of sys_config.label
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public String getLabel() {
        return label;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_config.label
     *
     * @param label the value for sys_config.label
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_config.type
     *
     * @return the value of sys_config.type
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_config.type
     *
     * @param type the value for sys_config.type
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_config.description
     *
     * @return the value of sys_config.description
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_config.description
     *
     * @param description the value for sys_config.description
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_config.sort
     *
     * @return the value of sys_config.sort
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public Long getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_config.sort
     *
     * @param sort the value for sys_config.sort
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_config.create_by
     *
     * @return the value of sys_config.create_by
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_config.create_by
     *
     * @param createBy the value for sys_config.create_by
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_config.create_time
     *
     * @return the value of sys_config.create_time
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_config.create_time
     *
     * @param createTime the value for sys_config.create_time
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_config.last_update_by
     *
     * @return the value of sys_config.last_update_by
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_config.last_update_by
     *
     * @param lastUpdateBy the value for sys_config.last_update_by
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_config.last_update_time
     *
     * @return the value of sys_config.last_update_time
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_config.last_update_time
     *
     * @param lastUpdateTime the value for sys_config.last_update_time
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_config.remarks
     *
     * @return the value of sys_config.remarks
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_config.remarks
     *
     * @param remarks the value for sys_config.remarks
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_config.del_flag
     *
     * @return the value of sys_config.del_flag
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_config.del_flag
     *
     * @param delFlag the value for sys_config.del_flag
     *
     * @mbggenerated Mon May 10 11:10:44 CST 2021
     */
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }
}