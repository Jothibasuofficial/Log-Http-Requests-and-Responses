package com.jothibasu.learning.dbcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jothibasu.learning.models.RequestsAndResponses;
import com.jothibasu.learning.repositories.RequestsAndResponsesRepository;

@Component 
public class RequestsAndResponsesController {

	@Autowired
	private RequestsAndResponsesRepository repository;
	
	
	public List<RequestsAndResponses> getAllRequestsAndResponses() {
	
		return repository.findAll();
	}

	
	public RequestsAndResponses getRequestsAndResponsesById(ObjectId id) {
		return repository.findBy_id(id);
	}

	public void modifyRequestsAndResponsesById(ObjectId id, @Valid RequestsAndResponses requestsAndResponses) {
		requestsAndResponses.set_id(id);
		repository.save(requestsAndResponses);
	}

	
	public RequestsAndResponses createRequestsAndResponses(@Valid RequestsAndResponses requestsAndResponses) {
		requestsAndResponses.set_id(ObjectId.get());
		repository.save(requestsAndResponses);
		return requestsAndResponses;
	}

	
	public void deleteRequestsAndResponses(ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}
}
