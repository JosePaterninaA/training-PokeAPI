FROM openjdk:18-jdk-alpine as builder

WORKDIR /app/pokedex-config-server

COPY ./pom.xml /app
COPY ./pokedex-config-server/.mvn ./.mvn
COPY ./pokedex-config-server/mvnw .
COPY ./pokedex-config-server/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline
COPY ./pokedex-config-server/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:18-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/pokedex-config-server/target/pokedex-config-server-0.0.1-SNAPSHOT.jar .
EXPOSE 8888

CMD ["java", "-jar", "pokedex-config-server-0.0.1-SNAPSHOT.jar"]