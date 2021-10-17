package com.spark3.olbank.forum.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Stat {
    private String title;
    private float valueN;
    private float valueNMinus1;
    private float evolution;

    public Stat(String title, float valueN, float valueNMinus1){
        this.title =title;
        this.valueN=valueN;
        this.valueNMinus1=valueNMinus1;
        this.evolution = ((valueN-valueNMinus1)/valueNMinus1)*100;
    }
}
