package com.spark3.olbank.notification.service;

import com.spark3.olbank.notification.model.NotificationDef;
import com.spark3.olbank.notification.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepo notificationRepo;

    @Override
    public NotificationDef getById(long id) {
        return notificationRepo.findById(id).get();
    }

    @Override
    public List<NotificationDef> getAll() {
        return StreamSupport
                .stream(notificationRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<NotificationDef> getByIds(List<Long> ids) {
        return StreamSupport
                .stream(notificationRepo.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public NotificationDef save(NotificationDef notificationDef) {
        return notificationRepo.save(notificationDef);
    }

    @Override
    public void deleteById(long id) {
        notificationRepo.deleteById(id);
    }

}
