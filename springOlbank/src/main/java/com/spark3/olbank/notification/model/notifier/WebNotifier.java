package com.spark3.olbank.notification.model.notifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebNotifier implements INotifier {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void sendNotification() {
       // simpMessagingTemplate.convertAndSendToUser();
    }

    @Override
    public void run() {

    }
}
