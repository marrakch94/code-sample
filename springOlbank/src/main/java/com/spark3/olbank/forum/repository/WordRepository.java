package com.spark3.olbank.forum.repository;

import com.spark3.olbank.forum.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface WordRepository extends JpaRepository<Word, Integer> {

    @Procedure
    void fetch_message_proc ();
}
