package org.example.config.db;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AbstractDataSourceBean;
import com.atomikos.jdbc.nonxa.AtomikosNonXADataSourceBean;

@Configuration
public class AtomikosDatabaseConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "atomikos.spartial")
    public AbstractDataSourceBean spartialDataSource() {
        AtomikosNonXADataSourceBean atomikosDataSource = new AtomikosNonXADataSourceBean();
        return atomikosDataSource;
    }

    @Bean
    public JdbcTemplate spartialJdbcTemplate() {
        return new JdbcTemplate(spartialDataSource());
    }

}
