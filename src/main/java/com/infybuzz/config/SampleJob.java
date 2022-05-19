package com.infybuzz.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class SampleJob {

	private static final Logger logger = LoggerFactory.getLogger(SampleJob.class);


	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job firstJob() throws InterruptedException {
		logger.info("1 Job");

		return jobBuilderFactory.get("First Job")
				.start(firstStep())// Read all tasklet in firstStep
				.next(secondStep())// Read all tasklet in secondStep
				.build(); // Execute Tasklet
	}

	private Step firstStep() throws InterruptedException {
		logger.info("1.1 Step One,sleep");
		return stepBuilderFactory.get("First Step")
				.tasklet(firstTask())
				.build();
	}

	private Tasklet firstTask() {
		return new Tasklet() {

			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				logger.info("1.1.1 Tasklet One,This is first tasklet step");
				return RepeatStatus.FINISHED;
			}
		};
	}
	
	private Step secondStep() throws InterruptedException {
		logger.info("1.2 Step One");
		return stepBuilderFactory.get("Second Step")
				.tasklet(secondTask())
				.build();
	}
	
	private Tasklet secondTask() {
		return new Tasklet() {

			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				logger.info("1.2.1 Tasklet Two, This is second tasklet step");
				return RepeatStatus.FINISHED;
			}
		};
	}

}