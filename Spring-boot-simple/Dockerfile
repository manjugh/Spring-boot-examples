FROM openjdk:8-jre-alpine

COPY target/Spring-boot-simple-0.0.1-SNAPSHOT.jar /

CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/Spring-boot-simple-0.0.1-SNAPSHOT.jar"]