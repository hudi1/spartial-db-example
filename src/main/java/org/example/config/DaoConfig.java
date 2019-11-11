package org.example.config;

import org.example.GeometryType;
import org.example.dao.spartial.ColaMarketsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.sqlproc.engine.plugin.SimpleSqlPluginFactory;
import org.sqlproc.engine.spring.SpringEngineFactory;

@Configuration
public class DaoConfig {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public ColaMarketsDao colaMarketsDao() {
        return new ColaMarketsDao(engineFactory());
    }

    @Bean
    public SpringEngineFactory engineFactory() {
        SpringEngineFactory sqlFactory = new SpringEngineFactory();
        sqlFactory.setMetaFilesNames("spartial/statements.meta");
        sqlFactory.setFilter("Oracle");
        SimpleSqlPluginFactory sqlPluginFactory = SimpleSqlPluginFactory.getInstance();
        sqlFactory.setPluginFactory(sqlPluginFactory);
        sqlFactory.addCustomType(new GeometryType(jdbcTemplate));
        return sqlFactory;

    }
}
