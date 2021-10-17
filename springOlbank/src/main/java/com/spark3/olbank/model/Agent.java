package com.spark3.olbank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "agent")
@Getter
@Setter
@AllArgsConstructor
public class Agent {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long userId;
    private String job;
    private String job_Tasks;

    @ManyToOne
    // @JoinColumn(name="agencyId",referencedColumnName="agencyId")
    // @JsonIgnoreProperties("listAgencies")
    private Agency agency;

    public Agent() {
    }


}