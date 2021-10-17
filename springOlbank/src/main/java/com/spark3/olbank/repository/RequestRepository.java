package com.spark3.olbank.repository;
import com.spark3.olbank.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long>  {
//    List<Request> findRequestsByClient(Request request);
}
