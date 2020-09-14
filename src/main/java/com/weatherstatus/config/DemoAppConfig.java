package com.weatherstatus.config;




import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.weatherstatus.dao.UserDao;
import com.weatherstatus.dao.UserDaoImpl;
import com.weatherstatus.services.UserService;
import com.weatherstatus.services.WeatherService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.weatherstatus")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	@Autowired
	private Environment env;

	// set up a logger for diagnostics

	private static final Logger logger = LogManager.getLogger(DemoAppConfig.class.getName());	
	@Bean(name ="userService")
	public UserService getUserService() {
		logger.info("Configure userService Bean inside getUserService:");
		UserService userService = new UserService();
		return userService;
	}
	@Bean(name ="userdao")
	public UserDao getUserDao() {
		logger.info("Configure userdao Bean inside getUserDao:");
		UserDao userdao=new UserDaoImpl();
		return userdao;
	} 
	@Bean(name ="weatherService")
    public WeatherService getWeatherService()
    {
		WeatherService weatherService=new WeatherService();
       
        return weatherService;
    }
	@Bean(name ="restTemplate")
    public RestTemplate getRestTemplate()
    {
		
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(1000);
        httpRequestFactory.setConnectTimeout(1000);
        httpRequestFactory.setReadTimeout(1000);
        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
        return restTemplate;
    }
	@Bean
	public ViewResolver viewResolver() {
		logger.info("Configure viewResolver Bean inside viewResolver:");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public DataSource securityDataSource() {
		logger.info("Configure securityDataSource Bean inside securityDataSource:");
		// create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		// set the jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			logger.error(exc.getLocalizedMessage());
			throw new RuntimeException(exc);
		}
		// log the connection props
		// for sanity's sake, log this info
		// just to make sure we are REALLY reading data from properties file
		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));
		// set database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		// set connection pool props
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		return securityDataSource;
	}

	// need a helper method
	// read environment property and convert to int

	private int getIntProperty(String propName) {
		logger.info("inside getIntProperty:");

		String propVal = env.getProperty(propName);

		// now convert to int
		int intPropVal = Integer.parseInt(propVal);

		return intPropVal;
	}
}
