FROM openjdk:8-alpine
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]











#FROM openjdk:17
#
#ARG PROFILE
#ARG ADDITIONAL_OPTS
#
#ENV PROFILE=${PROFILE}
#ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}
#
#WORKDIR /opt/spring_boot
#
#COPY target/emprescar-0.0.1-SNAPSHOT.jar.original emprescar.jar
#
#SHELL ["/bin/sh", "-c"]
#
#EXPOSE 5005
#EXPOSE 8080
#
#CMD java ${ADDITIONAL_OPTS} -jar emprescar.jar --spring.profiles.active=${PROFILE}