package com.spark3.olbank.notification.service;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

public class ScheduleTaskService {

    // Task Scheduler
    TaskScheduler scheduler;

    // A map for keeping scheduled tasks
    Map<Integer, ScheduledFuture<?>> jobsMap = new HashMap<>();

    public ScheduleTaskService(TaskScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void addTaskToScheduler(int id, Runnable task, CronTrigger cron) {
        ScheduledFuture<?> scheduledTask = scheduler.schedule(task, cron);
        jobsMap.put(id, scheduledTask);
    }

    public void removeTaskFromScheduler(int id) {
        ScheduledFuture<?> scheduledTask = jobsMap.get(id);
        if(scheduledTask != null) {
            scheduledTask.cancel(true);
            jobsMap.put(id, null);
        }
    }

    @EventListener({ ContextRefreshedEvent.class })
    void contextRefreshedEvent() {
        // TODO: Get all tasks from DB and reschedule them in case of context restarted
    }
}
