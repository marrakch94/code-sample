package com.spark3.olbank.forum.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "bi_view")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BiView {
    @Id
    private int yearMonth;
    private String tempsStringMonth;
    private int tempsMonth;
    private int tempsYear;
    private long messageNbr;
    private long likeNbr;
    private long disLikeNbr;
    private long messageUsersNbr;
    private long  forumNbr;
    private long forumUsersNbr;


}
