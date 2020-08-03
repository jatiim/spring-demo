# Use base image
FROM openjdk:8-jdk-alpine

# Set workdirectory
WORKDIR /opt

# Copy the artifact
COPY target/spring-demo-0.0.1-SNAPSHOT.jar /opt/spring.jar

# Execute the artifact
ENTRYPOINT exec java -jar /opt/spring.jar