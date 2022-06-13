#
# BUILD STAGE
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

#
# PACKAGE STAGE
#
FROM openjdk:11-jre-slim
COPY --from=build /usr/src/app/target/halushka_pampushka_bot-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/app/halushka_pampushka_bot-1.0-SNAPSHOT.jar
EXPOSE 8083
CMD ["java","-jar","/usr/app/halushka_pampushka_bot-1.0-SNAPSHOT.jar"]
