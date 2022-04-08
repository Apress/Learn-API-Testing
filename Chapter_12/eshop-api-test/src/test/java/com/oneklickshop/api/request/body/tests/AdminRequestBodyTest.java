package com.oneklickshop.api.request.body.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * User API Request Body Test Class.
 *
 * <p>Test OneKlickShop users endpoint request body.
 *
 * @author Jagdeep Jain
 */
public class AdminRequestBodyTest extends BaseTest {

  @BeforeTest
  public void setup() {
    admin();
  }

  @Test(description = "verify format not supported on adding user", priority = 3)
  public void testAddUserFormatUnsupported() {
    String USER = "src/test/resources/payload/user/formatUnsupported.xml";
    request().post(OneKlickShop.ADD_USER.url(), new File(USER));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(400);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .startsWith("JSON parse error");
  }

  @Test(description = "verify special characters not allowed on user payload", priority = 3)
  public void testAddUserSpecialCharacter() {
    String USER = "src/test/resources/payload/user/addSpecialCharacters.json";
    request().post(OneKlickShop.ADD_USER.url(), new File(USER));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(400);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .startsWith("JSON parse error");
  }

  @Test(description = "verify long string on user payload is not supported", priority = 3)
  public void testAddUserLongString() {
    String USER = "src/test/resources/payload/user/addLongString.json";
    request().post(OneKlickShop.ADD_USER.url(), new File(USER));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(500);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("Unknown error occurred.");
  }

  @Test(description = "verify invalid method type not supported", priority = 3)
  public void testAddUserInvalidMethod() {
    request().post(OneKlickShop.ADD_USER.url());
    assertThat(response().getResponse().getStatusCode()).isEqualTo(500);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("Request method 'PUT' not supported");
  }

  @Test(
      description = "verify invalid vales in the payload is not supported " + "in user payload",
      priority = 3)
  public void testAddUserInvalidValue() {
    String USER = "src/test/resources/payload/user/addInvalidValue.json";
    request().post(OneKlickShop.ADD_USER.url(), new File(USER));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(500);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("Unknown error occurred.");
  }

  @Test(
      description = "verify incorrect data type is not supported in user " + "payload",
      priority = 3)
  public void testAddUserIncorrectDataType() {
    String USER = "src/test/resources/payload/user/addIncorrectDataType.json";
    request().post(OneKlickShop.ADD_USER.url(), new File(USER));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(500);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("Unknown error occurred.");
  }

  @Test(description = "verify empty data is not supported", priority = 3)
  public void testAddUserEmptyData() {
    String USER = "src/test/resources/payload/user/addEmptyData.json";
    request().post(OneKlickShop.ADD_USER.url(), new File(USER));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(500);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("Unknown error occurred.");
  }

  @Test(description = "verify empty payload is not supported", priority = 3)
  public void testAddUserEmptyPayload() {
    String USER = "src/test/resources/payload/user/emptyPayload.json";
    request().post(OneKlickShop.ADD_USER.url(), new File(USER));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(500);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("Unknown error occurred.");
  }

  @Test(description = "verify only required field is allowed", priority = 3)
  public void testAddUserRequiredFields() {
    String USER = "src/test/resources/payload/user/addRequiredFieldsOnly.json";
    request().post(OneKlickShop.ADD_USER.url(), new File(USER));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(201);
  }

  @Test(description = "verify nulls are not allowed in the payload", priority = 3)
  public void testAddUserNulls() {
    String USER = "src/test/resources/payload/user/updateNulls.json";
    request().post(OneKlickShop.ADD_USER.url(), new File(USER));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(500);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("Unknown error occurred.");
  }

  @Test(description = "verify redundant fields is allowed in the payload", priority = 3)
  public void testAddUserRedundantFields() {
    String USER = "src/test/resources/payload/user/addRedundantFields.json";
    request().post(OneKlickShop.ADD_USER.url(), new File(USER));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(201);
  }

  @Test(description = "verify delete again throws correct error message", priority = 3)
  public void testDeleteUserDeleteAgain() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", 110);
    request().delete(OneKlickShop.DELETE_USER.url(), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(404);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("user not found with id : 110");
  }

