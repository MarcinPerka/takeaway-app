FROM maven:3.8.1-adoptopenjdk-11 as build
COPY . /usr/src/takeaway-app/review-service
WORKDIR /usr/src/takeaway-app/review-service
RUN mvn clean package
FROM adoptopenjdk/openjdk11:alpine-jre
RUN addgroup -S review-service && adduser -S review-service -G review-service
RUN mkdir -p /files &&  \
        chown -R review-service:review-service /files
USER review-service:review-service
VOLUME /files
WORKDIR /app
COPY --from=build /usr/src/takeaway-app/review-service/target/*.jar /app/app.jar
EXPOSE 9030
ENTRYPOINT ["java", "-jar", "app.jar"]