package com.spark3.olbank.forum.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SentenceToWordImpl implements SentenceToWord {
    private static final int NBR_LETTER_MIN =3;

    @Override
    public String normalize(String string) {
        return Normalizer.normalize(string, Normalizer.Form.NFKD)
                .toLowerCase()
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll("[,.)(&'!?:]", "");
    }

    @Override
    public List<String> split(String sentence, int wordLength) {

        return Arrays.stream(this.normalize(sentence)
                .split(" "))
                .filter(s -> s.length() > wordLength).collect(Collectors.toList());
    }

    @Override
    public int compare(String sentence1, String sentence2) {
        List<String> ls = this.split(sentence1, NBR_LETTER_MIN);
        ls.retainAll(this.split(sentence2, NBR_LETTER_MIN));
        return ls.size();
    }

    @Override
    public int compareHard(String sentence1, String sentence2) {
      return (int) this.split(sentence1,NBR_LETTER_MIN)
                .stream()
                .filter(s->this.split(sentence2,NBR_LETTER_MIN)
                        .stream().anyMatch(f->f.contains(s))).count();
    }

    //System.out.println(Normalizer.normalize(sentence, Normalizer.Form.NFKD)
    //    .replaceAll("[^\\p{ASCII}]", ""));
}
