FROM quay.io/wildfly/wildfly:latest-jdk11


# Skopiuj aplikację .war
COPY target/Przychodnia-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/


RUN touch /opt/jboss/wildfly/standalone/deployments/ROOT.war.dodeploy



# Skopiuj sterownik Oracle JDBC i moduł (przykład)
COPY ojdbc7.jar /opt/jboss/wildfly/modules/system/layers/base/com/oracle/main/
COPY module.xml /opt/jboss/wildfly/modules/system/layers/base/com/oracle/main/

# Skopiuj standalone.xml z konfiguracją, jeśli masz własną konfigurację DataSource
COPY standalone-full.xml /opt/jboss/wildfly/standalone/configuration/

EXPOSE 8080

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-c", "standalone-full.xml"]