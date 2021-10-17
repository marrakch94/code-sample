package com.spark3.olbank.forum.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class ForumMatch implements Comparable<ForumMatch>{

    private Forum forum;
    private int nbrWordMatch;

    public ForumMatch() {
    }
    public ForumMatch(Forum forum, int nbrWordMatch) {
        this.forum = forum;
        this.nbrWordMatch = nbrWordMatch;
    }

    @Override
    public int compareTo(ForumMatch forumMatch) {

            if (this.getNbrWordMatch()== forumMatch.getNbrWordMatch()) {return 0;}
            else if (this.getNbrWordMatch()< forumMatch.getNbrWordMatch()) {return 1;}
        return -1;
    }
}
