package com.spark3.olbank.service;

import com.spark3.olbank.model.Agency;
import com.spark3.olbank.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Date;


@Service
public class AgencyServiceImpl implements AgencyService {


    @Autowired
    AgencyRepository agencyRepository;

    @Override
    public Agency findById(long id) {
        return agencyRepository.findById(id).get();
    }

    @Override
    public List<Agency> findAll() {
        return agencyRepository.findAll();
    }

    @Override
    public Agency create(Agency agency) {
        return agencyRepository.save(agency);
    }

    @Override
    public Agency update(Agency agency) { return agencyRepository.save(agency); }

    @Override
    public void delete(long id) {
        agencyRepository.deleteById(id);
    }

    @Override
    public List<Agency> getAgencyByFeature(String Name_agency, String address, Date dateOuverture) {
        return null; //agencyRepository.findByName_agencyAndAddressAndDateOuverture(Name_agency, address, dateOuverture);
    }


}
