FROM openjdk:15-alpine
RUN apk add --no-cache tzdata
RUN apk --no-cache add curl
# Allow to run libraries like poi
RUN apk --no-cache add msttcorefonts-installer fontconfig && update-ms-fonts && fc-cache -f
ENV TZ America/Bogota
ADD target/text-analysis-service-0.0.1-SNAPSHOT.jar /
# The Djava.security.egd property is intented for SecureRandom
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/text-analysis-service-0.0.1-SNAPSHOT.jar"]