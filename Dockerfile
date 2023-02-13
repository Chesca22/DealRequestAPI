FROM openjdk:11
ENV DISPATCHBUDDY_ENV=prod
RUN touch /env.txt
RUN printenv > /env.txt
MAINTAINER dispatchbuddy.net
COPY target/datawarehouse-0.0.1-SNAPSHOT.jar datawarehouse-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/datawarehouse-0.0.1-SNAPSHOT.jar"]
