package com.infybuzz.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class FirstJobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("\nBefore jobs "+jobExecution.getJobInstance().getJobName());
        System.out.println("Job Params "+jobExecution.getJobParameters());
        System.out.println("Job Execute Context "+jobExecution.getExecutionContext());

        jobExecution.getExecutionContext().put("jec","jec value");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("\nAfter jobs "+jobExecution.getJobInstance().getJobName());
        System.out.println("Job Params "+jobExecution.getJobParameters());
        System.out.println("Job Execute Context "+jobExecution.getExecutionContext());

    }
}
