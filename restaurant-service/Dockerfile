FROM maven:3.8.1-adoptopenjdk-11 as build
COPY . /usr/src/restaurant-service
WORKDIR /usr/src/restaurant-service
RUN mvn clean package
FROM adoptopenjdk/openjdk11:alpine-jre
RUN addgroup -S restaurant-service && adduser -S restaurant-service -G restaurant-service
RUN mkdir -p /files &&  \
        chown -R restaurant-service:restaurant-service /files
USER restaurant-service:restaurant-service
VOLUME /files
WORKDIR /app
COPY --from=build /usr/src/restaurant-service/target/*.jar /app/app.jar
EXPOSE 9010
ENTRYPOINT ["java", "-jar", "app.jar"]