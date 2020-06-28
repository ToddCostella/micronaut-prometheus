FROM openjdk:14-alpine
COPY build/libs/micro-prometheus-*-all.jar micro-prometheus.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "micro-prometheus.jar"]