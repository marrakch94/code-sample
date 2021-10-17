package com.spark3.olbank.forum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "forum")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Forum {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long forumId;
    private String topic;
    private Date forumDate;
    @Column(nullable = true)
    private long userId;
    @OneToMany(mappedBy="forum",fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
    private List<Message> listeMessages;
    public Forum(long forumId){this.forumId=forumId;}

}
