FROM openjdk:8
ADD target/starapp.war starapp.war
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "starapp.war"]