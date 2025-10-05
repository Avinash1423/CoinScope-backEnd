FROM  maven:3.9.6-openjdk-23 AS BUILD
COPY . .
RUN mvn clean package -DSkipTests

FROM  openjdk:23-jdk
COPY   --from=build  /target/backend-0.0.1-SNAPSHOT.jar backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","-Courier.jar"]

