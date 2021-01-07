package tech.iboot.sample.timer.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author luohong
 * @date 2021/1/6
 */
public class TimeTask extends QuartzJobBean {
    private final Logger logger  = LoggerFactory.getLogger(getClass());
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("任务开始，任务时间：{}",new Date());
    }
}
