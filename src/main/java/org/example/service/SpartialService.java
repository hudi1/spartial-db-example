package org.example.service;

import java.util.List;

import org.example.dao.spartial.ColaMarketsDao;
import org.example.model.spartial.ColaMarkets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.sqlproc.engine.SqlSession;
import org.sqlproc.engine.spring.SpringSimpleSession;

import oracle.spatial.geometry.JGeometry;

@Service
public class SpartialService {

    private Logger logger = LoggerFactory.getLogger(SpartialService.class);

    @Autowired
    private ColaMarketsDao colaMarketsDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void vlozZaznam() {
        SqlSession sqlSession = new SpringSimpleSession(jdbcTemplate);
        logger.info("Vkladam zaznam");

        colaMarketsDao.insert(sqlSession,
                new ColaMarkets().withMktId((byte) 5).withName("testicek").withShape(new JGeometry(2.0, 2.0, 2)));
    }

    public List<ColaMarkets> listZaznam() {
        SqlSession sqlSession = new SpringSimpleSession(jdbcTemplate);
        logger.info("Ctu zaznamy");

        return colaMarketsDao.list(sqlSession, new ColaMarkets());
    }

}
