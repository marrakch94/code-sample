package com.spark3.olbank.notification.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotificationSchedulerDTO {
    private List<Long> notifications;
    private String cron;
}
