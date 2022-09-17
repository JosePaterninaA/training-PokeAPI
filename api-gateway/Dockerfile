FROM openjdk:18-jdk-alpine as builder

WORKDIR /app/api-gateway

COPY ./pom.xml /app
COPY ./api-gateway/.mvn ./.mvn
COPY ./api-gateway/mvnw .
COPY ./api-gateway/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline
COPY ./api-gateway/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:18-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/api-gateway/target/api-gateway-0.0.1-SNAPSHOT.jar .
EXPOSE 8002

CMD ["java", "-jar", "api-gateway-0.0.1-SNAPSHOT.jar"]