package com.buzzdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BuzzScheduler {

	@Autowired
	BuzzService buzzService;
	
	@Scheduled(cron ="0 0 4 ? * *")
	public void scheduleFixedDelayTask() {
		System.out.println("Running scheduler");
	    buzzService.buzzService();
	}
}
