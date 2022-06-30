FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-movement.jar
ENTRYPOINT ["java","-jar","/ms-movement.jar"]