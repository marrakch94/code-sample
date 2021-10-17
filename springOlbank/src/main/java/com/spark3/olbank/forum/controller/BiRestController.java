package com.spark3.olbank.forum.controller;

import com.spark3.olbank.forum.model.BiView;
import com.spark3.olbank.forum.model.Stat;
import com.spark3.olbank.forum.service.BiViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/bi")
public class BiRestController {
    @Autowired
    BiViewService biViewService;

    @GetMapping("/{year}")
    public List<BiView> getDataByYear (@PathVariable("year") int year){
        return biViewService.getByYear(year);
    }

    @GetMapping("/stat")
    public Stat getStat(){
        return biViewService.getStat();    }
}
