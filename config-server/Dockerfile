FROM maven:3.8.1-adoptopenjdk-11 as build
COPY . /usr/src/takeaway-app/config-server
WORKDIR /usr/src/takeaway-app/config-server
RUN mvn clean package
FROM adoptopenjdk/openjdk11:alpine-jre
RUN addgroup -S config-server && adduser -S config-server -G config-server
RUN mkdir -p /files &&  \
        chown -R config-server:config-server /files
USER config-server:config-server
VOLUME /files
WORKDIR /app
COPY --from=build /usr/src/takeaway-app/config-server/target/*.jar /app/app.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "app.jar"]
