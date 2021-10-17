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
import java.util.Date;

@Entity
@Immutable
//@Subselect("")
@Table(name = "forum_view")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ForumView implements Comparable<ForumView> {
    @Id
    private long forumId;
    private String topic;
    private Date dateLastMessage;
    private long totalDisLike;
    private long totalLike;
    private long totalMessage;

    @Override
    public int compareTo(ForumView forumView) {
      if (this.totalMessage > forumView.totalMessage) { return 1;}
      else if (this.totalMessage < forumView.totalMessage) {return -1;}
        return 0;
    }
}
