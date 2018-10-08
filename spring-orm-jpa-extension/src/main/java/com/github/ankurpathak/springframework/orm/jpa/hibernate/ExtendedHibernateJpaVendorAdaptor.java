package com.github.ankurpathak.springframework.orm.jpa.hibernate;

import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class ExtendedHibernateJpaVendorAdaptor extends HibernateJpaVendorAdapter {
    private final SQLExceptionTranslator  sqlExceptionTranslator;
    private final HibernateJpaDialect jpaDialect;
    public ExtendedHibernateJpaVendorAdaptor(SQLExceptionTranslator sqlExceptionTranslator) {
        this.sqlExceptionTranslator = sqlExceptionTranslator;
        this.jpaDialect = new ExtendedHibernateJpaDialect(sqlExceptionTranslator);
    }


    @Override
    public HibernateJpaDialect getJpaDialect() {
        return jpaDialect;
    }
}
