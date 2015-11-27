/*
 * 蘑菇街 Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 *
 * Author: guangming
 * Create Date: 2015年9月10日 下午5:59:07
 */

package com.mogujie.jarvis.server.scheduler.dag;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Sets;
import com.mogujie.jarvis.server.scheduler.event.ScheduleEvent;
import com.mogujie.jarvis.server.scheduler.event.TimeReadyEvent;

/**
 * @author guangming
 *
 */
public class TestDAGSchedulerWithEvent extends TestSchedulerBase {
    private long jobAId = 1;
    private long jobBId = 2;
    private long jobCId = 3;
    private long taskAId = 1;
    private long taskBId = 2;
    private long taskCId = 3;
    private long t1 = 1000;
    private long t2 = 2000;
    private long t3 = 3000;

    /**
     *   A   B
     *    \ /
     *     C
     */
    @Test
    public void testHandleScheduleEvent1() throws Exception {
        jobGraph.addJob(jobAId, new DAGJob(jobAId, DAGJobType.TIME), null);
        jobGraph.addJob(jobBId, new DAGJob(jobBId, DAGJobType.TIME), null);
        jobGraph.addJob(jobCId, new DAGJob(jobCId, DAGJobType.DEPEND),
                Sets.newHashSet(jobAId, jobBId));
        Assert.assertEquals(1, jobGraph.getChildren(jobAId).size());
        Assert.assertEquals(jobCId, (long)jobGraph.getChildren(jobAId).get(0).getFirst());
        Assert.assertEquals(1, jobGraph.getChildren(jobBId).size());
        Assert.assertEquals(jobCId, (long)jobGraph.getChildren(jobBId).get(0).getFirst());
        Assert.assertEquals(2, jobGraph.getParents(jobCId).size());
        // schedule jobA
        ScheduleEvent scheduleEventA = new ScheduleEvent(jobAId, taskAId, t1);
        dagScheduler.handleScheduleEvent(scheduleEventA);
        Assert.assertEquals(0, taskScheduler.getReadyTable().size());
        // schedule jobB
        // pass the dependency check, start to schedule jobC
        ScheduleEvent scheduleEventB = new ScheduleEvent(jobBId, taskBId, t2);
        dagScheduler.handleScheduleEvent(scheduleEventB);
        Assert.assertEquals(1, taskScheduler.getReadyTable().size());
    }

    /**
     *     A
     *    / \
     *   B   C
     */
    @Test
    public void testHandleScheduleEvent2() throws Exception {
        jobGraph.addJob(jobAId, new DAGJob(jobAId, DAGJobType.TIME), null);
        jobGraph.addJob(jobBId, new DAGJob(jobBId, DAGJobType.DEPEND), Sets.newHashSet(jobAId));
        jobGraph.addJob(jobCId, new DAGJob(jobCId, DAGJobType.DEPEND), Sets.newHashSet(jobAId));
        Assert.assertEquals(2, jobGraph.getChildren(jobAId).size());
        Assert.assertEquals(1, jobGraph.getParents(jobBId).size());
        Assert.assertEquals(jobAId, (long)jobGraph.getParents(jobBId).get(0).getFirst());
        Assert.assertEquals(1, jobGraph.getParents(jobCId).size());
        Assert.assertEquals(jobAId, (long)jobGraph.getParents(jobCId).get(0).getFirst());
        // schedule jobA
        // pass the dependency check, start to schedule jobB and jobC
        ScheduleEvent scheduleEventA = new ScheduleEvent(jobAId, taskAId, t1);
        dagScheduler.handleScheduleEvent(scheduleEventA);
        Assert.assertEquals(2, taskScheduler.getReadyTable().size());
    }

    /**
     *     A
     *     |
     *     B
     *     |
     *     C
     */
    @Test
    public void testHandleScheduleEvent3() throws Exception {
        jobGraph.addJob(jobAId, new DAGJob(jobAId, DAGJobType.TIME), null);
        jobGraph.addJob(jobBId, new DAGJob(jobBId, DAGJobType.DEPEND), Sets.newHashSet(jobAId));
        jobGraph.addJob(jobCId, new DAGJob(jobCId, DAGJobType.DEPEND), Sets.newHashSet(jobBId));
        Assert.assertEquals(1, jobGraph.getParents(jobBId).size());
        Assert.assertEquals(jobAId, (long)jobGraph.getParents(jobBId).get(0).getFirst());
        Assert.assertEquals(1, jobGraph.getChildren(jobBId).size());
        Assert.assertEquals(jobCId, (long)jobGraph.getChildren(jobBId).get(0).getFirst());
        // schedule jobA
        // pass the dependency check, start to schedule jobB and jobC
        ScheduleEvent scheduleEventA = new ScheduleEvent(jobAId, taskAId, t1);
        dagScheduler.handleScheduleEvent(scheduleEventA);
        Assert.assertEquals(2, taskScheduler.getReadyTable().size());
    }

