/**
 * 
 */
package com.dev.projectwebservices.ws;

import java.util.List;
import java.util.Objects;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dev.projectwebservices.entity.Empleado;
import com.dev.projectwebservices.service.EmpleadoService;

/**
 * @author pablo
 * Web Service generado con Jersey
 */
@Path("empleadosWS")
public class EmpleadosWS {
	
	private EmpleadoService empleadoService = new EmpleadoService();
	
	@Path("test")
	@GET
	public String test() {
		return "web service con jersey";
	}
	
	@GET
	@Path("consultarEmpleado")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Empleado consultarEmpleado() {
		return this.empleadoService.consultarEmpleado();
	}
	
	@GET
	@Path("consultarEmpleados")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Empleado> consultarEmpleados() {
		return this.empleadoService.consultarEmpleados();
	}
	
	@GET
	@Path("consultarEmpleado/{numEmp}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consultarEmpleadoPorId(@PathParam("numEmp") String numeroEmpleado) {
		Empleado empleado = this.empleadoService.consultarEmpleadoPorId(numeroEmpleado);
		return Objects.isNull(empleado) 
				? Response.noContent().build() 
						: Response.ok(new GenericEntity<Empleado>(empleado, Empleado.class)).build();
	}
	
	@POST
	@Path("guardarEmpleado")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarEmpleado(Empleado empleado) {
		if(empleado == null) {
			return Response.status(400).entity("No se ingresó información del empleado").build();
		}
		
		if(empleado.getNombre() == null || empleado.getNombre().isEmpty()) {
			return Response.status(400).entity("El nombre es requerido").build();
		}
		
		GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleado, Empleado.class);
		return Response.ok(empleadoGeneric).build();
	}

}
