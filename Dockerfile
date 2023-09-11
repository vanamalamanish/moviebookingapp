FROM openjdk:8u131-jdk-alpine
EXPOSE 8080
COPY ./target/moviebookingapp.jar moviebookingapp.jar
ENTRYPOINT ["java","-jar","/moviebookingapp.jar"]