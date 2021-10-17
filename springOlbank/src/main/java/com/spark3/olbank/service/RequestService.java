package com.spark3.olbank.service;



import com.spark3.olbank.model.Request;
import com.spark3.olbank.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RequestService implements IRequestService {

	@Autowired
	RequestRepository requestRepository;
	 
	@Override
	public List<Request> getAllRequests() {
		// TODO Auto-generated method stub
		 return (List<Request>) requestRepository.findAll();
	}

	@Override
	public Request getRequestById(long id) {
		// TODO Auto-generated method stub
		 return requestRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Request request) {
		
		Request updatedRequest = requestRepository.findById( request.getRequestId() ).get();
		
		requestRepository.save(updatedRequest);
	}

	@Override
	public void deleteRequest(long id) {
		// TODO Auto-generated method stub
		requestRepository.deleteById(id);
	}

	@Override
	public Request getRequestByType(String requestType) {
		// TODO Auto-generated method stub
		return null;
	}
}
