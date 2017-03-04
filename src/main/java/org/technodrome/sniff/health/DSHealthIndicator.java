package org.technodrome.sniff.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class DSHealthIndicator implements HealthIndicator {

    @Autowired
    private DataSource dataSource;

    @Override
    public Health health() {

        Health.Builder healthBuilder = new Health.Builder();
        try (Connection conn = dataSource.getConnection()) {
            healthBuilder.withDetail("driverName", conn.getMetaData().getDriverName());
            healthBuilder.withDetail("driverVersion",conn.getMetaData().getDriverVersion());
            healthBuilder.up();
        } catch (Exception ex) {
            healthBuilder.withException(ex);
            healthBuilder.down();
        } finally {
            return healthBuilder.build();
        }
    }
}
