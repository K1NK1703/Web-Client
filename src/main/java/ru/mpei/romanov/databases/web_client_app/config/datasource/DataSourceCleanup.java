/*
package ru.mpei.romanov.databases.web_client_app.config.datasource;

import jakarta.annotation.PreDestroy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DataSourceCleanup {

    private final DataSource dataSource;

    public DataSourceCleanup(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PreDestroy
    public void dropTables() {
        try (Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("/db/scripts/schema-drop.sql"));
            System.out.println("\nВсе сущности успешно удалены при завершении работы приложения.");
        } catch (SQLException e) {
            System.err.println("\nОшибка при удалении таблиц: " + e.getMessage());
        }
    }
}
*/
