/*
package cn.honey.home;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
public class DbConfig {

    private PlatformTransactionManager transactionManager;

    @Bean
    @Qualifier("primary")
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
       */
/* dataSource.setJdbcUrl(PropertiesUtils.getString("db.jdbcUrl"));
        dataSource.setUsername(PropertiesUtils.getString("db.username"));
        dataSource.setPassword(PropertiesUtils.getString("db.password"));
        dataSource.setMaximumPoolSize(PropertiesUtils.getInt("db.maxPoolSize"));
        dataSource.setMinimumIdle(PropertiesUtils.getInt("db.minIdle"));*//*

        dataSource.setConnectionTestQuery("SELECT 1 FROM DUAL");
        return dataSource;
    }

    @Bean(name = "entityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactory(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder)
            throws IllegalArgumentException {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

        return builder
                .dataSource(dataSource())
                .packages("cn.honey.home.entity")
                .properties(properties)
                .persistenceUnit("acl")
                .build();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        transactionManager = new JpaTransactionManager(entityManagerFactory);
        return transactionManager;
    }

}
*/
