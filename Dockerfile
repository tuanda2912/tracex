FROM azul/zulu-openjdk-alpine:11.0.14.1-11.54.25
COPY target/tracex-1.0.jar application.jar
ENTRYPOINT ["java","-XX:+UseSerialGC","-Xss1m","-Xmx512m","-jar","/application.jar"]

