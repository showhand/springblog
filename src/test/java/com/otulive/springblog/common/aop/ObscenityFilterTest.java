/**
 * Created on Oct 3, 2011
 */
package com.otulive.springblog.common.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by roger on 14-2-23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/app-context-test.xml"})
public class ObscenityFilterTest {

  @Autowired
  private ObscenityFilterAdvice obscenityFilterAdvice;

  //	@Autowired
  private ObscenityFilter obscenityFilter;

  @Test
  public void testReplaceObscenity() {
    System.out.println(obscenityFilterAdvice);
    String testData = "Crap! Kiss my arse, you damn bugger!";
    obscenityFilter = obscenityFilterAdvice.getObscenityFilter();
    assertTrue("Test data should contain obscenities",
               obscenityFilter.containsObscenities(testData));

    String val = obscenityFilter.obfuscateObscenities(testData);

    System.out.println(val);

    assertTrue(val.indexOf("arse") == -1);
    assertTrue(val.indexOf("Crap") == -1);
    assertTrue(val.indexOf("damn") == -1);
    assertTrue(val.indexOf("bugger") == -1);
    assertTrue(val.indexOf("Kiss") > -1);
  }

}
