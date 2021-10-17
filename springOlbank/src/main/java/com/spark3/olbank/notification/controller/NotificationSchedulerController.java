package com.spark3.olbank.notification.controller;

import com.spark3.olbank.notification.model.NotificationDef;
import com.spark3.olbank.notification.model.NotificationScheduler;
import com.spark3.olbank.notification.model.NotificationSchedulerDTO;
import com.spark3.olbank.notification.service.NotificationSchedulerService;
import com.spark3.olbank.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notificationScheduler")
public class NotificationSchedulerController {

    @Autowired
    NotificationSchedulerService notificationSchedulerService;

    @Autowired
    NotificationService notificationService;

    @GetMapping("")
    public List<NotificationScheduler> getAll() {
        return notificationSchedulerService.getAll();
    }

    @GetMapping("{id}")
    public NotificationScheduler getOne(@PathVariable("id") long id) {
        return notificationSchedulerService.getById(id);
    }

    @PutMapping("{id}")
    public NotificationScheduler update(
            @PathVariable("id") long id,
            @RequestBody NotificationSchedulerDTO notificationScheduler) {
        NotificationScheduler ns = notificationSchedulerService.getById(id);
        if (ns != null) {
            List<NotificationDef> notificationDefs = notificationService.getByIds(notificationScheduler.getNotifications());
            ns.setCron(notificationScheduler.getCron());
            ns.setNotifications(notificationDefs);
            return notificationSchedulerService.save(ns);
        }
        return null;
    }

    @PostMapping("")
    public NotificationScheduler create(@RequestBody NotificationSchedulerDTO notificationScheduler) {
        List<NotificationDef> notificationDefs = notificationService.getByIds(notificationScheduler.getNotifications());
        NotificationScheduler ns = new NotificationScheduler();
        ns.setCron(notificationScheduler.getCron());
        ns.setNotifications(notificationDefs);
        return notificationSchedulerService.save(ns);
    }

    @DeleteMapping("{id}")
    public void deleteOne(@PathVariable("id") long id) {
        notificationSchedulerService.deleteById(id);
    }
}
