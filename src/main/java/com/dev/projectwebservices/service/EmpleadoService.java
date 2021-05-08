/**
 * 
 */
package com.dev.projectwebservices.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dev.projectwebservices.entity.Empleado;

/**
 * @author pablo
 *
 */
public class EmpleadoService {

	public Empleado consultarEmpleadoPorId(String id) {
		List<Empleado> empleados = this.consultarEmpleados();
		return empleados.stream()
				.filter(emp -> emp.getNumeroEmpleado().equals(id))
				.findFirst().orElse(null);
	}
	
	public Empleado consultarEmpleado() {
		Empleado empleado = new Empleado();
		
		empleado.setNumeroEmpleado("123");
		empleado.setNombre("Pablo");
		empleado.setPrimerApellido("Ramirez");
		empleado.setSegundoApellido("Solorzano");
		empleado.setEdad(31);
		empleado.setFechaCreacion(LocalDateTime.now());
		
		return empleado;
	}
	
	public List<Empleado> consultarEmpleados() {
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		Empleado empleado1 = new Empleado();
		empleado1.setNumeroEmpleado("123");
		empleado1.setNombre("Pablo");
		empleado1.setPrimerApellido("Ramirez");
		empleado1.setSegundoApellido("Solorzano");
		empleado1.setEdad(31);
		empleado1.setFechaCreacion(LocalDateTime.now());
		
		Empleado empleado2 = new Empleado();
		empleado2.setNumeroEmpleado("124");
		empleado2.setNombre("Ixchel");
		empleado2.setPrimerApellido("Ramirez");
		empleado2.setSegundoApellido("Solorzano");
		empleado2.setEdad(31);
		empleado2.setFechaCreacion(LocalDateTime.now());
		
		empleados.addAll(Arrays.asList(empleado1, empleado2));
		return empleados;
	}
}
