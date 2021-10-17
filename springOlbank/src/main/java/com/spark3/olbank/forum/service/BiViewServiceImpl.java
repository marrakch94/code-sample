package com.spark3.olbank.forum.service;

import com.spark3.olbank.forum.model.BiView;
import com.spark3.olbank.forum.model.Stat;
import com.spark3.olbank.forum.repository.BiViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class BiViewServiceImpl implements BiViewService{
    @Autowired
    BiViewRepository agent;

    @Override
    public List<BiView> getAll() {
        return agent.findAll();
    }

    @Override
    public List<BiView> getByYear(int year) {
        return agent.findBiViewByTempsYear(year);
    }

    @Override
    public Stat getStat() {
        int year = LocalDate.now().getYear();
        int month = LocalDate.now().getMonth().getValue();
        System.out.println("MsgViewServ Month and year: "+ month +" "+year);
        float valueN = new Long(agent
                .findBiViewByTempsYearAndTempsMonth(year,month)
                .getMessageUsersNbr()).floatValue();
        float valueNMinus1 = new Long(agent
                .findBiViewByTempsYearAndTempsMonth(year,month-1)
                .getMessageUsersNbr()).floatValue();
        return new Stat("Monthly number of users",valueN,valueNMinus1);
    }

}
