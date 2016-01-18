package com.mogujie.jarvis.rest.utils;

import com.google.common.base.Preconditions;
import com.mogujie.jarvis.core.domain.*;
import com.mogujie.jarvis.core.expression.TimeOffsetExpression;
import com.mogujie.jarvis.core.util.ExpressionUtils;
import com.mogujie.jarvis.protocol.DependencyEntryProtos.DependencyEntry;
import com.mogujie.jarvis.protocol.ScheduleExpressionEntryProtos.ScheduleExpressionEntry;
import com.mogujie.jarvis.rest.vo.*;

import com.mogujie.jarvis.server.domain.CommonStrategy;
import com.mogujie.jarvis.server.domain.JobEntry;

import java.util.Arrays;

/**
 * 检验函数
 *
 * @author muming
 */

public class ConvertValidUtils {

    public enum CheckMode {
        ADD, //追加
        EDIT, //修改
        EDIT_STATUS, //修改_状态
        DELETE; //删除

        /**
         * 是否在scope中
         *
         * @param scope
         * @return
         */
        public Boolean isIn(CheckMode... scope) {

            for (CheckMode member : scope) {
                if (ordinal() == member.ordinal()) {
                    return true;
                }
            }
            return false;
        }

    }

    /**
     * @param job
     */
    public static void checkJob(CheckMode mode, JobEntryVo job) {

        //为空检查
        Long jobId = job.getJobId();
        Preconditions.checkArgument(!mode.isIn(CheckMode.EDIT,CheckMode.EDIT_STATUS) || jobId != null, "jobId不能为空");
        Preconditions.checkArgument(jobId == null ||jobId > 0, "jobId不能为空");

        String name = job.getJobName();
        Preconditions.checkArgument(mode != CheckMode.ADD || name != null, "jobName不能为空");
        Preconditions.checkArgument(name == null || !name.trim().equals(""), "jobName不能为空");

        String jobType = job.getJobType();
        Preconditions.checkArgument(mode != CheckMode.ADD || jobType != null, "jobType不能为空");
        Preconditions.checkArgument(jobType == null || !jobType.trim().equals(""), "jobType不能为空");

        Integer workerGroupId = job.getWorkerGroupId();
        Preconditions.checkArgument(mode != CheckMode.ADD || workerGroupId != null, "workGroupId不能为空");
        Preconditions.checkArgument(workerGroupId == null ||workerGroupId > 0, "workGroupId不能为空");

        String content = job.getContent();
        Preconditions.checkArgument(mode != CheckMode.ADD || content != null, "job内容不能为空");
        Preconditions.checkArgument(content == null || !content.trim().equals(""), "job内容不能为空");


        Integer status = job.getStatus();
        Preconditions.checkArgument(!mode.isIn(CheckMode.ADD,CheckMode.EDIT_STATUS) || status != null, "status不能为空");
        Preconditions.checkArgument(status == null || JobStatus.isValid(status), "status内容不正确。value:" + status);


        //内容检查
        Long start = job.getActiveStartTime();
        Long end = job.getActiveStartTime();
        if (start != null && end != null) {
            Preconditions.checkArgument(start <= end, "有效开始日不能大于有效结束日");
        }

    }



    /**
     * 计划表达式-转换
     *
     * @param input
     * @return
     */
    public static ScheduleExpressionEntry ConvertScheduleExpressionEntry(JobScheduleExpVo.ScheduleExpressionEntry input) {

        Integer mode = input.getOperatorMode();
        Preconditions.checkArgument(mode != null && OperationMode.isValid(mode), "操作模式不对");

        Long expressionId = input.getExpressionId() == null ? 0 : input.getExpressionId();
        if (mode == OperationMode.EDIT.getValue() || mode == OperationMode.DELETE.getValue()) {
            Preconditions.checkArgument(expressionId != 0, "删除与编辑模式下,计划表达式ID不能为空");
        }

        Integer expressType = input.getExpressionType();
        String expression = input.getExpression();
        //[追加]与[修改]模式下,计划表达式的内容要做检查
        if (mode == OperationMode.ADD.getValue() || mode == OperationMode.EDIT.getValue()) {
            ExpressionUtils.checkExpression(expressType, expression);
        }

        ScheduleExpressionEntry entry = ScheduleExpressionEntry.newBuilder()
                .setOperator(mode)
                .setExpressionId(expressionId)
                .setExpressionType(expressType == null ? 0 : expressType)
                .setScheduleExpression(expression == null ? "" : expression)
                .build();
        return entry;
    }

