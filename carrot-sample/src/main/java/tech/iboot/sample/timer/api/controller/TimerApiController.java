package tech.iboot.sample.timer.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.iboot.commons.quartz.service.QuartzService;
import tech.iboot.sample.timer.job.TimeTask;

/**
 * @author luohong
 * @date 2021/1/6
 */
@RestController
@RequestMapping("/api/sample")
public class TimerApiController {
    @Autowired
    private QuartzService quartzService;
    @SuppressWarnings("Duplicates")
    @GetMapping("/add")
    public void startTime() throws Exception {
        String name = TimeTask.class.getName();
        String group = TimeTask.class.getPackage().getName();
        String time = "*/5 * * * * ?";
        quartzService.addJob(name,group, TimeTask.class,  time);
    }
    @SuppressWarnings("Duplicates")
    @GetMapping("/delete")
    public void delete() throws Exception {
        String name = TimeTask.class.getName();
        String group = TimeTask.class.getPackage().getName();
        quartzService.deleteJob(name,group);
    }
}
