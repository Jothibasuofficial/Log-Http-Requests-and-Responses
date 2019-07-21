package com.jothibasu.learning.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jothibasu.learning.models.RequestsAndResponses;

@RepositoryRestResource(collectionResourceRel = "requestsAndResponses", path = "requestsAndResponses")
public interface RequestsAndResponsesRepository extends MongoRepository<RequestsAndResponses, String> {
	RequestsAndResponses findBy_id(ObjectId _id);
}
