package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.sqlproc.engine.SqlQuery;
import org.sqlproc.engine.SqlRuntimeContext;
import org.sqlproc.engine.SqlRuntimeException;
import org.sqlproc.engine.type.SqlTaggedMetaType;
import org.sqlproc.engine.type.SqlTypeFactory;

import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

public class GeometryType implements SqlTaggedMetaType {

    final Logger logger = LoggerFactory.getLogger(getClass());

    private JdbcTemplate jdbcTemplate;

    public GeometryType(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Class<?>[] getClassTypes() {
        return new Class[] { JGeometry.class };
    }

    @Override
    public Object getProviderSqlType() {
        return this;
    }

    @Override
    public String[] getMetaTypes() {
        return new String[] { "geometry" };
    }

    @Override
    public void addScalar(SqlTypeFactory typeFactory, SqlQuery query, String dbName, Class<?>... attributeTypes) {
        query.addScalar(dbName, Types.STRUCT);
    }

    @Override
    public void setResult(SqlRuntimeContext runtimeCtx, Object resultInstance, String attributeName, Object resultValue,
            boolean ingoreError) throws SqlRuntimeException {
        if (resultValue == null) {
            if (runtimeCtx.simpleSetAttribute(resultInstance, attributeName, null, JGeometry.class))
                return;
            if (ingoreError) {
                logger.error("There's no setter for " + attributeName + " in " + resultInstance
                        + ", META type is ScoreType");
                return;
            } else {
                throw new SqlRuntimeException("There's no setter for " + attributeName + " in " + resultInstance
                        + ", META type is ScoreType");
            }
        }

        if (!(resultValue instanceof STRUCT)) {
            if (ingoreError) {
                logger.error("Incorrect result value type " + resultValue + ", it should be a STRUCT");
                return;
            } else {
                throw new SqlRuntimeException("Incorrect result value type " + resultValue + ", it should be a STRUCT");
            }
        }

        try {
            if (runtimeCtx.simpleSetAttribute(resultInstance, attributeName, JGeometry.load((STRUCT) resultValue),
                    JGeometry.class))
                return;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (ingoreError) {
            logger.error(
                    "There's no setter for " + attributeName + " in " + resultInstance + ", META type is geometry");
            return;
        } else {
            throw new SqlRuntimeException(
                    "There's no setter for " + attributeName + " in " + resultInstance + ", META type is geometry");
        }
    }

    @Override
    public void setParameter(SqlRuntimeContext runtimeCtx, SqlQuery query, String paramName, Object inputValue,
            boolean ingoreError, Class<?>... inputTypes) throws SqlRuntimeException {
        if (inputValue == null) {
            query.setParameter(paramName, inputValue, Types.VARCHAR);
        } else {
            if (inputValue instanceof Collection) {
                List<String> scores = new ArrayList<String>();
                for (Iterator iter = ((Collection) inputValue).iterator(); iter.hasNext();) {
                    Object o = iter.next();
                    if (o != null) {
                        if (!(o instanceof JGeometry)) {
                            if (ingoreError) {
                                logger.error("Incorrect input value type " + o + ", it should be a geometry");
                                continue;
                            } else {
                                throw new SqlRuntimeException(
                                        "Incorrect input value type " + o + ", it should be a geometry");
                            }
                        }
                    }
                }
                query.setParameterList(paramName, scores.toArray(), Types.VARCHAR);
            } else {
                if (!(inputValue instanceof JGeometry)) {
                    if (ingoreError) {
                        logger.error("Incorrect input value type " + inputValue + ", it should be a geometry");
                        return;
                    } else {
                        throw new SqlRuntimeException(
                                "Incorrect input value type " + inputValue + ", it should be a geometry");
                    }
                }

                // TODO close conection
                Connection connection = null;
                try {
                    connection = jdbcTemplate.getDataSource().getConnection();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                STRUCT geometry = null;
                try {
                    geometry = JGeometry.store((JGeometry) inputValue, connection);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                query.setParameter(paramName, geometry, Types.STRUCT);
            }
        }
    }

}
