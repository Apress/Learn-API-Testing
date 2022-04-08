FROM tomcat:8.5.47-jdk8-openjdk

MAINTAINER Jagdeep Jain "jagdeep.jain@gmail.com"

EXPOSE 8080

RUN rm -rf ./webapps/*
COPY app.war /usr/local/tomcat/webapps/app.war
ENV JAVA_OPTS="-Dspring.profiles.active=dev"
CMD ["catalina.sh", "run"]
