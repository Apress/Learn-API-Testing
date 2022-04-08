package com.contact.mgmt.util;

import java.util.Collections;
import java.util.List;

/**
 * A Utility class for consumption by test classes.
 *
 * <p>Provides various utilities to the test classes during the executing of a test case.
 *
 * @author Jagdeep Jain
 */
public class Util {

  private Util() {}

  public static List<String> sortList(List<String> list) {
    Collections.sort(list);
    return list;
  }
}
