package com.pearson.buzzdata.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pearson.buzzdata.model.Enrollment;
import com.pearson.buzzdata.model.EnrollmentResponse;
import com.pearson.buzzdata.model.ResponseModel;
import com.pearson.buzzdata.model.User;
import com.pearson.buzzdata.model.UserResponse;

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
		UserResponse userResponse = null;
		List<String> idList = null;
		try {
			response = apiDataService.login();
			if (response != null) {
				enrResponse = apiDataService.getEnrollmentData(response);
				userResponse = apiDataService.getUsersDetails(response);
			}
			if (enrResponse != null) {
				System.out.println("enrollment data fetched");
				idList = dbService.getDetails();
				System.out.println("Id list populated " + idList.toString());
				for (Enrollment enr : enrResponse.getResponse()
						.getEnrollments().getEnrollment()) {

					if (!idList.contains(enr.getId())) {
						System.out.println("Inserting data for id:"
								+ enr.getId());
						dbService.insertEnrollmentData(enr);
						res = true;
					}
				}

			}

			if (userResponse != null) {
				idList = dbService.getUserDetails();
				for (User user : userResponse.getResponse().getUsers()
						.getUser()) {
					if (!idList.contains(user.getId())) {
						dbService.insertUserData(user);
						res = true;
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
