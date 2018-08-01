package com.github.ankurpathak.springframework.orm.jpa;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.PersistenceException;
import java.sql.SQLException;

/**
 * Created by ankur on 15-10-2016.
 */
public class ExtendedLocalContainerEntityManagerFactoryBean extends LocalContainerEntityManagerFactoryBean {

    private SQLExceptionTranslator sqlExceptionTranslator;

    public void setSqlExceptionTranslator(SQLExceptionTranslator sqlExceptionTranslator) {
        this.sqlExceptionTranslator = sqlExceptionTranslator;
    }




    @Override
    public DataAccessException translateExceptionIfPossible(RuntimeException ex) {
        DataAccessException translatedEx = null;
        if (ex instanceof PersistenceException) {
            if (ex.getCause() instanceof ConstraintViolationException) {
                ConstraintViolationException constraintViolationException = (ConstraintViolationException) ex.getCause();
                SQLException sqlEx = constraintViolationException.getSQLException();
                translatedEx = sqlExceptionTranslator.translate(null, null, sqlEx);
            }
        }
        if (translatedEx == null) {
            translatedEx = super.translateExceptionIfPossible(ex);
        }
        return translatedEx;

    }
}
