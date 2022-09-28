package pl.springacademy.dbcomparer.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DbConfig {

    @Primary
    @Bean(name = "postgres_db")
    @ConfigurationProperties("spring.database.postgres")
    public DataSource postgresDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mongo_db")
    @ConfigurationProperties("spring.data.mongodb")
    public DataSource mongoDataSource(){
        return DataSourceBuilder.create().build();
    }
}
