package asociacion.aluma;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@PropertySource({"classpath:config/rest.properties" , "classpath:config/jackson.properties"})
public class ConfiguracionPorJava {
	

	@Bean
	public ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper;
	}

}
