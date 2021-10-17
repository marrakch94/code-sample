package com.spark3.olbank.forum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
@Getter
@Setter
@AllArgsConstructor
@ToString

public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;
    private long userId;
    private int nbrLike;
    @Column(nullable = true)
    private int nbrDisLike;
    private String likingUserList;
    @Column(nullable = true)
    private String disLikingUserList;
    private Date dateTime;
    private String messageTxt;
    @ManyToOne
    @JoinColumn(name="forumId",referencedColumnName="forumId")
    @JsonIgnoreProperties({"listeMessages","topic", "forumDate"})
    private Forum forum;
    //@JsonIgnore
    public Message() {
    }
    public Message(String s) {
        this.messageTxt = s;
    }

}
