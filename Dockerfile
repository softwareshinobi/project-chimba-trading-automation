FROM maven:3.8.7-openjdk-18-slim AS jreBuild

MAINTAINER Software Shinobi "the.software.shinobi@gmail.com"

WORKDIR /

COPY ./ ./

RUN mvn install -DskipTests

FROM eclipse-temurin:18-jre-alpine

COPY --from=jreBuild /target/project-chimba-1.0.jar /project-chimba.jar

COPY --from=jreBuild /src/main/resources/application.properties /application.properties

CMD ["java", "-jar", "project-chimba.jar"] 
