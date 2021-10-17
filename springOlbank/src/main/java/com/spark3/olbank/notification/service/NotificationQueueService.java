package com.spark3.olbank.notification.service;

import com.spark3.olbank.notification.model.NotificationQueue;

import java.util.List;

public interface NotificationQueueService {

    NotificationQueue getById(long id);

    List<NotificationQueue> getAll();

    NotificationQueue save(NotificationQueue notificationQueue);

    void deleteById(long id);

}
