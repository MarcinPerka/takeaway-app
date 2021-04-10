FROM maven:3.8.1-adoptopenjdk-11 as build
COPY . /usr/src/service-registry
WORKDIR /usr/src/service-registry
RUN mvn clean package
FROM adoptopenjdk/openjdk11:alpine-jre
RUN addgroup -S service-registry && adduser -S service-registry -G service-registry
RUN mkdir -p /files &&  \
        chown -R service-registry:service-registry /files
USER service-registry:service-registry
VOLUME /files
WORKDIR /app
COPY --from=build /usr/src/service-registry/target/*.jar /app/app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app.jar"]