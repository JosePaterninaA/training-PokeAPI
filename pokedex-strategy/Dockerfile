FROM openjdk:18-jdk-alpine as builder

WORKDIR /app/pokedex-strategy

COPY ./pom.xml /app
COPY ./pokedex-strategy/.mvn ./.mvn
COPY ./pokedex-strategy/mvnw .
COPY ./pokedex-strategy/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline
COPY ./pokedex-strategy/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:18-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/pokedex-strategy/target/pokedex-strategy-0.0.1-SNAPSHOT.jar .
EXPOSE 8082

CMD ["java", "-jar", "pokedex-strategy-0.0.1-SNAPSHOT.jar"]