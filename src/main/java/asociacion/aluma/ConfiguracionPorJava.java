package asociacion.aluma;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.databind.ObjectMapper;

import asociacion.aluma.gestorActividades.actividades.ActividadExterna;
import asociacion.aluma.gestorActividades.actividades.ActividadImp;
import asociacion.aluma.gestorActividades.actividades.ActividadLocal;
import asociacion.aluma.rest.MixIns;




@Configuration
@PropertySource({ "classpath:config/rest.properties", "classpath:config/jackson.properties" })
public class ConfiguracionPorJava {


	@Bean
	public ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.addMixIn(ActividadImp.class, MixIns.ActividadImp.class);
		mapper.addMixIn(ActividadLocal.class, MixIns.ActividadLocal.class);
		mapper.addMixIn(ActividadExterna.class, MixIns.ActividadExterna.class);
		
		return mapper;
	}
	

}
