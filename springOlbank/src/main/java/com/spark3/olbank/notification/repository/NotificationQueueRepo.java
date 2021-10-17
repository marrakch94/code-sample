package com.spark3.olbank.notification.repository;

import com.spark3.olbank.notification.model.NotificationQueue;
import org.springframework.data.repository.CrudRepository;

public interface NotificationQueueRepo extends CrudRepository<NotificationQueue, Long> {
}
