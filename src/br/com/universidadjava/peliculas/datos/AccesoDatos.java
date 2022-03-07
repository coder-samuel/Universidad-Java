package br.com.universidadjava.peliculas.datos;

import java.util.List;
import br.com.universidadjava.peliculas.domain.Pelicula;
import br.com.universidadjava.peliculas.excepciones.*;

public interface AccesoDatos {

	boolean existe(String nombreRecurso) throws AccesoDatosEx;

	List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;
	
	void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;
	
	String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;
	
	void crear(String nombre) throws AccesoDatosEx;
	
	void borrar(String nombre) throws AccesoDatosEx;

}
