FROM gradle:8.10.2-jdk21

WORKDIR /app

COPY /app .

EXPOSE 7070

RUN ["./gradlew", "clean", "build"]

CMD ["./gradlew", "run"]
