package com.buzzdata.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.buzzdata.model.Enrollment;
import com.buzzdata.model.EnrollmentResponse;
import com.buzzdata.model.RequestModel;
import com.buzzdata.model.RequestObject;
import com.buzzdata.model.ResponseModel;

@Controller
public class BuzzDataController {

	@RequestMapping("/getDetails")
	public ResponseEntity<String> showMessage() throws JsonParseException,
			JsonMappingException, IOException {
		System.out.println("in controller");
		String url = "https://api.agilixbuzz.com/cmd";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.set("Content-Type", "application/json");
		header.set("Accept", "application/json");
		RequestModel request = new RequestModel();
		RequestObject requestObject = new RequestObject();

		requestObject.setCmd("login");
		requestObject.setUsername("KimbleTest/srinath.velagacharla@pearson.com");
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
		String token = "";
		String domainId = "";
		ResponseModel response = mapper.readValue(resultData,
				ResponseModel.class);
		token = response.getResponse().getUser().getToken();
		domainId = response.getResponse().getUser().getDomainid();

		System.out.println(resultData);
		restTemplate = new RestTemplate();
		header = new HttpHeaders();
		header.set("Cookie", "AZT=" + token);
		header.set("Accept", "application/json");
		httpentity = new HttpEntity<String>(header);

		url = url + "?cmd=listenrollments&domainid=" + domainId;
		ResponseEntity<String> enrolment = restTemplate.exchange(url,
				HttpMethod.GET, httpentity, String.class);
		String data = enrolment.getBody().toString();
		mapper = new ObjectMapper();

		EnrollmentResponse enrolmentResponse = mapper.readValue(data,
				EnrollmentResponse.class);
		System.out.println(enrolmentResponse.toString());

		
		for(Enrollment enr : enrolmentResponse.getResponse().getEnrollments().getEnrollment() ){
			//add db logic
		}
		return new ResponseEntity<String>(data, HttpStatus.OK);
	}

}
