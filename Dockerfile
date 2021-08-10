FROM openjdk:16-jdk-alpine
ARG JAR_FILE=target/*.war 
COPY ${JAR_FILE} blog.war
ENTRYPOINT ["java","-war","/blog.war"]
