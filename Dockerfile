FROM openjdk:17-alpine

WORKDIR /srv/issue-tracker-api

EXPOSE 8080 8787

COPY target/issue-tracker-api.jar bin/issue-tracker-api.jar

ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,address=*:8787,server=y,suspend=n","-jar","bin/-api.jar"]
