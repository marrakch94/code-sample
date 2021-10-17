package com.spark3.olbank.forum.service;

import com.spark3.olbank.forum.model.BiView;
import com.spark3.olbank.forum.model.Stat;

import java.util.List;

public interface BiViewService {
    public List<BiView> getAll();

    public List<BiView> getByYear(int year);

    public Stat getStat ();

}
