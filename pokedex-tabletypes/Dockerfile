FROM openjdk:18-jdk-alpine as builder

WORKDIR /app/pokedex-tabletypes

COPY ./pom.xml /app
COPY ./pokedex-tabletypes/.mvn ./.mvn
COPY ./pokedex-tabletypes/mvnw .
COPY ./pokedex-tabletypes/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline
COPY ./pokedex-tabletypes/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:18-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/pokedex-tabletypes/target/pokedex-tabletypes-0.0.1-SNAPSHOT.jar .
EXPOSE 8083

CMD ["java", "-jar", "pokedex-tabletypes-0.0.1-SNAPSHOT.jar"]