package com.spark3.olbank.notification.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NotificationScheduler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(targetEntity=NotificationDef.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "schedulers", referencedColumnName = "id")
    private List<NotificationDef> notifications = new ArrayList<>();

    // List<String> userTypes;
    // List<String> users;
    // String time;
    private String cron;

}
