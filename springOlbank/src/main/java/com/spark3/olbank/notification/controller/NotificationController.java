package com.spark3.olbank.notification.controller;

import com.spark3.olbank.notification.model.NotificationDef;
import com.spark3.olbank.notification.model.NotificationQueue;
import com.spark3.olbank.notification.service.NotificationQueueService;
import com.spark3.olbank.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @Autowired
    NotificationQueueService notificationQueueService;

    @GetMapping("addToQueue")
    public void testAddingToQueue(){
        NotificationDef n = new NotificationDef();
        n.setType("type1");
        n.setBody("body1");
        notificationService.save(n);
        NotificationQueue nq = new NotificationQueue();
        nq.setUserx("wassim");
        nq.setNotificationDef(n);
        notificationQueueService.save(nq);
    }

    @GetMapping("")
    public List<NotificationDef> getAll() {
        return notificationService.getAll();
    }

    @GetMapping("{id}")
    public NotificationDef getOne(@PathVariable("id") long id) {
        return notificationService.getById(id);
    }

    @PutMapping("")
    public NotificationDef update(@RequestBody NotificationDef notificationDef) {
        return notificationService.save(notificationDef);
    }

    @PostMapping("")
    public NotificationDef create(@RequestBody NotificationDef notificationDef) {
        return notificationService.save(notificationDef);
    }

    @DeleteMapping("{id}")
    public void deleteOne(@PathVariable("id") long id) {
         notificationService.deleteById(id);
    }


}
