package com.spark3.olbank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;
import java.util.Date;

@Table(name = "credit")
@Getter
@Setter
@AllArgsConstructor
public class CreditRequest extends  Request{


    private  String Type;
    private String amount;
    private Date duration;

    public CreditRequest(Long requestId, Date requestDate, String requestType, String status, String agentId) {
        super();
    }

    public CreditRequest() {
        super();
    }

}
