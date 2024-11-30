package ru.mpei.romanov.databases.web_client_app.config.datasource;

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.SQLException;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final DataSource dataSource;

    public DatabaseInitializer(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) {
        try (Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("/db/scripts/schema-data.sql"));
            System.out.println("\nДанные успешно добавлены в таблицы.\n");
        } catch (SQLException e) {
            System.err.println("\nОшибка при создании таблиц или добавлении данных: " + e.getMessage());
        }
    }
}
