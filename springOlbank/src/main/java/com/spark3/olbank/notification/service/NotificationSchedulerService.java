package com.spark3.olbank.notification.service;

import com.spark3.olbank.notification.model.NotificationScheduler;

import java.util.List;

public interface NotificationSchedulerService {

    NotificationScheduler getById(long id);

    List<NotificationScheduler> getAll();

    NotificationScheduler save(NotificationScheduler NotificationScheduler);

    void deleteById(long id);
}
