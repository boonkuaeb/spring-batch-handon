package com.infybuzz.listener;


import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class FirstStepListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("\nBefore Step "+stepExecution.getStepName());
        System.out.println("Job Execution Context"+stepExecution.getJobExecution().getExecutionContext());
        System.out.println("Step execution Context"+stepExecution.getExecutionContext());

        stepExecution.getExecutionContext().put("sec","sec value");



    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("\nAfter Step "+stepExecution.getStepName());
        System.out.println("Job Execution Context"+stepExecution.getJobExecution().getExecutionContext());
        System.out.println("Step execution Context"+stepExecution.getExecutionContext());
        return null;
    }
}
