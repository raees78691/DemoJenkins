FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
ENV JAVA_OPTS=""
EXPOSE 8050
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]