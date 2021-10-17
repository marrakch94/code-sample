package com.spark3.olbank.repository;

import com.spark3.olbank.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Date;

public interface AgencyRepository extends JpaRepository<Agency, Long> {

//    List<Agency> findByName_agencyAndAddressAndDateOuverture(String Name_agency, String address, Date dateOuverture);

}
