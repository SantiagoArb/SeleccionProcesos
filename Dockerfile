FROM openjdk:11

RUN mkdir -p /opt/backend/
COPY ./build/libs/seleccionprocesos-0.0.1-SNAPSHOT.jar /opt/backend/seleccionprocesos.jar

EXPOSE 8080
CMD ["java",  "-jar", "-Dspring.profiles.active=dev", "/opt/backend/seleccionprocesos.jar" ]