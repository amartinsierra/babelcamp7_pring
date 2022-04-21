package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@PropertySource(value = "classpath:config/application.properties")
@Configuration
@ComponentScan(basePackages = {"service"})
public class ServiceConfig {
	@Value("${driver}")
	String driver;
	@Value("${url}")
	String url;
	@Value("${usuario}")
	String user;
	@Value("${pwd}")
	String pwd;
	
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource data=new DriverManagerDataSource();
		data.setDriverClassName(driver);
		data.setUrl(url);
		data.setUsername(user);
		data.setPassword(pwd);
		return data;
	}
	@Bean
	public JdbcTemplate template( DataSource data) {
		return new JdbcTemplate(data);
	}
}
