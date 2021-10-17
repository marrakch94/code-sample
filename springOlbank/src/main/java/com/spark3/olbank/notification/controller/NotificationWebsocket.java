package com.spark3.olbank.notification.controller;

import com.spark3.olbank.notification.model.NotificationQueue;
import com.spark3.olbank.notification.model.TempUser;
import com.spark3.olbank.notification.service.NotificationQueueService;
import com.spark3.olbank.notification.service.NotificationService;
import com.spark3.olbank.notification.util.ActiveUsersManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class NotificationWebsocket {

    @Autowired
    NotificationService notificationService;
    @Autowired
    NotificationQueueService notificationQueueService;
    @Autowired
    ActiveUsersManager activeUsersManager;
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/userSettings")
    @SendTo("/notifications")
    public List<NotificationQueue> greeting(@Payload TempUser userSettings, Principal p) throws Exception {
        System.out.println(p);
        System.out.println(activeUsersManager.getActiveUsers());
      //  messagingTemplate.convertAndSendToUser(headerAccessor.getUser().getName(), "/notifications", "test test");

        Thread.sleep(1000); // simulated delay
        return notificationQueueService.getAll().stream().filter(n -> n.getUserx().equals(userSettings.getName())).
                collect(Collectors.toList());
    }
}
