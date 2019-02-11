package transacciones.spring.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import transacciones.spring.mybatis.modelo.Persona;

public interface PersonaMapper {

	Persona getPersona(@Param("idPersona") Integer idPersona);

	int insertarPersona(@Param("persona") Persona persona);

	int modificarPersona(@Param("persona") Persona persona);

	int eliminarPersona(@Param("idPersona") Integer idPersona);

	List<String> getNombrePersonas();
}
