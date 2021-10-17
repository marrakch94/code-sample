package com.spark3.olbank.forum.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "temps")
@NoArgsConstructor
@Getter
@Setter
public class Temps {
    @Id
    @Temporal(TemporalType.DATE)
    private Date tempsDate;
    private int yearMonth;
    private int tempsMonth;
    private int tempsYear;
    private String tempsStringMonth;
    private String tempsStringDay;
}
