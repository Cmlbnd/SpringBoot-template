FROM gradle:jdk

USER root
RUN mkdir -p /opt/gradle/.gradle
ENV GRADLE_USER_HOME=/opt/gradle/.gradle

COPY build.gradle /home/gradle
COPY settings.gradle /home/gradle
COPY release.properties /home/gradle
WORKDIR /home/gradle
RUN mkdir -p src
RUN mkdir -p config

COPY src /home/gradle/src
COPY config /home/gradle/config
RUN ["gradle","build"]

CMD ["java","-jar","build/libs/java-multi-thread.jar"]