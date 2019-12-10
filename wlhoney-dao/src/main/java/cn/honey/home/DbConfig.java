package cn.honey.home;

import cn.honey.home.util.PropertyUtils;
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
        System.out.println(PropertyUtils.getString("spring.datasource.driverClassName"));
        dataSource.setDriverClassName(PropertyUtils.getString("spring.datasource.driverClassName"));
        dataSource.setJdbcUrl(PropertyUtils.getString("db.jdbcUrl"));
        dataSource.setUsername(PropertyUtils.getString("db.username"));
        dataSource.setPassword(PropertyUtils.getString("db.password"));
        dataSource.setMaximumPoolSize(PropertyUtils.getInt("db.maxPoolSize"));
        dataSource.setMinimumIdle(PropertyUtils.getInt("db.minIdle"));
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
        properties.put("hibernate.dialect", PropertyUtils.getString("spring.jpa.properties.hibernate.dialect"));
        return builder
                .dataSource(dataSource())
                .packages("cn.honey.home.bean")
                .properties(properties)
                .persistenceUnit("wlhoney")
                .build();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        transactionManager = new JpaTransactionManager(entityManagerFactory);
        return transactionManager;
    }

}
