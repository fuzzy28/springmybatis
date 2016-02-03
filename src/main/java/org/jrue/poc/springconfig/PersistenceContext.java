package org.jrue.poc.springconfig;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * DataSource, Repository and Transaction management Configuration
 * Database connection is loaded from database.properties configuration file
 * @author jruelos
 *
 */
@Configuration
@PropertySource("classpath:profiles/${spring.profiles.active}/database.properties")
@MapperScan(basePackages= {"org.jrue.poc.springmybatis.persistence"})
@EnableTransactionManagement
public class PersistenceContext {

	@Value("${db.driver}")
	private String driverClassName;
	
	@Value("${db.url}")	
	private String url;
	
	@Value("${db.username}")	
	private String username;
	
	@Value("${db.password}")	
	private String password;
	
	@Bean
	@Primary
	public DataSource getDatasource() {	
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driverClassName);
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		return new HikariDataSource(config);
	}
	
	@Bean
	@Primary
	public PlatformTransactionManager transactionManager() {;
		return new DataSourceTransactionManager(getDatasource());
	}
	
	@Bean
	public SqlSessionFactoryBean sessionFactory() {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(getDatasource());
		factoryBean.setTypeAliasesPackage("org.jrue.poc.springmybatis.domain");
		return factoryBean;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}