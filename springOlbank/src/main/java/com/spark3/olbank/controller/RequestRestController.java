package com.spark3.olbank.controller;

import com.spark3.olbank.model.Request;
import com.spark3.olbank.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/request")
public class RequestRestController {

     	@Autowired
        RequestService requestService;

        @ResponseBody
        @GetMapping("/")
        public List<Request> getAllRequest() {

            return requestService.getAllRequests();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Request> getRequestById(@PathVariable(value = "id") Long requestId) {

            try {
                Request request =  requestService.getRequestById(requestId);
                return ResponseEntity.ok().body(request);
            }catch(Exception  e) {
                return null;
            }

        }

        @ResponseBody
        @PostMapping("/add_request")
        public boolean createRequest(@RequestBody Request request) {
            try {
                requestService.saveOrUpdate(request);
                return true;
            }catch(Exception  e) {
                return false;
            }

            //return agent.save(zone);
        }


        @PutMapping("/update")
        public boolean updateRequest(@RequestBody Request requestDetails) throws ResourceNotFoundException {
            requestService.saveOrUpdate(requestDetails);
            return true;
        }

        @DeleteMapping("/delete/{id}")
        public boolean deleteZone(@PathVariable(value = "id") Long id)
                throws ResourceNotFoundException {
        	requestService.deleteRequest(id);
            return true;
        }


    }


