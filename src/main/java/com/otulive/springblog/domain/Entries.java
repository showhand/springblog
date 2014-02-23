/**
 * Created on Dec 12, 2011
 */
package com.otulive.springblog.domain;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
public class Entries {

  private List<Entry> entries;

  public Entries() {
  }

  public Entries(List<Entry> entries) {
    this.entries = entries;
  }

  public List<Entry> getEntries() {
    return entries;
  }

  public void setEntries(List<Entry> entries) {
    this.entries = entries;
  }

}
