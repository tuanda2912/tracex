FROM azul/zulu-openjdk-alpine:11.0.14.1-11.54.25
RUN ./gradlew clean build
COPY build/libs/tracex-1.0.jar application.jar
ENTRYPOINT ["java","-jar","/application.jar"]

