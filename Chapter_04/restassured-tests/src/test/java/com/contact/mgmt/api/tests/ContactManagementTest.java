package com.contact.mgmt.api.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * Contact Management RestAssured Tests.
 *
 * @author Jagdeep Jain
 */
class ContactManagementTest {
  private final String app = "http://localhost:8080/app";

  @Test
  @DisplayName("Create Contact")
  public void tesAddContact() {
    String addContact = "src/test/resources/contact.json";
    String url = app + "/api/v1/contacts";
    given()
        .body(new File(addContact))
        .header("Authorization", "Bearer " + getJwtToken())
        .contentType("application/json")
        .when()
        .post(url)
        .then()
        .statusCode(201);
  }

  @Test
  @DisplayName("Update Contact")
  public void tesUpdateContact() {
    String updateContact = "src/test/resources/updateContact.json";
    String url = app + "/api/v1/contacts/{id}";
    HashMap<String, Integer> query = new HashMap<>();
    query.put("id", 1001);
    given()
        .body(new File(updateContact))
        .header("Authorization", "Bearer " + getJwtToken())
        .contentType("application/json")
        .when()
        .put(url, query)
        .then()
        .statusCode(200);
  }

  @Test
  @DisplayName("Find Contact")
  public void tesFindContact() {
    String url = app + "/api/v1/contacts/{id}";
    HashMap<String, Integer> query = new HashMap<>();
    query.put("id",1002);
    given()
        .header("Authorization", "Bearer " + getJwtToken())
        .contentType("application/json")
        .when()
        .get(url, query)
        .then()
        .statusCode(200);
  }

  @Test
  @DisplayName("Delete Contact")
  public void tesDeleteContact() {
    String url = app + "/api/v1/contacts/{id}";
    HashMap<String, Integer> query = new HashMap<>();
    query.put("id", 1003);
    given()
        .header("Authorization", "Bearer " + getJwtToken())
        .contentType("application/json")
        .when()
        .delete(url, query)
        .then()
        .statusCode(204);
  }

  private String getJwtToken() {
    String admin = "src/test/resources/admin.json";
    String url = app + "/auth/authenticate";
    return
        given()
        .body(new File(admin))
        .contentType("application/json")
        .when()
        .post(url).getHeader("Authorization");
  }
}
