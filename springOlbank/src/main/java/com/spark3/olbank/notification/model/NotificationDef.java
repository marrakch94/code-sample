package com.spark3.olbank.notification.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NotificationDef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String body;
    private String type;
    /*  @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;*/
   // private List<String> targets; // may remove

}
