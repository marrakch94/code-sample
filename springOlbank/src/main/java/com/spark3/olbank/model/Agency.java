package com.spark3.olbank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "agency")
@Getter
@Setter
@AllArgsConstructor
public class Agency {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long  agencyId;
  private long userId;
  private String name;
  private String address;
  private BigDecimal longitude;
  private BigDecimal latitude;
  private Long nbr_employees;
  private Date date;


  @OneToMany(mappedBy="agency",fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
  private List<Agent> listAgents;

  public Agency() {
  }
}
