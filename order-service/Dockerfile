FROM maven:3.8.1-adoptopenjdk-11 as build
COPY . /usr/src/order-service
WORKDIR /usr/src/order-service
RUN mvn clean package
FROM adoptopenjdk/openjdk11:alpine-jre
RUN addgroup -S order-service && adduser -S order-service -G order-service
RUN mkdir -p /files &&  \
        chown -R order-service:order-service /files
USER order-service:order-service
VOLUME /files
WORKDIR /app
COPY --from=build /usr/src/order-service/target/*.jar /app/app.jar
EXPOSE 9020
ENTRYPOINT ["java", "-jar", "app.jar"]