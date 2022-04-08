<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [Contact Management App API Test](#contact-management-app-api-test)
  - [Test Execution](#test-execution)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# Contact Management App API Test
This project contains RestAssured test automation scripts for Contact Management API Endpoints.

## Test Execution
Enter below command in terminal window for executing test script.
```
$ mvn clean test -Dtest=<Name Of Test> -Denv=test
```

Or

```
$ mvn clean test
```

Note that after executing the tests you need to restart the docker or the tomcat based on where you have deployed the `app.war`.