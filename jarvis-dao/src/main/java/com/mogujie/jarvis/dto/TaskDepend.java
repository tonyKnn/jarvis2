package com.mogujie.jarvis.dto;

import java.io.Serializable;
import java.util.Date;

public class TaskDepend extends TaskDependKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_depend.createTime
     *
     * @mbggenerated Wed Nov 04 14:21:39 CST 2015
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table task_depend
     *
     * @mbggenerated Wed Nov 04 14:21:39 CST 2015
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_depend.createTime
     *
     * @return the value of task_depend.createTime
     *
     * @mbggenerated Wed Nov 04 14:21:39 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_depend.createTime
     *
     * @param createTime the value for task_depend.createTime
     *
     * @mbggenerated Wed Nov 04 14:21:39 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}