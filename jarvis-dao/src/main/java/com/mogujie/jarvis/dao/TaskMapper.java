package com.mogujie.jarvis.dao;

import com.mogujie.jarvis.dto.Task;
import com.mogujie.jarvis.dto.TaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskMapper {
    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * task
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    int countByExample(TaskExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * task
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    int deleteByExample(TaskExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * task
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    int deleteByPrimaryKey(Long taskId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * task
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    int insert(Task record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * task
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    int insertSelective(Task record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * task
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    List<Task> selectByExample(TaskExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * task
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    Task selectByPrimaryKey(Long taskId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * task
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * task
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * task
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    int updateByPrimaryKeySelective(Task record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * task
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    int updateByPrimaryKey(Task record);
}