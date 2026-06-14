# BASE JDK image
FROM eclipse-temurin:23-jdk-alpine

#SET WORKING DIRECTORY
WORKDIR /app

#COPY THE JAR FILE
COPY target/*.jar app.jar

#EXPOSE SPRING BOOT DEFAULT CODE
EXPOSE 8080

#RUN THE JAR
ENTRYPOINT ["java", "-jar", "app.jar"]