FROM tomcat:8.5.47-jdk8-openjdk

MAINTAINER Jagdeep Jain "jagdeep.jain@gmail.com"

EXPOSE 8080

RUN rm -rf ./webapps/*
COPY eshop.war /usr/local/tomcat/webapps/eshop.war
ENV JAVA_OPTS="-Dspring.profiles.active=dev"
CMD ["catalina.sh", "run"]
