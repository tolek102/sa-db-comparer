FROM openjdk:11
ADD target/sa-db-comparer-0.0.1-SNAPSHOT.jar sa-db-comparer.jar
ENTRYPOINT ["java", "-jar","sa-db-comparer.jar"]
EXPOSE 8080