<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [Contact Management App API Test](#contact-management-app-api-test)
  - [Package Structure](#package-structure)
    - [Re-Usability](#re-usability)
    - [Response Model](#response-model)
  - [Update REST End Point Property File](#update-rest-end-point-property-file)
    - [Update <Application>Config.java](#update-applicationconfigjava)
    - [Update <ApplicationEnum>.java](#update-applicationenumjava)
  - [Test Properties](#test-properties)
  - [Test Class](#test-class)
  - [Query Parameter](#query-parameter)
  - [Authentication](#authentication)
  - [Adding Additional Test Data](#adding-additional-test-data)
  - [System Properties](#system-properties)
    - [Environment](#environment)
    - [Application URL](#application-url)
  - [Test Execution](#test-execution)
    - [Test Suite](#test-suite)
    - [Specific Test](#specific-test)
  - [Setting Up Sonar For Code Quality Checks](#setting-up-sonar-for-code-quality-checks)
  - [Summary](#summary)
  - [References](#references)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# API Test Framework Details
Demonstration of Test Framework is done based on Contact Management Application.

The same test framework can be used by any team, we just need to update few things which are mentioned in this document under Re-Usability section.

This project contains RestAssured based test automation scripts for Contact Management API Endpoints.

## Package Structure
| Package Name | Class 	    | Description   |
|--------------|------------|---------------|
| `com.contact.mgmt.api.request`  | `HttpRequest`, `RequestProcessor`, `HttpMethodFactory`, `<HttpRequestMethod>Impl` | This package contains `HttpMethodFactory` which provides Http Method Objects. `HttpRequest` class abstracts the http methods. `RequestProcessor` does the work of processing the request for the given http method name, this is the class used in `BaseTest` class. Implementation class implements the actual `RestAssured` calls.|
| `com.contact.mgmt.api.response` | `<Model>Response`, `ResponseFactory`, `ResponseFactoryCreator`, `ResponseProcessor` | `ResponseFactory` provides the response object type. `ResponseFactoryCreator` helps in creating the required response data type object. `ResponseProcessor` does the work of processing the response, this is the class used in `BaseTest` class.|
| `com.contact.mgmt.api.exceptions` | `InvalidRequestException`, `InvalidResponseException` | `Request` and `Response` customer exception types |
| `com.contact.mgmt.api.auth`       | `Authentication`          | Takes URL, user credentials and provides the JWT Key |
| `com.contact.mgmt.api.config`	    | `ApplicationContext`, `AppConfig`, `SpringBeanConfiguration`, `TestConfig` , `<Application>Config`,  `ApplicationEnum`      | `ApplicationContext` is a Spring Application Context. `<Application>Config` provides application specific endpoints (this will be updated based on the application under test). `SpringConfiguration` provides the Spring Configuration, standard spring config file. `TestConfig` file is again the spring configuration for loading properties file based on the selected environment. `<Application>Config` has the getter for the endpoints in the properties file. `AppliationEnum` has the endpoints which will be used in the test script.|

### Re-Usability
This test framework is developed with an objective of re-usability and to achieve this goal we have used standard design patters and solid design patterns.

Request module is build up with Factory pattern and Response module is build up with Abstract Factory pattern.

Each class has its own responsibility and adding a new class is very easy which does not impact any other code.

With the Factory Pattern usage, it is very easy to create a new object once a new class is added.

The same package structure and files can be used in other project, below items needs to be updated with the new project.
1. If the new HTTP Method types are being used in the new project, just add the new method type in enum class HttpMethodType and the new implementation class extending the `HttpRequest` abstract class. Add the support in the `RequestProcessor` class.
2. `<Model>Response` based on the application, this is the JSON response model. We need to create an interface and implementation class respectively and add a support in `ResponseProcessor` class.
3. Replace Authentication parameters ex. URL, request payload or user/pass based on the application under test.
4. Rename the `<Application>Config` class based on the new project name and add all the API endpoints getters. Also add enum parameters based on the endpoint added if any.
5. No changes required in `TestConfig` unless you want to use for some additional purpose. This is the class which load the environment specific properties file.

### Response Model
1. From the Postman hit the API call and check the JSON response. 
2. Open the URL https://freecodegenerators.com/code-converters/json-to-pojo in browser and copy the JSON response to generate the JAVA POJO. 
3. Save the POJO with the required name, lets say it's a find `Contact`, name the POJO as `Contact.java` and add empty constructor and parameterized constructor, also add getters and setters. 
4. Create a interface class as `ContactResponse` and then add the implementation class as `ContactResponseImpl`. 
5. Add the method in `ResponseAbstractFactory` as `ContactResponse getContactResponse();`. 
6. Implement the method in `ResponseFactory` and return a implementation object as `return new OrderDetailResponseImpl();`.

Above will help to read the response from the API in a user-friendly manner.

## Update REST End Point Property File
For adding a new API endpoint, we need to update `REST-endpoints.properties` file with the new REST End Point.

It should be added based on the METHOD type.
For example lets say it is a `GET` call and reads the case details than it should be named appropriately.
This is helps in understanding the endpoint http method type.

For example.
```bash
current.user=GET,/api/v1/users
```

### Update <Application>Config.java
This file serves as provider of REST End Point in the Test Class.
With each Property added in `REST-endpoints.properties` properties file we need to add equivalent getters in this Class.

Variable and Method name should be all CAPS signifies that it is API Call, shown as below.

```java
@Value("${login}")
private String LOGIN;

public String authentication() {
    return LOGIN.split(",")[1];
    }
```

### Update <ApplicationEnum>.java
Update the enum with the new endpoint.

```java
ADD_CONTACT_ADDRESS {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getContactAddress().ADD_CONTACT_ADDRESS();
    }
  }
```

This will allow test scripts to call the `ADD_CONTACT_ADDRESS` endpoint.

## Test Properties
There are four test properties file.

| File Name | Purpose |
|-----------|---------|
| `REST-endpoints.properties` | Contain API endpoints properties |
| `dev.properties` | Contains test data of development environment |
| `test.properties` | Contains test data of test environment|
| `stage.properties` | Contains test data of stage environment |
| `prod.properties` | Contains test data of production environment |

## Test Class
Once the REST End Point property file `REST-endpoints.properties` is updated with required API(s) and equivalent variable and Method has been added in the config classes, we can use that in the test script.

```java
public class AddContactAddressTest extends BaseTest {

  @BeforeTest
  public void setup() {
    authentication();
  }

  @Test(description = "verify response of POST /api/v1/contact/address", priority = 1)
  public void testAddContact() {
    String NEW_CONTACT = "src/test/resources/payload/contact/contact.json";
    request().post(ContactManagement.ADD_CONTACT_ADDRESS.url(), new File(NEW_CONTACT));

    assertThat(response().getResponse().getStatusCode()).isEqualTo(201);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1.1 " + "201 ");
  }
}
```
Note that we are using the BaseTest class, this makes the test script clean and fluent.

` request().post(API endpoint, payload, query parameter)` is available in `BaseTest.java` and will be doing the actual API call.
If the call is PUT, we can just replace `put` with `post` and provides the payload accordingly.

`response()` returns the RestAssured Response Object.

Each test has a `description` which is a good to have to find out what does the test script does.

``` 
@Test(description = "verify response of PUT /api/v1/contacts/{id}", priority = 1)
```

## Query Parameter
If we have query parameters, those should be stored in `HashMap` and send as a parameter to the endpoint.

```java
private static final Map<String, Integer> query = new HashMap<>();
private static final int CONTACT_ID = 1001;
```

## Authentication
`authentication()` is available in `BaseTest.java` and is being used for authenticating a user, this also provides the JWT token for successive calls.


## Adding Additional Test Data
For adding new test data we need to update specific environment property file, all environment properties files needs to be updated.

Based on the property type getters has to be added, in above property we are retrieving a new endpoint.

## System Properties
Below are the system properties need to be used while executing tests.

### Environment
Pass below value to the `-Denv` and based on that respective properties file will be picked up.

- `test` to execute test on test environment
- `dev` to execute test on dev environment
- `stage` to execute test on stage environment
- `prod` to execute test on prod environment

### Application URL
Application under test should be specified using this system property, by
default all tests will run on `http://localhost:8080/app`

## Test Execution
To execute test suites or individual test, you can enter below command in
terminal window.

### Test Suite
Enter below command in terminal window for executing test suite.
```
$ mvn clean test -P<testSuiteName> -Denv=test
```

### Specific Test
Enter below command in terminal window for executing single test script.
```
$ mvn clean test -Dtest=<Name Of Test> -Denv=test
```

## Setting Up Sonar For Code Quality Checks
It is always good to check the quality of the code. Execute below command in terminal window for downloading and running sonar docker image.

Note that we need to use specific version of sonarqube since the API tests are written in JDK 8.

```shell
$ docker pull sonarqube:6.7-alpine
$ docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:6.7-alpine
```

Open `http://localhost:9000` in browser, login as `demo/demo` and follow the process of setting up the project manually.

Get the API key and add in the below command. Execute the below command in terminal window from the project root folder for scanning the project source code.

Save the API ket for later usage.

Once scanning is completed, you can open `http://localhost:9000` and check the code quality.

```shell
$ mvn clean sonar:sonar -Dsonar.projectKey=api-test -Dsonar.host.url=http://localhost:9000 -Dsonar.login=<sonar api-key>
```

You can save the command in the notes for later usage.

## Summary
Test Framework is having sufficient support for adding a new test but in case if it is required to add more support than we need to update `BaseTest.java` to make sure that all the Test Class has implicit access to all the resources.

## References
* [Rest Assured](http://rest-assured.io/)
* [Rest Assured Getting Started](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)
* [Factory Pattern](https://en.wikipedia.org/wiki/Factory_method_pattern)
* [Abstract Factory Pattern](https://en.wikipedia.org/wiki/Abstract_factory_pattern)
* [Solid Design Principals](https://en.wikipedia.org/wiki/SOLID)