    /**
     * 依赖-转换
     *
     * @param input
     * @return
     */
    public static DependencyEntry ConvertDependencyEntry(JobDependencyVo.DependencyEntry input) {
        Integer mode = input.getOperatorMode();
        Preconditions.checkArgument(mode != null && OperationMode.isValid(mode), "操作模式不对.value:" + input.getOperatorMode());

        Long preJobId = input.getPreJobId();
        Preconditions.checkArgument(preJobId != null && preJobId != 0, "依赖JobId不能为空");

        Integer commonStrategy = input.getCommonStrategy();
        String offsetStrategy = input.getOffsetStrategy();

        if (mode == OperationMode.ADD.getValue() || mode == OperationMode.EDIT.getValue()) {
            Preconditions.checkArgument(commonStrategy != null, "依赖的通用策略不能为空.value:" + commonStrategy);
            Preconditions.checkArgument(CommonStrategy.isValid(commonStrategy), "依赖的通用策略不对.value:" + commonStrategy);

            Preconditions.checkArgument(offsetStrategy == null || offsetStrategy.equals("") || new TimeOffsetExpression(offsetStrategy).isValid()
                    , "依赖的偏移策略不对.value:" + input.getOffsetStrategy());
        }

        DependencyEntry entry = DependencyEntry.newBuilder()
                .setOperator(mode).setJobId(preJobId)
                .setCommonDependStrategy(commonStrategy == null ? 0 : commonStrategy)
                .setOffsetDependStrategy(offsetStrategy == null ? "" : offsetStrategy)
                .build();
        return entry;
    }

    /**
     * APP内容检查
     */
    public static void checkAppVo(OperationMode mode, String appName, String owner, Integer status, Integer maxConcurrency) {

        //追加模式
        if (mode == OperationMode.ADD) {
            Preconditions.checkArgument(appName != null && !appName.trim().equals(""), "appName不能为空");
            Preconditions.checkArgument(owner != null && !owner.trim().equals(""), "owner不能为空");
            Preconditions.checkArgument(status != null, "status不能为空");
            Preconditions.checkArgument(AppStatus.isValid(status), "status内容不对。value:" + status);
        }
        //编辑模式
        if (mode == OperationMode.EDIT) {
            Preconditions.checkArgument(appName == null || !appName.trim().equals(""), "appName不能为空");
            Preconditions.checkArgument(owner == null || !owner.trim().equals(""), "owner不能为空");
            Preconditions.checkArgument(status == null || AppStatus.isValid(status), "status内容不对。value:" + status);
        }
    }

    /**
     * alarm内容检查
     */
    public static void checkAlarm(OperationMode mode, AlarmVo vo) {

        Long jobId = vo.getJobId();
        Preconditions.checkArgument(!mode.isIn(OperationMode.ADD, OperationMode.EDIT, OperationMode.DELETE)
                || (jobId != null && jobId != 0), "jobId不能为空。");

        String type = vo.getAlarmType();
        Preconditions.checkArgument(!mode.isIn(OperationMode.ADD) || type != null, "alarmType不能为空。");
        Preconditions.checkArgument(type == null || AlarmType.isValid(type), "alarmType不对。value:" + type);

        Preconditions.checkArgument(!mode.isIn(OperationMode.ADD) || vo.getReceiver() != null, "receiver不能为空。");

        Integer status = vo.getStatus();
        Preconditions.checkArgument(!mode.isIn(OperationMode.ADD) || status != null, "status不能为空。");
        Preconditions.checkArgument(status == null || AlarmStatus.isValid(status), "status类型不对。 value:" + status);

    }

    /**
     * @param mode
     * @param bg
     */
    public static void checkBizGroup(CheckMode mode, BizGroupVo bg) throws IllegalArgumentException {

        Integer id = bg.getId();
        Preconditions.checkArgument(!mode.isIn(CheckMode.EDIT, CheckMode.DELETE)
                || (id != null && id != 0), "id is empty。 id:" + id);

        String name = bg.getName();
        Preconditions.checkArgument(!mode.isIn(CheckMode.ADD) || name != null, "name不能为空。");
        Preconditions.checkArgument(name == null || !name.trim().equals(""), "name不能为空。");

        Integer status = bg.getStatus();
        Preconditions.checkArgument(!mode.isIn(CheckMode.ADD) || status != null, "status不能为空。");
        Preconditions.checkArgument(status == null || BizGroupStatus.isValid(status), "status类型不对。value:" + status);

        String owner = bg.getOwner();
        Preconditions.checkArgument(!mode.isIn(CheckMode.ADD) || owner != null, "owner不能为空。");
        Preconditions.checkArgument(owner == null || !owner.trim().equals(""), "owner不能为空。");


    }


    /**
     * appWorkerGroup检查
     */
    public static void checkAppWorkerGroup(OperationMode mode, Integer appId, Integer workerGroupId)
            throws IllegalArgumentException {
        Preconditions.checkArgument((appId != null && appId != 0), "jobId不能为空。");
        Preconditions.checkArgument((workerGroupId != null && workerGroupId != 0), "workerGroupId不能为空。");
    }

    /**
     * alarm查询检查
     */
    public static void checkAlarmQuery(AlarmQueryVo vo) {
        String jobIds = vo.getJobIds();
    }


}
