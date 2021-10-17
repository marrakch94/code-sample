package com.spark3.olbank.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
public class AccountRequest extends Request{

    private String accountType;

    public AccountRequest() {

    }
}
