package com.infybuzz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Service;

@Service
public class FirstTasklet implements Tasklet {


    private static final Logger logger = LoggerFactory.getLogger(FirstTasklet.class);

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.println("1.1.1 Tasklet One,This is first tasklet step");
        System.out.println("SEC "+chunkContext.getStepContext().getStepExecutionContext());
        return RepeatStatus.FINISHED;
    }
}
