package com.pearson.buzzdata.controller;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pearson.buzzdata.service.BuzzService;

@Controller
public class BuzzDataController {

	@Autowired
	BuzzService buzzService;

	@RequestMapping("/testService")
	public ResponseEntity<String> startschedule() throws ClassNotFoundException, URISyntaxException, SQLException{
		boolean result = buzzService.buzzService();
		if(result)
			return new  ResponseEntity<>("Added new records",HttpStatus.OK);
		else
			return new  ResponseEntity<>("Records already exists",HttpStatus.OK);
	}
} 
