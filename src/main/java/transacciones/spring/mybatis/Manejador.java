package transacciones.spring.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import transacciones.spring.mybatis.excepciones.PersonaException;
import transacciones.spring.mybatis.modelo.Persona;
import transacciones.spring.mybatis.servicio.ServicioPersona;

public class Manejador {

	public static void main(String[] args) {
		ApplicationContext contexto = new ClassPathXmlApplicationContext("spring-configuracion/config-spring.xml");

		final ServicioPersona servicio = contexto.getBean(ServicioPersona.class);

		final Persona persona = new Persona(null, "Nombre", "Apellido1 Apellido2");
		final Persona personaActualizar = new Persona(11, "NombreActualizado",
				"Apellido1Actualizado Apellido2Actualizado");
		final Persona personaNombreRepe = new Persona(null, "Prueba", "Apellido1 Apellido2");

		// servicio.insertarPersona(persona);
		// servicio.modificarPersona(personaActualizar);
		// servicio.comprobarInsertarNombre(personaNombreRepe);
		// System.out.println(servicio.getNombrePersonas());

		try {
			servicio.comprobarInsertarNombreDistribuida(personaNombreRepe);
		} catch (PersonaException e) {
			e.printStackTrace();
		}
	}

}
