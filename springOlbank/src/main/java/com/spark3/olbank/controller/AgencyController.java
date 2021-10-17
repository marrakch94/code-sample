package com.spark3.olbank.controller;


import com.spark3.olbank.model.Agency;
import com.spark3.olbank.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("agency")
public class AgencyController {

    @Autowired
    AgencyService agencyService;


    @GetMapping("")
    public List<Agency> getAll() {
        return agencyService.findAll();
    }

    @GetMapping("{id}")
    public Agency getOne(@PathVariable("id") long id) {
        return agencyService.findById(id);
    }

    @PostMapping("")
    public Agency addOne(@RequestBody Agency agency) {
        return agencyService.create(agency);
    }

    @PutMapping("")
    public Agency updateOne(@RequestBody Agency agency) {
        return agencyService.update(agency);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteOne(@PathVariable("id") long id) {
        agencyService.delete(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("{Name_agency}/{address}/{dateOuverture}")
    public List<Agency> findAgencyByFeature(@PathVariable("Name_agency") String Name_agency
            ,@PathVariable("address") String address, @PathVariable("dateOuverture") Date dateOuverture){
        return	agencyService.getAgencyByFeature(Name_agency, address, dateOuverture);
    }


}
