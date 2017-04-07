package com.ampel.drugsearch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ampel.drugsearch.download.App;
import com.ampel.drugsearch.model.Drug;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger LOG = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED){
			for(Drug d: App.queryList){
				LOG.info("Drug name "+d.getDrug_name()+", Target Name "+d.getTarget());
			}
		}
		App.queryList.clear();
	}
	
	
}
