package com.spark3.olbank.notification.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class NotificationQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userx;
    @OneToOne
    private NotificationDef notificationDef;
    private boolean isSent = false;
}
