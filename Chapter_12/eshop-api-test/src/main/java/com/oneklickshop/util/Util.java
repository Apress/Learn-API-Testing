package com.oneklickshop.util;

import com.google.gson.Gson;
import com.oneklickshop.model.JwtPayload;
import java.util.Base64;
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

  public static JwtPayload getJwtPayload(String token) {
    String[] chunks = token.split("\\.");
    String body = new String(Base64.getMimeDecoder().decode(chunks[1]));
    Gson gson = new Gson();

    return gson.fromJson(body, JwtPayload.class);
  }
}
