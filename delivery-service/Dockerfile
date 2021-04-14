FROM maven:3.8.1-adoptopenjdk-11 as build
COPY . /usr/src/delivery-service
WORKDIR /usr/src/delivery-service
RUN mvn clean package
FROM adoptopenjdk/openjdk11:alpine-jre
RUN addgroup -S delivery-service && adduser -S delivery-service -G delivery-service
RUN mkdir -p /files &&  \
        chown -R delivery-service:delivery-service /files
USER delivery-service:delivery-service
VOLUME /files
WORKDIR /app
COPY --from=build /usr/src/delivery-service/target/*.jar /app/app.jar
EXPOSE 9040
ENTRYPOINT ["java", "-jar", "app.jar"]