/**
 * Created on Dec 8, 2011
 */
package com.otulive.springblog.service.jpa;

import com.otulive.springblog.service.HousekeepingService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by roger on 14-2-23.
 */
@Service("housekeepingService")
@Transactional
public class HousekeepingServiceImpl implements HousekeepingService {

  @Value("${audit.record.history.days}")
  private int auditHistoryDays;

  @Scheduled(cron = "0 0 0 * * ?")
  public void auditPurgeJob() {
    // Purge audit record logic goes here
  }

}
