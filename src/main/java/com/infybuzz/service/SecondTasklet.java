package com.infybuzz.service;

import com.infybuzz.config.SampleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Service;

@Service
public class SecondTasklet implements Tasklet {

    private static final Logger logger = LoggerFactory.getLogger(SecondTasklet.class);

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        logger.info("1.2.1 Tasklet Two, This is second tasklet step");
        return RepeatStatus.FINISHED;
    }
}
