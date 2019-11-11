package org.example.dao.spartial;

import java.util.List;
import org.example.model.spartial.ColaMarkets;
import org.slf4j.Logger;
import org.sqlproc.engine.SqlControl;
import org.sqlproc.engine.SqlEngineFactory;
import org.sqlproc.engine.SqlRowProcessor;
import org.sqlproc.engine.SqlSession;
import org.sqlproc.engine.SqlSessionFactory;

@SuppressWarnings("all")
public class ColaMarketsDao {
  protected final Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
  
  public ColaMarketsDao() {
  }
  
  public ColaMarketsDao(final SqlEngineFactory sqlEngineFactory) {
    this.sqlEngineFactory = sqlEngineFactory;
  }
  
  public ColaMarketsDao(final SqlEngineFactory sqlEngineFactory, final SqlSessionFactory sqlSessionFactory) {
    this.sqlEngineFactory = sqlEngineFactory;
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  protected SqlEngineFactory sqlEngineFactory;
  
  protected SqlSessionFactory sqlSessionFactory;
  
  public ColaMarkets insert(final SqlSession sqlSession, final ColaMarkets colaMarkets, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql insert colaMarkets: " + colaMarkets + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "INSERT_COLA_MARKETS";
    org.sqlproc.engine.SqlCrudEngine sqlInsertColaMarkets = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlInsertColaMarkets.insert(sqlSession, colaMarkets, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql insert colaMarkets result: " + count + " " + colaMarkets);
    }
    return (count > 0) ? colaMarkets : null;
  }
  
  public ColaMarkets insert(final ColaMarkets colaMarkets, SqlControl sqlControl) {
    return insert(sqlSessionFactory.getSqlSession(), colaMarkets, sqlControl);
  }
  
  public ColaMarkets insert(final SqlSession sqlSession, final ColaMarkets colaMarkets) {
    return insert(sqlSession, colaMarkets, null);
  }
  
  public ColaMarkets insert(final ColaMarkets colaMarkets) {
    return insert(colaMarkets, null);
  }
  
  public ColaMarkets get(final SqlSession sqlSession, final ColaMarkets colaMarkets, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql get: " + colaMarkets + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "GET_COLA_MARKETS";
    org.sqlproc.engine.SqlCrudEngine sqlGetEngineColaMarkets = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    //sqlControl = getMoreResultClasses(colaMarkets, sqlControl);
    ColaMarkets colaMarketsGot = sqlGetEngineColaMarkets.get(sqlSession, ColaMarkets.class, colaMarkets, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql get colaMarkets result: " + colaMarketsGot);
    }
    return colaMarketsGot;
  }
  
  public ColaMarkets get(final ColaMarkets colaMarkets, SqlControl sqlControl) {
    return get(sqlSessionFactory.getSqlSession(), colaMarkets, sqlControl);
  }
  
  public ColaMarkets get(final SqlSession sqlSession, final ColaMarkets colaMarkets) {
    return get(sqlSession, colaMarkets, null);
  }
  
  public ColaMarkets get(final ColaMarkets colaMarkets) {
    return get(colaMarkets, null);
  }
  
  public int update(final SqlSession sqlSession, final ColaMarkets colaMarkets, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql update colaMarkets: " + colaMarkets + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "UPDATE_COLA_MARKETS";
    org.sqlproc.engine.SqlCrudEngine sqlUpdateEngineColaMarkets = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlUpdateEngineColaMarkets.update(sqlSession, colaMarkets, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql update colaMarkets result count: " + count);
    }
    return count;
  }
  
  public int update(final ColaMarkets colaMarkets, SqlControl sqlControl) {
    return update(sqlSessionFactory.getSqlSession(), colaMarkets, sqlControl);
  }
  
  public int update(final SqlSession sqlSession, final ColaMarkets colaMarkets) {
    return update(sqlSession, colaMarkets, null);
  }
  
  public int update(final ColaMarkets colaMarkets) {
    return update(colaMarkets, null);
  }
  
  public int delete(final SqlSession sqlSession, final ColaMarkets colaMarkets, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql delete colaMarkets: " + colaMarkets + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "DELETE_COLA_MARKETS";
    org.sqlproc.engine.SqlCrudEngine sqlDeleteEngineColaMarkets = sqlEngineFactory.getCheckedCrudEngine(sqlName);
    int count = sqlDeleteEngineColaMarkets.delete(sqlSession, colaMarkets, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql delete colaMarkets result count: " + count);
    }
    return count;
  }
  
  public int delete(final ColaMarkets colaMarkets, SqlControl sqlControl) {
    return delete(sqlSessionFactory.getSqlSession(), colaMarkets, sqlControl);
  }
  
  public int delete(final SqlSession sqlSession, final ColaMarkets colaMarkets) {
    return delete(sqlSession, colaMarkets, null);
  }
  
  public int delete(final ColaMarkets colaMarkets) {
    return delete(colaMarkets, null);
  }
  
  public List<ColaMarkets> list(final SqlSession sqlSession, final ColaMarkets colaMarkets, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql list colaMarkets: " + colaMarkets + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_COLA_MARKETS";
    org.sqlproc.engine.SqlQueryEngine sqlEngineColaMarkets = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(colaMarkets, sqlControl);
    List<ColaMarkets> colaMarketsList = sqlEngineColaMarkets.query(sqlSession, ColaMarkets.class, colaMarkets, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql list colaMarkets size: " + ((colaMarketsList != null) ? colaMarketsList.size() : "null"));
    }
    return colaMarketsList;
  }
  
  public List<ColaMarkets> list(final ColaMarkets colaMarkets, SqlControl sqlControl) {
    return list(sqlSessionFactory.getSqlSession(), colaMarkets, sqlControl);
  }
  
  public List<ColaMarkets> list(final SqlSession sqlSession, final ColaMarkets colaMarkets) {
    return list(sqlSession, colaMarkets, null);
  }
  
  public List<ColaMarkets> list(final ColaMarkets colaMarkets) {
    return list(colaMarkets, null);
  }
  
  public int query(final SqlSession sqlSession, final ColaMarkets colaMarkets, SqlControl sqlControl, final SqlRowProcessor<ColaMarkets> sqlRowProcessor) {
    if (logger.isTraceEnabled()) {
    	logger.trace("sql query colaMarkets: " + colaMarkets + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_COLA_MARKETS";
    org.sqlproc.engine.SqlQueryEngine sqlEngineColaMarkets = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(colaMarkets, sqlControl);
    int rownums = sqlEngineColaMarkets.query(sqlSession, ColaMarkets.class, colaMarkets, sqlControl, sqlRowProcessor);
    if (logger.isTraceEnabled()) {
    	logger.trace("sql query colaMarkets size: " + rownums);
    }
    return rownums;
  }
  
  public int query(final ColaMarkets colaMarkets, SqlControl sqlControl, final SqlRowProcessor<ColaMarkets> sqlRowProcessor) {
    return query(sqlSessionFactory.getSqlSession(), colaMarkets, sqlControl, sqlRowProcessor);
  }
  
  public int query(final SqlSession sqlSession, final ColaMarkets colaMarkets, final SqlRowProcessor<ColaMarkets> sqlRowProcessor) {
    return query(sqlSession, colaMarkets, null, sqlRowProcessor);
  }
  
  public int query(final ColaMarkets colaMarkets, final SqlRowProcessor<ColaMarkets> sqlRowProcessor) {
    return query(colaMarkets, null, sqlRowProcessor);
  }
  
  public int count(final SqlSession sqlSession, final ColaMarkets colaMarkets, SqlControl sqlControl) {
    if (logger.isTraceEnabled()) {
    	logger.trace("count colaMarkets: " + colaMarkets + " " + sqlControl);
    }
    String sqlName = (sqlControl != null && sqlControl.getSqlName() != null) ? sqlControl.getSqlName() : "SELECT_COLA_MARKETS";
    org.sqlproc.engine.SqlQueryEngine sqlEngineColaMarkets = sqlEngineFactory.getCheckedQueryEngine(sqlName);
    //sqlControl = getMoreResultClasses(colaMarkets, sqlControl);
    int count = sqlEngineColaMarkets.queryCount(sqlSession, colaMarkets, sqlControl);
    if (logger.isTraceEnabled()) {
    	logger.trace("count: " + count);
    }
    return count;
  }
  
  public int count(final ColaMarkets colaMarkets, SqlControl sqlControl) {
    return count(sqlSessionFactory.getSqlSession(), colaMarkets, sqlControl);
  }
  
  public int count(final SqlSession sqlSession, final ColaMarkets colaMarkets) {
    return count(sqlSession, colaMarkets, null);
  }
  
  public int count(final ColaMarkets colaMarkets) {
    return count(colaMarkets, null);
  }
}
