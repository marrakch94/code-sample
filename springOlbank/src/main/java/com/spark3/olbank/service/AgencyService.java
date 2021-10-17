package com.spark3.olbank.service;

import com.spark3.olbank.model.Agency;

import java.util.List;
import java.util.Date;

public interface AgencyService {

    Agency findById(long id);

    List<Agency> findAll();

    Agency create(Agency agency);

    Agency update(Agency agency);

    void delete(long id);

    List<Agency> getAgencyByFeature(String Name_agency, String address, Date dateOuverture);


}
