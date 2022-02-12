
#
# Build stage
#
#CACHING???: https://stackoverflow.com/a/45975194/10276375
FROM maven:3.8.4-openjdk-11 AS build
COPY . /home/app
WORKDIR /home/app
RUN mvn package spring-boot:repackage


#
# Package stage
#
FROM openjdk:11
COPY --from=build /home/app/target/*.jar camunda_engine.jar
#EXPOSE 8080
#ENTRYPOINT ["chmod", "+x", "script-name-here.sh"]
#ENTRYPOINT ["./wait-for-it.sh", "postgres:6543"]
ENTRYPOINT ["java","-jar","camunda_engine.jar"]





##CACHING POM???: https://stackoverflow.com/a/45975194/10276375
##
## Build stage
##
#FROM maven:3.8.4-openjdk-11 AS build
#ADD pom.xml /home/app/
#RUN mvn verify clean --fail-never
#ADD . /home/app/
#WORKDIR /home/app/
#RUN mvn package spring-boot:repackage
#
#
##
## Package stage
##
#FROM openjdk:11
#COPY --from=build /home/app/target/*.jar camunda_engine.jar
##EXPOSE 8080
#ENTRYPOINT ["java","-jar","camunda_engine.jar"]