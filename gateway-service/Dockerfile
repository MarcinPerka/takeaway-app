FROM maven:3.8.1-adoptopenjdk-11 as build
COPY . /usr/src/gateway-service
WORKDIR /usr/src/gateway-service
RUN mvn clean package
FROM adoptopenjdk/openjdk11:alpine-jre
RUN addgroup -S gateway-service && adduser -S gateway-service -G gateway-service
RUN mkdir -p /files &&  \
        chown -R gateway-service:gateway-service /files
USER gateway-service:gateway-service
VOLUME /files
WORKDIR /app
COPY --from=build /usr/src/gateway-service/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]