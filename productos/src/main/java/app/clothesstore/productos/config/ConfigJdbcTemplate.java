package app.clothesstore.productos.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
/*
@Configuration
@EnableTransactionManagement
@EntityScan( value = { "app.clothesstore.productos.modelos.entidades" })
@ComponentScan("app.clothesstore.productos.repositorios" )
@EnableJpaRepositories( "app.clothesstore.productos.repositorios" )*/
public class ConfigJdbcTemplate {
	
	@Autowired
	private Environment environment;
	
	
	public DataSource crearDataSource() {
		return new HikariDataSource(configurar());
	}
	
	
	private HikariConfig configurar() {
		var config = new HikariConfig();
		config.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		config.setJdbcUrl(environment.getProperty("spring.datasource.url"));
		config.setUsername(environment.getProperty("spring.datasource.username"));
		config.setPassword(environment.getProperty("spring.datasource.password"));
		config.setConnectionTestQuery(environment.getProperty("spring.datasource.hikari.data-source-properties.connectionTestQuery"));
		config.setPoolName(environment.getProperty("spring.datasource.hikari.data-source-properties.poolName"));
		config.setMaximumPoolSize(Integer.valueOf(environment.getProperty("spring.datasource.hikari.data-source-properties.maximumPoolSize")));
		config.setMinimumIdle(Integer.valueOf(environment.getProperty("spring.datasource.hikari.data-source-properties.minimumIdle")));
		config.setMaxLifetime(Integer.valueOf(environment.getProperty("spring.datasource.hikari.data-source-properties.maxLifetime")));
		
		return config;
	}
	
	
	@Bean(name = "jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(crearDataSource());
	}
	
	@Bean(name = "namedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(crearDataSource());
	}

}
