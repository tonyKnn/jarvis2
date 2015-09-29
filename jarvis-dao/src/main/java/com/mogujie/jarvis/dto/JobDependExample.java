package com.mogujie.jarvis.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobDependExample {
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database table
     * job_depend
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database table
     * job_depend
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database table
     * job_depend
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * job_depend
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    public JobDependExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * job_depend
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * job_depend
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * job_depend
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * job_depend
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * job_depend
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * job_depend
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * job_depend
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * job_depend
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * job_depend
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table
     * job_depend
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator. This class corresponds to the database table
     * job_depend
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andJobIdIsNull() {
            addCriterion("jobId is null");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNotNull() {
            addCriterion("jobId is not null");
            return (Criteria) this;
        }

        public Criteria andJobIdEqualTo(Long value) {
            addCriterion("jobId =", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotEqualTo(Long value) {
            addCriterion("jobId <>", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThan(Long value) {
            addCriterion("jobId >", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThanOrEqualTo(Long value) {
            addCriterion("jobId >=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThan(Long value) {
            addCriterion("jobId <", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThanOrEqualTo(Long value) {
            addCriterion("jobId <=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdIn(List<Long> values) {
            addCriterion("jobId in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotIn(List<Long> values) {
            addCriterion("jobId not in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdBetween(Long value1, Long value2) {
            addCriterion("jobId between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotBetween(Long value1, Long value2) {
            addCriterion("jobId not between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andPreJobIdIsNull() {
            addCriterion("preJobId is null");
            return (Criteria) this;
        }

        public Criteria andPreJobIdIsNotNull() {
            addCriterion("preJobId is not null");
            return (Criteria) this;
        }

        public Criteria andPreJobIdEqualTo(Long value) {
            addCriterion("preJobId =", value, "preJobId");
            return (Criteria) this;
        }

        public Criteria andPreJobIdNotEqualTo(Long value) {
            addCriterion("preJobId <>", value, "preJobId");
            return (Criteria) this;
        }

        public Criteria andPreJobIdGreaterThan(Long value) {
            addCriterion("preJobId >", value, "preJobId");
            return (Criteria) this;
        }

        public Criteria andPreJobIdGreaterThanOrEqualTo(Long value) {
            addCriterion("preJobId >=", value, "preJobId");
            return (Criteria) this;
        }

        public Criteria andPreJobIdLessThan(Long value) {
            addCriterion("preJobId <", value, "preJobId");
            return (Criteria) this;
        }

        public Criteria andPreJobIdLessThanOrEqualTo(Long value) {
            addCriterion("preJobId <=", value, "preJobId");
            return (Criteria) this;
        }

        public Criteria andPreJobIdIn(List<Long> values) {
            addCriterion("preJobId in", values, "preJobId");
            return (Criteria) this;
        }

        public Criteria andPreJobIdNotIn(List<Long> values) {
            addCriterion("preJobId not in", values, "preJobId");
            return (Criteria) this;
        }

        public Criteria andPreJobIdBetween(Long value1, Long value2) {
            addCriterion("preJobId between", value1, value2, "preJobId");
            return (Criteria) this;
        }

        public Criteria andPreJobIdNotBetween(Long value1, Long value2) {
            addCriterion("preJobId not between", value1, value2, "preJobId");
            return (Criteria) this;
        }

        public Criteria andCommonStrategyIsNull() {
            addCriterion("commonStrategy is null");
            return (Criteria) this;
        }

        public Criteria andCommonStrategyIsNotNull() {
            addCriterion("commonStrategy is not null");
            return (Criteria) this;
        }

        public Criteria andCommonStrategyEqualTo(Integer value) {
            addCriterion("commonStrategy =", value, "commonStrategy");
            return (Criteria) this;
        }

        public Criteria andCommonStrategyNotEqualTo(Integer value) {
            addCriterion("commonStrategy <>", value, "commonStrategy");
            return (Criteria) this;
        }

        public Criteria andCommonStrategyGreaterThan(Integer value) {
            addCriterion("commonStrategy >", value, "commonStrategy");
            return (Criteria) this;
        }

        public Criteria andCommonStrategyGreaterThanOrEqualTo(Integer value) {
            addCriterion("commonStrategy >=", value, "commonStrategy");
            return (Criteria) this;
        }

        public Criteria andCommonStrategyLessThan(Integer value) {
            addCriterion("commonStrategy <", value, "commonStrategy");
            return (Criteria) this;
        }

        public Criteria andCommonStrategyLessThanOrEqualTo(Integer value) {
            addCriterion("commonStrategy <=", value, "commonStrategy");
            return (Criteria) this;
        }

        public Criteria andCommonStrategyIn(List<Integer> values) {
            addCriterion("commonStrategy in", values, "commonStrategy");
            return (Criteria) this;
        }

        public Criteria andCommonStrategyNotIn(List<Integer> values) {
            addCriterion("commonStrategy not in", values, "commonStrategy");
            return (Criteria) this;
        }

        public Criteria andCommonStrategyBetween(Integer value1, Integer value2) {
            addCriterion("commonStrategy between", value1, value2, "commonStrategy");
            return (Criteria) this;
        }

        public Criteria andCommonStrategyNotBetween(Integer value1, Integer value2) {
            addCriterion("commonStrategy not between", value1, value2, "commonStrategy");
            return (Criteria) this;
        }

        public Criteria andOffsetStrategyIsNull() {
            addCriterion("offsetStrategy is null");
            return (Criteria) this;
        }

        public Criteria andOffsetStrategyIsNotNull() {
            addCriterion("offsetStrategy is not null");
            return (Criteria) this;
        }

        public Criteria andOffsetStrategyEqualTo(String value) {
            addCriterion("offsetStrategy =", value, "offsetStrategy");
            return (Criteria) this;
        }

        public Criteria andOffsetStrategyNotEqualTo(String value) {
            addCriterion("offsetStrategy <>", value, "offsetStrategy");
            return (Criteria) this;
        }

        public Criteria andOffsetStrategyGreaterThan(String value) {
            addCriterion("offsetStrategy >", value, "offsetStrategy");
            return (Criteria) this;
        }

        public Criteria andOffsetStrategyGreaterThanOrEqualTo(String value) {
            addCriterion("offsetStrategy >=", value, "offsetStrategy");
            return (Criteria) this;
        }

        public Criteria andOffsetStrategyLessThan(String value) {
            addCriterion("offsetStrategy <", value, "offsetStrategy");
            return (Criteria) this;
        }

        public Criteria andOffsetStrategyLessThanOrEqualTo(String value) {
            addCriterion("offsetStrategy <=", value, "offsetStrategy");
            return (Criteria) this;
        }

        public Criteria andOffsetStrategyLike(String value) {
            addCriterion("offsetStrategy like", value, "offsetStrategy");
            return (Criteria) this;
        }

        public Criteria andOffsetStrategyNotLike(String value) {
            addCriterion("offsetStrategy not like", value, "offsetStrategy");
            return (Criteria) this;
        }

        public Criteria andOffsetStrategyIn(List<String> values) {
            addCriterion("offsetStrategy in", values, "offsetStrategy");
            return (Criteria) this;
        }

        public Criteria andOffsetStrategyNotIn(List<String> values) {
            addCriterion("offsetStrategy not in", values, "offsetStrategy");
            return (Criteria) this;
        }

        public Criteria andOffsetStrategyBetween(String value1, String value2) {
            addCriterion("offsetStrategy between", value1, value2, "offsetStrategy");
            return (Criteria) this;
        }

        public Criteria andOffsetStrategyNotBetween(String value1, String value2) {
            addCriterion("offsetStrategy not between", value1, value2, "offsetStrategy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("updateUser is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("updateUser is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("updateUser =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("updateUser <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("updateUser >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("updateUser >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("updateUser <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("updateUser <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("updateUser like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("updateUser not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("updateUser in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("updateUser not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("updateUser between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("updateUser not between", value1, value2, "updateUser");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator. This class corresponds to the database table
     * job_depend
     *
     * @mbggenerated do_not_delete_during_merge Mon Sep 28 17:40:28 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator. This class corresponds to the database table
     * job_depend
     *
     * @mbggenerated Mon Sep 28 17:40:28 CST 2015
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}