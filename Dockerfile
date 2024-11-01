FROM openjdk:21

WORKDIR /app

COPY ./build/libs/courses-service-0.0.1-SNAPSHOT.jar .

EXPOSE 8081

CMD ["sh", "-c", "sleep 10 && java -jar courses-service-0.0.1-SNAPSHOT.jar"]