package com.jothibasu.learning.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.mongodb.BasicDBObject;

public class RequestsAndResponses {
	
	@Id
	public ObjectId _id;
	public BasicDBObject requestParams;
	public BasicDBObject responseParams;
	public Date logTime; 
	
	public RequestsAndResponses() {
		
	}
	
	public RequestsAndResponses(ObjectId _id, BasicDBObject requestParams, BasicDBObject responseParams, Date logTime) {
		super();
		this._id = _id;
		this.requestParams = requestParams;
		this.responseParams = responseParams;
		this.logTime = logTime;
	}


	public ObjectId get_id() {
		return _id;
	}


	public void set_id(ObjectId _id) {
		this._id = _id;
	}


	public BasicDBObject getRequestParams() {
		return requestParams;
	}


	public void setRequestParams(BasicDBObject requestParams) {
		this.requestParams = requestParams;
	}


	public BasicDBObject getResponseParams() {
		return responseParams;
	}


	public void setResponseParams(BasicDBObject responseParams) {
		this.responseParams = responseParams;
	}

	
	public Date getLogTime() {
		return logTime;
	}


	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	
	
}
