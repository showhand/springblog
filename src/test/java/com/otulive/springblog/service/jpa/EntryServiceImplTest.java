/**
 * Created on Nov 1, 2011
 */
package com.otulive.springblog.service.jpa;

import com.otulive.springblog.domain.Entry;
import com.otulive.springblog.service.EntryService;
import com.otulive.springblog.service.HelloService;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by roger on 14-2-23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/jpa-app-context-test.xml"})
public class EntryServiceImplTest {

  @Autowired
  private EntryService entryService;

  @Autowired
  private HelloService helloService;

  @Test
  public void testInsert() {
    Entry entry = new Entry();
    entry.setSubject("Testing entry clarence");
    entry.setBody("Testing entry clarence");
    entry.setPostDate(new DateTime());
    entry.setCategoryId("Spring");
    entry.setCreatedBy("prospring3");
    entry.setCreatedDate(new DateTime());
    entry.setLastModifiedBy("prospring3");
    entry.setLastModifiedDate(new DateTime());
    helloService.sayHello();
//		entryService.save(entry);
    System.out.println("Entry: " + entry);
  }

}
