<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [One Klick Shop App API Test](#one-klick-shop-app-api-test)
  - [System Properties](#system-properties)
    - [Environment](#environment)
    - [Application URL](#application-url)
  - [Test Execution](#test-execution)
    - [Test Suite](#test-suite)
    - [Specific Test](#specific-test)
  - [Setting Up Sonar For Code Quality Checks](#setting-up-sonar-for-code-quality-checks)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# One Klick Shop App API Test

This project contains RestAssured based test automation scripts for One Klick
Shop App API Endpoints.

## System Properties

Below are the system properties need to be used while executing tests.

### Environment

Pass below value to the `-Denv` and based on that respective properties file
will be picked up.

- `test` to execute test on test environment
- `dev` to execute test on dev environment
- `stage` to execute test on stage environment
- `prod` to execute test on prod environment

### Application URL

Application under test should be specified using this system property, by
default all tests will run on `http://localhost:8080/eshop`

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

Execute below command in terminal window for downloading and running sonar
docker image.

Note that we need to use specific version of sonarqube since the API tests are
written in JDK 8.

```shell
$ docker pull sonarqube:6.7-alpine
$ docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:6.7-alpine
```

Open `http://localhost:9000` in browser, login as `demo/demo` and follow the
process of setting up the project manually.

Get the API key and add in the below command. Execute the below command in
terminal window from the project root folder for scanning the project source
code.

Save the API ket for later usage.

Once scanning is completed, you can open `http://localhost:9000` and check the
code quality.

```shell
$ mvn clean sonar:sonar -Dsonar.projectKey=api-test -Dsonar.host.url=http://localhost:9000 -Dsonar.login=<sonar api-key>
```

You can save the command for later usage.

