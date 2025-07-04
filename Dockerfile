FROM wildfly:32.0.0.Final



# Kopiujemy moduły (sterownik Oracle)
COPY modules /opt/jboss/wildfly/modules

# Kopiujemy standalone-full.xml do konfiguracji WildFly
COPY standalone-full.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml

# Kopiujemy aplikację WAR do folderu deployments
COPY Przychodnia-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/

# Expose port 8080 (domyślny w kontenerze, Render przekieruje port z zewnątrz)
EXPOSE 8080

# Uruchamiamy WildFly na 0.0.0.0 i przekazujemy port z $PORT (ustawiany przez Render)
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-Djboss.http.port=${PORT}"]

