FROM openjdk

WORKDIR /app

COPY target/locationApi-0.0.1-SNAPSHOT.jar /app/locationApi.jar

ENTRYPOINT ["java", "-jar", "locationApi.jar"]