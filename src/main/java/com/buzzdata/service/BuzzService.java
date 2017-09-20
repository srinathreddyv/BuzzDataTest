package com.buzzdata.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.buzzdata.model.Enrollment;
import com.buzzdata.model.EnrollmentResponse;
import com.buzzdata.model.ResponseModel;

@Component
public class BuzzService {

	@Autowired
	DBService dbService;

	@Autowired
	APIDataService apiDataService;

	public boolean buzzService() {
		boolean res = false;
		ResponseModel response = null;
		EnrollmentResponse enrResponse = null;
		List<String> idList = null;
		try {
			response = apiDataService.login();
			if (response != null) {
				enrResponse = apiDataService.getEnrollmentData(response);
			}
			if (enrResponse != null) {
				System.out.println("enrollment data fetched");
				idList = dbService.getDetails();
				if (idList != null) {
					System.out.println("Id list populated "+idList.toString());
					for (Enrollment enr : enrResponse.getResponse()
							.getEnrollments().getEnrollment()) {
						
						if(!idList.contains(enr.getId())){
							System.out.println("Inserting data for id:"+enr.getId());
							dbService.insertData(enr);
							res = true;
						}
					}
				}
			}

		} catch (IOException | ClassNotFoundException | URISyntaxException
				| SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return res;
		}
		return res;

	}
}
