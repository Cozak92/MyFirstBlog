FROM openjdk:16-jdk-alpine
ARG JAR_FILE=target/*.jar 
COPY ${JAR_FILE} blog.jar
ENTRYPOINT ["java","-jar","/blog.jar"]
