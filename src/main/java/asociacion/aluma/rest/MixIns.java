package asociacion.aluma.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class MixIns {

	@JsonIgnoreProperties(value = { "numeroPlazasNoEmp" })
	public abstract class ActividadImp {
	}

	@JsonPropertyOrder({ "fecha", "nombre", "precio", "numeroPlazas", "reservaPlazasEmpleados" })
	public class ActividadLocal {
	}

	@JsonPropertyOrder({ "fecha", "nombre", "destino", "precio", "numeroPlazas", "reservaPlazasEmpleados" })
	public class ActividadExterna {
	}
}
