package app.clothesstore.productos.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

@Configuration
@PropertySource("classpath:mensajes.properties")
public class ConfigProperties {

	@Bean(name = "mensajes")
    public PropertiesFactoryBean mapper() {
        var bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("mensajes.properties"));
        return bean;
    }
	
	@Bean(name = "queries")
    public PropertiesFactoryBean mapperQuery() {
        var bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("queries.properties"));
        return bean;
    }
}
