package com.oneklickshop.api.jwt.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.model.JwtPayload;
import com.oneklickshop.util.Util;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Jwt Payload Tests.
 *
 * <p>Test JWT Payload after POST auth/authenticate.
 *
 * @author Jagdeep Jain
 */
public class JwtPayloadTest extends BaseTest {

  @BeforeTest
  public void setup() {}

  @Test(description = "verify admin login jwt payload", priority = 4)
  public void testAdminJwtPayload() {
    admin();
    JwtPayload jwtPayload = Util.getJwtPayload(getJwtToken());

    assertThat(jwtPayload.getUserId()).isEqualTo(100);
    assertThat(jwtPayload.getAuthorities().get(0).authority).isEqualTo("ROLE_ADMIN");
    assertThat(jwtPayload.getEmail()).isEqualTo("admin@oneklickshop.com");
    assertThat(jwtPayload.getUsername()).isEqualTo("admin@oneklickshop.com");
  }

  @Test(description = "verify user login jwt payload", priority = 4)
  public void testUserJwtPayload() {
    user();
    JwtPayload jwtPayload = Util.getJwtPayload(getJwtToken());

    assertThat(jwtPayload.getAuthorities().get(0).authority).isEqualTo("ROLE_USER");
    assertThat(jwtPayload.getEmail()).isEqualTo("jjain@google-123.com");
    assertThat(jwtPayload.getUsername()).isEqualTo("jjain@google-123.com");
  }
}
