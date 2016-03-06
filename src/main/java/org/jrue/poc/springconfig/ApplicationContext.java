package org.jrue.poc.springconfig;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;
import org.jasypt.encryption.pbe.config.PBEConfig;
import org.jasypt.spring31.properties.EncryptablePropertyOverrideConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

/**
 * Main Application Configuration
 * 
 * @author jruelos
 *
 */
@Import({ PersistenceContext.class, LoggingAspect.class })
@ComponentScan(basePackages = { "org.jrue.poc" })
@EnableAspectJAutoProxy
public class ApplicationContext {

}
