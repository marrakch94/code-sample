package com.spark3.olbank.service;

import com.spark3.olbank.model.Request;

import java.util.List;

public interface IRequestService {

    public List<Request> getAllRequests();

    public Request getRequestById(long id);

    public void saveOrUpdate(Request request);

    public void deleteRequest(long id);

    public Request getRequestByType(String requestType);
}
