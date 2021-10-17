package com.spark3.olbank.forum.controller;

import com.spark3.olbank.forum.model.Word;
import com.spark3.olbank.forum.model.WordView;
import com.spark3.olbank.forum.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/word")
public class WordController {
    @Autowired
    WordService wordService;
    @GetMapping("/")
    public List<Word> getAll(){
        return wordService.getAll();
    }
    @GetMapping("/x")
    public List<WordView> getAllx() throws InterruptedException {
        wordService.executeFetchProcedure();
        //wait(3000);
        return wordService.groupByFrequency();
    }
    @GetMapping("/{nbrWord}")
        public List<WordView> getN(@PathVariable("nbrWord") int nbrWord){
        wordService.executeFetchProcedure();
        return wordService.getN(nbrWord);
        }

}
