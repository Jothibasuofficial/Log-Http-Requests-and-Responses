package com.jothibasu.learning.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jothibasu.learning.dbcontrollers.RequestsAndResponsesController;
import com.jothibasu.learning.models.RequestsAndResponses;
import com.mongodb.BasicDBObject;

@Component
public class RequestsAndResponsesHandler {

	@Autowired
	private RequestsAndResponsesController requestsAndResponsesController;

	public void storeRequestsAndResponses(HttpServletRequest request, HttpServletResponse response) throws IOException {

		/** Creating objects */
		BasicDBObject requestObj = new BasicDBObject();
		BasicDBObject responseObj = new BasicDBObject();

		Enumeration<String> headerNames = request.getHeaderNames();
		BasicDBObject requestHeaderObj = new BasicDBObject();

		/** Iterating heading parameters and mapping it to headers object */
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			requestHeaderObj.put(headerName, request.getHeader(headerName));
		}

		requestObj.put("headers", requestHeaderObj);

		Enumeration<String> params = request.getParameterNames();
		BasicDBObject requestParamsObj = new BasicDBObject();

		/** Iterating query parameters and mapping it to params object */
		while (params.hasMoreElements()) {
			String paramName = (String) params.nextElement();
			requestParamsObj.put(paramName, request.getParameter(paramName));
		}
		requestObj.put("params", requestParamsObj);

		/** Creating and mapping response parameters */
		/** Only status code is mapped, only its needed */
		BasicDBObject responseStatusObj = new BasicDBObject();
		responseStatusObj.put("code", response.getStatus());
		responseObj.put("status", responseStatusObj);

		/** Initializing requestsAndResponses with necessary parameters */
		RequestsAndResponses requestsAndResponses = new RequestsAndResponses();
		requestsAndResponses.setRequestParams(requestObj);
		requestsAndResponses.setResponseParams(responseObj);
		requestsAndResponses.setLogTime(new Date());

		requestsAndResponsesController.createRequestsAndResponses(requestsAndResponses);

		/** Commented because body data is not required */
		/*
		 * System.out.println("Row data");
		 * System.out.println(extractPostRequestBody(request));
		 */
	}

	static String extractPostRequestBody(HttpServletRequest request) throws IOException {

		if ("POST".equalsIgnoreCase(request.getMethod())) {
			if (request.getContentLength() > 0) {
				String line;
				BufferedReader rd = new BufferedReader(request.getReader());
				System.out.println("before]");
				while ((line = rd.readLine()) != null) {
					System.out.println(line);
				}
				rd.close();
				System.out.println("[after");
			}
			return "test";
		}
		return "";
	}

}
