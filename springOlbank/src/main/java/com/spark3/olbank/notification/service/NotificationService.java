package com.spark3.olbank.notification.service;

import com.spark3.olbank.notification.model.NotificationDef;

import java.util.List;

public interface NotificationService {

    NotificationDef getById(long id);

    List<NotificationDef> getAll();

    List<NotificationDef> getByIds(List<Long> ids);

    NotificationDef save(NotificationDef notificationDef);

    void deleteById(long id);
}
