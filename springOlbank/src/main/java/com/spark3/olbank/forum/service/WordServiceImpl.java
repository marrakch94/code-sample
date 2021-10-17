package com.spark3.olbank.forum.service;

import com.spark3.olbank.forum.model.Word;
import com.spark3.olbank.forum.model.WordView;
import com.spark3.olbank.forum.repository.WordRepository;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class WordServiceImpl implements WordService {
    private static final int NBR_LETTER_MIN =3;
    @Autowired
    WordRepository agent;
    @Autowired
    SentenceToWord sentenceToWord;

    @Override
    public List<Word> getAll() {
        return agent.findAll();
    }

    @Override
    public List<WordView> getN(int nbrWord) {
        return groupByFrequency().subList(0,nbrWord-1);
    }

    @Override
    public List<Word> getAllProcessed() {
        return this.getAll().stream()
                .peek(w -> w.setWordTxt(sentenceToWord.normalize(w.getWordTxt())))
                .filter(w -> w.getWordTxt().length()>NBR_LETTER_MIN).collect(Collectors.toList());
    }

    @Override
    public List<WordView> groupByFrequency() {
        //Map<String, Long>
        return this.getAllProcessed().stream()
                .collect(Collectors
                        .groupingBy(Word::getWordTxt,Collectors.counting()))
                .entrySet().stream().map(w->{return new WordView(w.getKey(),w.getValue()); })
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
            }
    @Override
    public void executeFetchProcedure() {
        agent.fetch_message_proc();    }
}
