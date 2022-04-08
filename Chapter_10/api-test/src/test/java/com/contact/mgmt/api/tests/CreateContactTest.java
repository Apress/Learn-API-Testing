package com.contact.mgmt.api.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.contact.mgmt.api.config.ContactManagement;
import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Create Contact Test Class.
 *
 * <p>Test POST /api/v1/contacts endpoint for creating a contact.
 *
 * @author Jagdeep Jain
 */
public class CreateContactTest extends BaseTest {

  @BeforeTest
  public void setup() {
    authentication();
  }

  @Test(description = "verify response of POST /api/v1/contacts", priority = 1)
  public void testAddContact() {
    String NEW_CONTACT = "src/test/resources/payload/contact" + "/contact" + ".json";
    request().post(ContactManagement.ADD_CONTACT.url(), new File(NEW_CONTACT));

    assertThat(response().getResponse().getStatusCode()).isEqualTo(201);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1.1 " + "201 ");
  }
}
