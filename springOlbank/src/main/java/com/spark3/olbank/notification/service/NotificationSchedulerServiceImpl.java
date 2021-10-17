package com.spark3.olbank.notification.service;

import com.spark3.olbank.notification.model.NotificationScheduler;
import com.spark3.olbank.notification.repository.NotificationSchedulerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NotificationSchedulerServiceImpl implements NotificationSchedulerService {

    @Autowired
    private NotificationSchedulerRepo notificationRepo;

    @Override
    public NotificationScheduler getById(long id) {
        return notificationRepo.findById(id).get();
    }

    @Override
    public List<NotificationScheduler> getAll() {
        return StreamSupport
                .stream(notificationRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public NotificationScheduler save(NotificationScheduler notificationScheduler) {
        return notificationRepo.save(notificationScheduler);
    }

    @Override
    public void deleteById(long id) {
        notificationRepo.deleteById(id);
    }
}
