FROM openjdk:18-jdk-alpine as builder

WORKDIR /app/discovery-server

COPY ./pom.xml /app
COPY ./discovery-server/.mvn ./.mvn
COPY ./discovery-server/mvnw .
COPY ./discovery-server/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline
COPY ./discovery-server/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:18-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/discovery-server/target/discovery-server-0.0.1-SNAPSHOT.jar .
EXPOSE 8001

CMD ["java", "-jar", "discovery-server-0.0.1-SNAPSHOT.jar"]