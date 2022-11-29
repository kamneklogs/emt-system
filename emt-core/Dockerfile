FROM gradle:7.4.1-jdk17

WORKDIR /app

ADD ./src/ src/
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle


ENTRYPOINT [ "gradle", "bootRun" ]