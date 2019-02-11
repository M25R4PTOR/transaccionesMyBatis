package transacciones.spring.mybatis.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import transacciones.spring.mybatis.excepciones.PersonaException;
import transacciones.spring.mybatis.modelo.Persona;
import transacciones.spring.mybatis.repositorio.RepositorioPersona;

@Service
public class ServicioPersona {

	@Autowired
	private RepositorioPersona repositorioPersona;

	public Persona getPersona(int idPersona) {
		return repositorioPersona.getPersona(idPersona);
	}

	public void insertarPersona(Persona persona) {
		this.repositorioPersona.insertarPersona(persona);
	}

	public int modificarPersona(Persona persona) {
		return this.repositorioPersona.modificarPersona(persona);
	}

	public int eliminarPersona(int idPersona) {
		return this.repositorioPersona.eliminarPersona(idPersona);
	}

	public List<String> getNombrePersonas() {
		return this.repositorioPersona.getNombrePersonas();
	}

	@Transactional // (noRollbackFor = PersonaException.class)
	public void comprobarInsertarNombre(Persona persona) throws PersonaException {
		if (repositorioPersona.getNombrePersonas().stream().anyMatch(nombre -> nombre.equals(persona.getNombre()))) {
			throw new PersonaException();
		}
		insertarPersona(persona);
	}

	@Transactional
	public void comprobarInsertarNombreDistribuida(Persona persona) throws PersonaException {
		repositorioPersona.insertarPersona(persona);

		persona = new Persona(persona.getId(), persona.getNombre(), "Lopez");

		repositorioPersona.modificarPersona(persona);
	}
}
