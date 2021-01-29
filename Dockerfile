FROM adoptopenjdk/openjdk11:jre-11.0.9_11-alpine

ENV POSTGRE_URL ${POSTGRE_URL}
ENV POSTGRES_USER ${POSTGRES_USER}
ENV POSTGRES_PASSWORD ${POSTGRES_PASSWORD}

ADD build/libs/sadeb-0.0.1.jar sadeb.jar
EXPOSE 8080

ENTRYPOINT [ "sh", "-c", "java -Duser.timezone=GMT-5 -jar /sadeb.jar" ]