package transacciones.spring.mybatis.repositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import transacciones.spring.mybatis.mapper.PersonaMapper;
import transacciones.spring.mybatis.modelo.Persona;

@Repository
public class RepositorioPersona {

	@Autowired
	private PersonaMapper personaMapper;

	public Persona getPersona(int idPersona) {
		return this.personaMapper.getPersona(idPersona);
	}

	public void insertarPersona(Persona persona) {
		this.personaMapper.insertarPersona(persona);
	}

	public int modificarPersona(Persona persona) {
		return this.personaMapper.modificarPersona(persona);
	}

	public int eliminarPersona(int idPersona) {
		return this.personaMapper.eliminarPersona(idPersona);
	}

	public List<String> getNombrePersonas() {
		return this.personaMapper.getNombrePersonas();
	}
}
