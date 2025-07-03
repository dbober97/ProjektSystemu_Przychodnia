# Etap 1: budowanie aplikacji
FROM maven:3.8.5-openjdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etap 2: uruchomienie aplikacji na WildFly
FROM quay.io/wildfly/wildfly:latest-jdk11

# Skopiuj zbudowany .war z poprzedniego etapu
COPY --from=build /app/target/Przychodnia-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/

# Skopiuj sterownik Oracle
COPY ojdbc7.jar /opt/jboss/wildfly/modules/system/layers/base/com/oracle/main/
COPY module.xml /opt/jboss/wildfly/modules/system/layers/base/com/oracle/main/

# Skopiuj konfigurację WildFly
COPY standalone-full.xml /opt/jboss/wildfly/standalone/configuration/

EXPOSE 8080

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-c", "standalone-full.xml"]
