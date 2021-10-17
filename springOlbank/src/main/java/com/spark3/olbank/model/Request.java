package com.spark3.olbank.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "request")
@Getter
@Setter
//@AllArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long requestId;
    private Date requestDate;
    private  String requestType;
    private String status;


    public Request(Long requestId) {
        this.requestId = requestId;
    }

    public Request() {}

    @ManyToOne
    private Client client;


	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", requestDate=" + requestDate + ", requestType=" + requestType
				+ ", status=" + status + ", client=" + client + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((requestDate == null) ? 0 : requestDate.hashCode());
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((requestType == null) ? 0 : requestType.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (requestDate == null) {
			if (other.requestDate != null)
				return false;
		} else if (!requestDate.equals(other.requestDate))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (requestType == null) {
			if (other.requestType != null)
				return false;
		} else if (!requestType.equals(other.requestType))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Request(Date requestDate, String requestType, String status, Client client) {
		super();
		this.requestDate = requestDate;
		this.requestType = requestType;
		this.status = status;
		this.client = client;
	}

	public Request(Long requestId, Date requestDate, String requestType, String status, Client client) {
		super();
		this.requestId = requestId;
		this.requestDate = requestDate;
		this.requestType = requestType;
		this.status = status;
		this.client = client;
	}



}
