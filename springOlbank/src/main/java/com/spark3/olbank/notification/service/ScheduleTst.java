package com.spark3.olbank.notification.service;

import com.spark3.olbank.notification.util.ActiveUsersManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleTst {
    @Autowired
    SimpMessageSendingOperations messagingTemplate;

    @Autowired
    ActiveUsersManager activeUsersManager;

    @Autowired
    private SimpUserRegistry userRegistry;
/*
    @Scheduled(cron = "0/10 * * * * ?")
    public void scheduleTaskUsingCronExpression() {
        long now = System.currentTimeMillis() / 1000;
      //  System.out.println(userRegistry.getUsers());
         activeUsersManager.getActiveUsers().entrySet().forEach(e -> {
            System.out.println("send to user " + e.getKey());
            System.out.println(e.getValue());
            messagingTemplate.convertAndSendToUser(e.getValue(), "/notifications", "test test " + e.getKey());
        });
    } */
}
