FROM openjdk:18-jdk-alpine as builder

WORKDIR /app/pokedex-info

COPY ./pom.xml /app
COPY ./pokedex-info/.mvn ./.mvn
COPY ./pokedex-info/mvnw .
COPY ./pokedex-info/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline
COPY ./pokedex-info/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:18-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/pokedex-info/target/pokedex-info-0.0.1-SNAPSHOT.jar .
EXPOSE 8081

CMD ["java", "-jar", "pokedex-info-0.0.1-SNAPSHOT.jar"]