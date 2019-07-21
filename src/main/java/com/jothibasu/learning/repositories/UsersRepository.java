package com.jothibasu.learning.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jothibasu.learning.models.Users;

//@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UsersRepository extends MongoRepository<Users, String> {
	Users findBy_id(ObjectId _id);
}