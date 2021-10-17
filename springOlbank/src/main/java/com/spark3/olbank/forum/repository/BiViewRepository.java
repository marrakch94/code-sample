package com.spark3.olbank.forum.repository;

import com.spark3.olbank.forum.model.BiView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BiViewRepository extends JpaRepository<BiView, Integer> {
    List<BiView> findBiViewByTempsYear (int year);

    BiView findBiViewByTempsYearAndTempsMonth(int year, int month);
}
