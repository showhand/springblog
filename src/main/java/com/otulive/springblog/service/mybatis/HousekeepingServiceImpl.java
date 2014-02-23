/**
 * Created on Jan 25, 2012
 */
package com.otulive.springblog.service.mybatis;

import com.otulive.springblog.service.HousekeepingService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by roger on 14-2-23.
 */
@Service("housekeepingService")
@Repository
@Transactional
public class HousekeepingServiceImpl implements HousekeepingService {

  @Value("${audit.record.history.days}")
  private int auditHistoryDays;

  @Scheduled(cron = "0 0 0 * * ?")
  public void auditPurgeJob() {
    // Purge audit record logic goes here
  }

}
