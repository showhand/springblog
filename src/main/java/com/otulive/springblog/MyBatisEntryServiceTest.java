/**
 * Created on Oct 27, 2011
 */
package com.otulive.springblog;

import com.otulive.springblog.domain.Entry;
import com.otulive.springblog.service.EntryService;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
public class MyBatisEntryServiceTest {

  /**
   * @param args
   */
  public static void main(String[] args) {

    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    ctx.load("classpath:mybatis-app-context.xml");
    ctx.refresh();

    System.out.println("App context initialized successfully");

    EntryService entryService = ctx.getBean("entryService", EntryService.class);

    List<Entry> entries = entryService.findAll();

    //System.err.println("Size: " + entries.size());
    for (Entry entry : entries) {
      System.out.println("Entry: " + entry);
    }

  }

}
