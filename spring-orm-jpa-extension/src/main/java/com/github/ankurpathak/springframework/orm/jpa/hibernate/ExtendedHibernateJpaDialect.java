package com.github.ankurpathak.springframework.orm.jpa.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import java.sql.SQLException;

/**
 * Created by ankur on 17-04-2017.
 */

public class ExtendedHibernateJpaDialect extends HibernateJpaDialect {

    private SQLExceptionTranslator sqlExceptionTranslator;

    public void setSqlExceptionTranslator(SQLExceptionTranslator sqlExceptionTranslator) {
        this.sqlExceptionTranslator = sqlExceptionTranslator;
    }


    public ExtendedHibernateJpaDialect(SQLExceptionTranslator sqlExceptionTranslator) {
        this.sqlExceptionTranslator = sqlExceptionTranslator;
    }

    @Override
    protected DataAccessException convertHibernateAccessException(HibernateException ex) {
        DataAccessException translatedEx = null;
            if (ex instanceof ConstraintViolationException) {
                ConstraintViolationException constraintViolationException = (ConstraintViolationException)ex;
                SQLException sqlEx = constraintViolationException.getSQLException();
                translatedEx = sqlExceptionTranslator.translate(null, null, sqlEx);
            }

        if (translatedEx == null) {
            translatedEx = super.translateExceptionIfPossible(ex);
        }
        return translatedEx;


    }
}
