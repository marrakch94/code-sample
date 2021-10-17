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
@Table(name = "message_view")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MessageView  implements Comparable<MessageView> {
    @Id
    private int messageGroupDate;
    private long messageNbr;
    private int messageYear;
    private int messageMonth;
    private String messageMonthString;

    @Override
    public int compareTo(MessageView messageView) {
        if (this.messageGroupDate > messageView.messageGroupDate) {
            return 1;
        } else if (this.messageGroupDate < messageView.messageGroupDate) {
            return -1;
        }
        return 0;
    } 
}
