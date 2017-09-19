package com.buzzdata.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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

import com.buzzdata.domain.DBConnection;
import com.buzzdata.model.Enrollment;
import com.buzzdata.model.EnrollmentResponse;
import com.buzzdata.model.RequestModel;
import com.buzzdata.model.RequestObject;
import com.buzzdata.model.ResponseModel;

@Controller
public class BuzzDataController {

	
	@RequestMapping("/createDB")
	public ResponseEntity<String> crateDB() throws URISyntaxException,
			SQLException {

		Connection con = null;
		try {
			con = DBConnection.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "CREATE TABLE ENROLLMENT("
				+ "ID TEXT PRIMARY KEY     NOT NULL," + "USERID      TEXT  ,"
				+ "COURSEID   TEXT  ," + "ROLEID      TEXT ,"
				+ "DOMAINID     TEXT ," + "REFERENCE TEXT, GUID      TEXT  ,"
				+ "PRIVILIGES   TEXT  ," + "STATUS      TEXT ,"
				+ "STARTDATE     TEXT ," + "ENDDATE      TEXT  ,"
				+ "FLAGS   TEXT  ," + "FIRSTACTIVITYDATE      TEXT ,"
				+ "LASTACTIVITYDATE     TEXT ," + "CREATIONDATE     TEXT ,"
				+ "CREATIONBY      TEXT  ," + "MODIFIEDDATE   TEXT  ,"
				+ "MODIFIEDBY      TEXT ," + "VERSION     TEXT)";

		Statement stmt = con.createStatement();
		stmt.execute(query);
		con.close();
		return new ResponseEntity<>("created data", HttpStatus.OK);
	}

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

		mapper = new ObjectMapper();
		for (Enrollment enr : enrolmentResponse.getResponse().getEnrollments()
				.getEnrollment()) {
			try {
				insertData(enr);
			} catch (ClassNotFoundException | URISyntaxException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResponseEntity<String>("Error in insertion", HttpStatus.OK);
				
			}
		}
		return new ResponseEntity<String>("Data Inserted", HttpStatus.OK);
	}

	public void insertData(Enrollment enr) throws ClassNotFoundException,
			URISyntaxException, SQLException {
		// TODO Auto-generated method stub

		Connection con = null;

		con = DBConnection.getConnection();

		String insertQuery = "INSERT INTO ENROLLMENT(ID, USERID, COURSEID, ROLEID, DOMAINID, GUID, "
				+ "PRIVILIGES, STATUS, STARTDATE, ENDDATE, FLAGS, FIRSTACTIVITYDATE, LASTACTIVITYDATE, "
				+ "CREATIONDATE, CREATIONBY, MODIFIEDDATE, MODIFIEDBY, VERSION, REFERENCE)"
				+ "VALUES" + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement = null;

		preparedStatement = con.prepareStatement(insertQuery);
		preparedStatement.setString(1, enr.getId());
		preparedStatement.setString(2, enr.getUserid());
		preparedStatement.setString(3, enr.getCourseid());
		preparedStatement.setString(4, enr.getRoleid());
		preparedStatement.setString(5, enr.getDomainid());
		preparedStatement.setString(6, enr.getGuid());
		preparedStatement.setString(7, enr.getPrivileges());
		preparedStatement.setString(8, enr.getStatus());
		preparedStatement.setString(9, enr.getStartdate());
		preparedStatement.setString(10, enr.getEnddate());
		preparedStatement.setString(11, enr.getFlags());
		preparedStatement.setString(12, enr.getFirstactivitydate());
		preparedStatement.setString(13, enr.getLastactivitydate());
		preparedStatement.setString(14, enr.getCreationdate());
		preparedStatement.setString(15, enr.getCreationby());
		preparedStatement.setString(16, enr.getModifieddate());
		preparedStatement.setString(17, enr.getModifiedby());
		preparedStatement.setString(18, enr.getVersion());
		preparedStatement.setString(19, enr.getReference());
		
		preparedStatement.executeUpdate();
		
		con.close();
	}

}
