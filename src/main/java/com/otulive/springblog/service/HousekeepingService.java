/**
 * Created on Dec 8, 2011
 */
package com.otulive.springblog.service;

/**
 * Created by roger on 14-2-23.
 */
public interface HousekeepingService {

  /**
   * Scheduled job to purge audit records.
   */
  public void auditPurgeJob();

}