    /**
     *   A   B
     *    \ /
     *     C
     */
    @Test
    public void testHandleTimeReadyEvent1() throws Exception {
        jobGraph.addJob(jobAId, new DAGJob(jobAId, DAGJobType.TIME), null);
        jobGraph.addJob(jobBId, new DAGJob(jobBId, DAGJobType.TIME), null);
        jobGraph.addJob(jobCId, new DAGJob(jobCId, DAGJobType.DEPEND),
                Sets.newHashSet(jobAId, jobBId));
        Assert.assertEquals(1, jobGraph.getChildren(jobAId).size());
        Assert.assertEquals(jobCId, (long)jobGraph.getChildren(jobAId).get(0).getFirst());
        Assert.assertEquals(1, jobGraph.getChildren(jobBId).size());
        Assert.assertEquals(jobCId, (long)jobGraph.getChildren(jobBId).get(0).getFirst());
        Assert.assertEquals(2, jobGraph.getParents(jobCId).size());
        // jobA time ready
        TimeReadyEvent timeReadyEventA = new TimeReadyEvent(jobAId);
        dagScheduler.handleTimeReadyEvent(timeReadyEventA);
        Assert.assertEquals(1, taskScheduler.getReadyTable().size());
        // jobB time ready
        // pass the dependency check, start to schedule jobC
        TimeReadyEvent timeReadyEventB = new TimeReadyEvent(jobBId);
        dagScheduler.handleTimeReadyEvent(timeReadyEventB);
        Assert.assertEquals(3, taskScheduler.getReadyTable().size());
    }

    /**
     *     A
     *    / \
     *   B   C
     */
    @Test
    public void testHandleTimeReadyEvent2() throws Exception {
        jobGraph.addJob(jobAId, new DAGJob(jobAId, DAGJobType.TIME), null);
        jobGraph.addJob(jobBId, new DAGJob(jobBId, DAGJobType.DEPEND), Sets.newHashSet(jobAId));
        jobGraph.addJob(jobCId, new DAGJob(jobCId, DAGJobType.DEPEND), Sets.newHashSet(jobAId));
        Assert.assertEquals(2, jobGraph.getChildren(jobAId).size());
        Assert.assertEquals(1, jobGraph.getParents(jobBId).size());
        Assert.assertEquals(jobAId, (long)jobGraph.getParents(jobBId).get(0).getFirst());
        Assert.assertEquals(1, jobGraph.getParents(jobCId).size());
        Assert.assertEquals(jobAId, (long)jobGraph.getParents(jobCId).get(0).getFirst());
        // jobA time ready
        // pass the dependency check, start to schedule jobB and jobC
        TimeReadyEvent timeReadyEventA = new TimeReadyEvent(jobAId);
        dagScheduler.handleTimeReadyEvent(timeReadyEventA);
        Assert.assertEquals(3, taskScheduler.getReadyTable().size());
    }

    /**
     *     A
     *     |
     *     B
     *     |
     *     C
     */
    @Test
    public void testHandleTimeReadyEvent3() throws Exception {
        jobGraph.addJob(jobAId, new DAGJob(jobAId, DAGJobType.TIME), null);
        jobGraph.addJob(jobBId, new DAGJob(jobBId, DAGJobType.DEPEND), Sets.newHashSet(jobAId));
        jobGraph.addJob(jobCId, new DAGJob(jobCId, DAGJobType.DEPEND), Sets.newHashSet(jobBId));
        Assert.assertEquals(1, jobGraph.getParents(jobBId).size());
        Assert.assertEquals(jobAId, (long)jobGraph.getParents(jobBId).get(0).getFirst());
        Assert.assertEquals(1, jobGraph.getChildren(jobBId).size());
        Assert.assertEquals(jobCId, (long)jobGraph.getChildren(jobBId).get(0).getFirst());
        // jobA time ready
        // pass the dependency check, start to schedule jobB and jobC
        TimeReadyEvent timeReadyEventA = new TimeReadyEvent(jobAId);
        dagScheduler.handleTimeReadyEvent(timeReadyEventA);
        Assert.assertEquals(3, taskScheduler.getReadyTable().size());
    }

}