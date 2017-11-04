package net.rwa.springboot.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = { "net.rwa.springboot" })
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@Configuration
public class JPAConfig {
	
	@Autowired
    private Environment env;
	
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setGenerateDdl(false);

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("net.rwa.springboot.model");
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }
	
	@Bean
    public DataSource dataSource() {
		
		//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@2"+env.getProperty("mysql.connection.driver_class"));
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("mysql.connection.driver_class"));
        dataSource.setUrl(env.getProperty("mysql.connection.url"));
        dataSource.setUsername(env.getProperty("mysql.connection.username"));
        dataSource.setPassword(env.getProperty("mysql.connection.password"));
        return dataSource;
    }
	
	@Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
	private Properties additionalProperties() {
		Properties properties = new Properties();
        // properties.setProperty("hibernate.hbm2ddl.auto",
        // env.getProperty("hibernate.hbm2ddl.auto"));
        properties.setProperty("hibernate.dialect", env.getProperty("mysql.dialect"));
        //properties.setProperty("hibernate.current_session_context_class", env.getProperty("hibernate.current_session_context_class"));
        return properties;
    }
	
}