  @Test(description = "verify duplicate error message", priority = 3)
  public void testAddUserDuplicateCheck() {
    String USER = "src/test/resources/payload/user/duplicateCheck.json";
    request().post(OneKlickShop.ADD_USER.url(), new File(USER));
    request().post(OneKlickShop.ADD_USER.url(), new File(USER)); // add again
    assertThat(response().getResponse().getStatusCode()).isEqualTo(400);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .startsWith("JSON parse error");
  }

  @Test(description = "verify format not supported on update user", priority = 3)
  public void testUpdateUserFormatUnsupported() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", 110);
    String USER = "src/test/resources/payload/user/formatUnsupported.xml";
    request().put(OneKlickShop.UPDATE_USER.url(), new File(USER), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(400);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .startsWith("JSON parse error");
  }

  @Test(description = "verify special characters not supported on update user", priority = 3)
  public void testUpdateUserSpecialCharacter() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", 110);
    String USER = "src/test/resources/payload/user/updateSpecialCharacters.json";
    request().put(OneKlickShop.UPDATE_USER.url(), new File(USER), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(400);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .startsWith("JSON parse error");
  }

  @Test(description = "verify long string supported on update user", priority = 3)
  public void testUpdateUserLongString() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", 110);
    String USER = "src/test/resources/payload/user/updateLongString.json";
    request().put(OneKlickShop.UPDATE_USER.url(), new File(USER), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(500);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("Unknown error occurred.");
  }

  @Test(description = "verify invalid method type not supported on update user", priority = 3)
  public void testUpdateUserInvalidMethod() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", 110);
    String USER = "src/test/resources/payload/user/invalidMethod.json";
    request().patch(OneKlickShop.UPDATE_USER.url(), new File(USER), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(405);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("Request method 'PATCH' not supported");
  }

  @Test(description = "verify invalid value not supported on update user", priority = 3)
  public void testUpdateUserInvalidValue() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", 110);
    String USER = "src/test/resources/payload/user/updateInvalidValue.json";
    request().put(OneKlickShop.UPDATE_USER.url(), new File(USER), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(400);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .startsWith("JSON parse error");
  }

  @Test(description = "verify incorrect data type not supported on update " + "user", priority = 3)
  public void testUpdateUserIncorrectDataType() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", 110);
    String USER = "src/test/resources/payload/user/updateIncorrectDataType.json";
    request().put(OneKlickShop.UPDATE_USER.url(), new File(USER), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(400);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .startsWith("JSON parse error");
  }

  @Test(description = "verify empty data not supported on update user", priority = 3)
  public void testUpdateUserEmptyData() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", 110);
    String USER = "src/test/resources/payload/user/updateEmptyData.json";
    request().put(OneKlickShop.UPDATE_USER.url(), new File(USER), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(500);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .startsWith("JSON parse error");
  }

  @Test(description = "verify empty payload not supported on update user", priority = 3)
  public void testUpdateUserEmptyPayload() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", 110);
    String USER = "src/test/resources/payload/user/emptyPayload.json";
    request().put(OneKlickShop.UPDATE_USER.url(), new File(USER), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(500);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .startsWith("Unknown error occurred.");
  }

  @Test(description = "verify required fields only on update user", priority = 3)
  public void testUpdateUserRequiredFields() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", 110);
    String USER = "src/test/resources/payload/user/updateRequiredFieldsOnly.json";
    request().put(OneKlickShop.UPDATE_USER.url(), new File(USER), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
  }

  @Test(description = "verify nulls not allowed on update payload", priority = 3)
  public void testUpdateUserNulls() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", 110);
    String USER = "src/test/resources/payload/user/updateNulls.json";
    request().put(OneKlickShop.UPDATE_USER.url(), new File(USER), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(500);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .startsWith("Unknown error occurred.");
  }

  @Test(description = "verify redundant fields allowed in update payload", priority = 3)
  public void testUpdateUserRedundantFields() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", 110);
    String USER = "src/test/resources/payload/user/updateRedundantFields.json";
    request().put(OneKlickShop.UPDATE_USER.url(), new File(USER), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
  }
}
