# Learn-API-Testing
Learn API Testing by Jagdeep Jain

## Note for Apple M1 Chipset
For Apple MacOS M1 Chipset, please update the JDK version as shown below.
```bash
java -version
openjdk version "1.8.0_322"
OpenJDK Runtime Environment (Zulu 8.60.0.21-CA-macos-aarch64) (build 1.8.0_322-b06)
OpenJDK 64-Bit Server VM (Zulu 8.60.0.21-CA-macos-aarch64) (build 25.322-b06, mixed mode)
```
Install the applicable tomcat binaries for Apple MacOS M1 Chipset and deploy the war file in the `/webapps` folder.

Windows users can navigate to the local tomcat installations and under `/bin` folder, by executing `startup.bat` local application can be started.

For non windows users use `/startup.sh` script to start the applicaiton in local environment.

## FAQ
### Issue with Windows-Docker Setup 
On Windows machine sometimes the docker setup may not work due to some reason.

For Contact Management APIs, copy the [Contact Management Web Archive](https://github.com/Apress/Learn-API-Testing/blob/main/Appendix-B/app.war) under local installation of Tomcat inside `/webapps` folder and start the server by executing `/bin/startup.bat`, use [Contact Management Postman Script]( https://github.com/Apress/Learn-API-Testing/tree/main/Chapter_06/postman-tests) to check the JWT.

For eShop APIs, copy the [eShop Web Archive](https://github.com/Apress/Learn-API-Testing/blob/main/Appendix-C/eshop.war) under local installation of Tomcat inside `/webapps` folder and start the server by executing `/bin/startup.bat`, use [eShop Postman Script](https://github.com/Apress/Learn-API-Testing/tree/main/Chapter_12/postman-tests) to check the JWT.

### Browser
Note that the APIs are based on JWT authentication so if you hit the URL from the browser then the application will not work since it needs the JWT as one of the header. Always use Postman for testing and writing test script.

Chapter 11 demonstrate the usage of Swagger, if you want to try browser then use the Swagger for browser based testing.

