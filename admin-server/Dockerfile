FROM maven:3.8.1-adoptopenjdk-11 as build
COPY . /usr/src/admin-server
WORKDIR /usr/src/admin-server
RUN mvn clean package
FROM adoptopenjdk/openjdk11:alpine-jre
RUN addgroup -S admin-server && adduser -S admin-server -G admin-server
RUN mkdir -p /files &&  \
        chown -R admin-server:admin-server /files
USER admin-server:admin-server
VOLUME /files
WORKDIR /app
COPY --from=build /usr/src/admin-server/target/*.jar /app/app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]