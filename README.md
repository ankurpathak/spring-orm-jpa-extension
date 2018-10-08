# Spring ORM JPA Extension
Extension to Spring ORM JPA module to provide Standard Spring SQL Exception Translation
similar to Spring JDBC module.


Currently we are only support JPA Vendor Hibernate. The support for vendors EclipseLink
and OpenJPA will we added soon in future releases.

Simple example to use the extension in your project is:
```
    @Configuration
    public class JpaConfig {
    
        private final  JdbcTemplate jdbcTemplate;
    
        public JpaConfig(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }
    
    
        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(JdbcTemplate jdbcTemplate){
            LocalContainerEntityManagerFactoryBean emf = new ExtendedLocalContainerEntityManagerFactoryBean(jdbcTemplate.getExceptionTranslator());
            emf.setDataSource(jdbcTemplate.getDataSource());
            emf.setPackagesToScan("com.github.ankurpathak.hibernatedemo");
            emf.setJpaVendorAdapter(new ExtendedHibernateJpaVendorAdaptor(jdbcTemplate.getExceptionTranslator()));
            Properties jpaProperties =  new Properties();
            jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            jpaProperties.setProperty("hibernate.show_sql", String.valueOf(Boolean.TRUE));
            jpaProperties.setProperty("hibernate.format_sql", String.valueOf(Boolean.TRUE));
            jpaProperties.setProperty("hibernate.hbm2ddl.auto", "validate");
            emf.setJpaProperties(jpaProperties);
            return emf;
        }
    }

```
Use the library by simply including the maven coordinates in your project:
```
        <dependency>
            <groupId>com.github.ankurpathak.springframework.orm.jpa</groupId>
            <artifactId>spring-orm-jpa-extension</artifactId>
            <version>1.0.1</version>
        </dependency>
```
For help regarding other build tools visit the [Maven Homepage]() of project.
