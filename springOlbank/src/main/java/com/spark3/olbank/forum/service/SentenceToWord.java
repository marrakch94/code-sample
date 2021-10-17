package com.spark3.olbank.forum.service;

import java.util.List;

public interface SentenceToWord {

    public List<String> split (String Sentence, int wordLength);

    public int compare (String sentence1, String sentence2);

    public int compareHard (String sentence1, String sentence2);

    public String normalize (String string);

}
