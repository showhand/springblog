package com.otulive.springblog.batch.integration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.integration.launch.JobLaunchRequest;
import org.springframework.integration.Message;
import org.springframework.integration.annotation.Transformer;

import java.io.File;

/**
 * Spring batch with integration to trigger file import job.
 *
 * Created by roger on 14-2-23.
 */
public class FileMessageToJobRequest {

  private Job job;
  private String fileParameterName;

  public void setFileParameterName(String fileParameterName) {
    this.fileParameterName = fileParameterName;
  }

  public void setJob(Job job) {
    this.job = job;
  }

  @Transformer
  public JobLaunchRequest toRequest(Message<File> message) {
    JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
    jobParametersBuilder.addString(fileParameterName,
                                   message.getPayload().getAbsolutePath());
    return new JobLaunchRequest(job, jobParametersBuilder.toJobParameters());
  }

}
