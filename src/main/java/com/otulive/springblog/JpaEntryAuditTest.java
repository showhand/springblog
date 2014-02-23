/**
 * Created on Oct 21, 2011
 */
package com.otulive.springblog;

import com.otulive.springblog.domain.Entry;
import com.otulive.springblog.service.EntryAuditService;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
public class JpaEntryAuditTest {

  /**
   * @param args
   */
  public static void main(String[] args) {

    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    ctx.load("classpath:jpa-app-context.xml");
    ctx.refresh();

    System.out.println("App context initialized successfully");

    EntryAuditService entryAuditService = ctx.getBean("entryAuditService", EntryAuditService.class);

    List<Entry> entries = entryAuditService.findAuditById(1l);

    for (Entry entry : entries) {
      System.out.println(entry);
    }

  }

}
