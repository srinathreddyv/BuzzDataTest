package com.pearson.buzzdata.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.pearson.buzzdata.model.EnrollmentResponse;
import com.pearson.buzzdata.model.RequestModel;
import com.pearson.buzzdata.model.RequestObject;
import com.pearson.buzzdata.model.ResponseModel;
import com.pearson.buzzdata.model.UserResponse;

@Component
public class APIDataService {

	String url = "https://api.agilixbuzz.com/cmd";
	
	public ResponseModel login() throws JsonGenerationException, JsonMappingException, IOException{
		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.set("Content-Type", "application/json");
		header.set("Accept", "application/json");
		RequestModel request = new RequestModel();
		RequestObject requestObject = new RequestObject();

		requestObject.setCmd("login");
		requestObject
				.setUsername("KimbleTest/srinath.velagacharla@pearson.com");
		requestObject.setPassword("Pearson5");

		request.setRequest(requestObject);

		ObjectMapper mapper = new ObjectMapper();
		String requestString = "";

		requestString = mapper.writeValueAsString(request);
		System.out.println(requestString);

		HttpEntity<String> httpentity = new HttpEntity<String>(requestString,
				header);

		ResponseEntity<String> result = restTemplate.exchange(url,
				HttpMethod.POST, httpentity, String.class);

		String resultData = result.getBody();
		mapper = new ObjectMapper();
		ResponseModel response = mapper.readValue(resultData,
				ResponseModel.class);
		
		return response;
	}
	
	
	public EnrollmentResponse getEnrollmentData(ResponseModel loginResponse) throws JsonParseException, JsonMappingException, IOException{
		String token = loginResponse.getResponse().getUser().getToken();
		String domainId = loginResponse.getResponse().getUser().getDomainid();

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.set("Cookie", "AZT=" + token);
		header.set("Accept", "application/json");
		HttpEntity<String> httpentity = new HttpEntity<String>(header);

		String enrollmentUrl = url + "?cmd=listenrollments&domainid=" + domainId;
		ResponseEntity<String> enrolment = restTemplate.exchange(enrollmentUrl,
				HttpMethod.GET, httpentity, String.class);
		String data = enrolment.getBody().toString();
		ObjectMapper mapper = new ObjectMapper();

		EnrollmentResponse enrolmentResponse = mapper.readValue(data,
				EnrollmentResponse.class);
		
		return enrolmentResponse;
	}
	
	public UserResponse getUsersDetails(ResponseModel loginResponse) throws JsonParseException, JsonMappingException, IOException{
		
		String token = loginResponse.getResponse().getUser().getToken();
		String domainId = loginResponse.getResponse().getUser().getDomainid();

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.set("Cookie", "AZT=" + token);
		header.set("Accept", "application/json");
		HttpEntity<String> httpentity = new HttpEntity<String>(header);

		String userUrl = url + "?cmd=listusers&domainid=" + domainId;
		ResponseEntity<String> userData = restTemplate.exchange(userUrl,
				HttpMethod.GET, httpentity, String.class);
		String data = userData.getBody().toString();
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(data);
		UserResponse userResponse = mapper.readValue(data,
				UserResponse.class);
		
		return userResponse;
	}
}
