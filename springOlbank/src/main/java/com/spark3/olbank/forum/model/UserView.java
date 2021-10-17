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
@Subselect("select u.id, u.user_name  from userx u")
//@Table(name = "word_view")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserView {
    @Id
    private long id;
    private String user_name ;

}
