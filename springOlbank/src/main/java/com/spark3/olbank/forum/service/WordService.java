package com.spark3.olbank.forum.service;

import com.spark3.olbank.forum.model.Word;
import com.spark3.olbank.forum.model.WordView;

import java.util.List;
import java.util.Map;

public interface WordService {

    public List<Word> getAll();

    public List<WordView> getN(int nbrWord);

    public List<Word> getAllProcessed();

    public List<WordView> groupByFrequency();

    public void executeFetchProcedure();
}
