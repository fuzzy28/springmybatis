package org.jrue.poc.springconfig;

import javax.sql.DataSource;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;
import org.jasypt.encryption.pbe.config.PBEConfig;
import org.jasypt.spring31.properties.EncryptablePropertyOverrideConfigurer;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * DataSource, Repository and Transaction management Configuration Database
 * connection is loaded from database.properties configuration file
 * 
 * @author jruelos
 *
 */
@Configuration
@MapperScan(basePackages = { "org.jrue.poc.springmybatis.persistence" })
@EnableTransactionManagement
public class PersistenceContext {

	@Autowired
	org.jrue.poc.springmybatis.domain.DataSource dataSource;

	@Bean
	@Primary
	public DataSource getDatasource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(dataSource.getDriverClassName());
		config.setJdbcUrl(dataSource.getUrl());
		config.setUsername(dataSource.getUsername());
		config.setPassword(dataSource.getPassword());
		return new HikariDataSource(config);
	}

	@Bean
	@Primary
	public PlatformTransactionManager transactionManager() {
		;
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
	public static PBEConfig pbeConfig() {
		EnvironmentPBEConfig envPbeConfig = new EnvironmentPBEConfig();
		envPbeConfig.setAlgorithm("PBEWithMD5AndDES");
		envPbeConfig.setPasswordSysPropertyName("ENCRYPTION_PASSWORD");
		return envPbeConfig;
	}

	@Bean
	public static StringEncryptor stringEncryptor() {
		StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
		standardPBEStringEncryptor.setConfig(pbeConfig());
		return standardPBEStringEncryptor;
	}

	@Bean
	public static EncryptablePropertyOverrideConfigurer propertyOverider() {
		EncryptablePropertyOverrideConfigurer propOverider = new EncryptablePropertyOverrideConfigurer(
				stringEncryptor());
		propOverider.setLocation(new ClassPathResource("database.properties"));
		return propOverider;
	}
}