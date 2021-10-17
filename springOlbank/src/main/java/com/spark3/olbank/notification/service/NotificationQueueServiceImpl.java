package com.spark3.olbank.notification.service;

import com.spark3.olbank.notification.model.NotificationQueue;
import com.spark3.olbank.notification.repository.NotificationQueueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NotificationQueueServiceImpl implements NotificationQueueService {

    @Autowired
    NotificationQueueRepo notificationQueueRepo;

    @Override
    public NotificationQueue getById(long id) {
        return notificationQueueRepo.findById(id).get();
    }

    @Override
    public List<NotificationQueue> getAll() {
        return StreamSupport
                .stream(notificationQueueRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public NotificationQueue save(NotificationQueue notificationQueue) {
        return notificationQueueRepo.save(notificationQueue);
    }

    @Override
    public void deleteById(long id) {
        notificationQueueRepo.deleteById(id);
    }

}
