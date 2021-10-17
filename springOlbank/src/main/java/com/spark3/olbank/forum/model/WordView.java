package com.spark3.olbank.forum.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
//@Subselect("select w.word_txt, count(*) as frequency from word w group by w.word_txt")
@Table(name = "word_view")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class WordView implements Comparable<WordView> {
    @Id
    private String word_txt;
    private long frequency;

    @Override
    public int compareTo(WordView wordView) {
        if (this.getFrequency()> wordView.getFrequency()) {return 1;}
        else if (this.getFrequency()== wordView.getFrequency()){return 0;}
        return -1;
    }
}
