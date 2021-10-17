package com.spark3.olbank.forum.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "word")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int wordId;
    public String wordTxt;


}
