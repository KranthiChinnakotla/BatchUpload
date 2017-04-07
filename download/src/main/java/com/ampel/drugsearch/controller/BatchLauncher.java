package com.ampel.drugsearch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchLauncher {

	@Autowired
	Job job;
	
	@Autowired
	JobLauncher jobLauncher;
	
	@RequestMapping("/launcher")
	public void handle() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException{
		JobParameters jobParameters = new JobParametersBuilder()
				.addLong("time",System.currentTimeMillis())
				.toJobParameters();
		jobLauncher.run(job, jobParameters);
	}
}
