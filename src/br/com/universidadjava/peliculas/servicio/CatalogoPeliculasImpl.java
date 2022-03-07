package br.com.universidadjava.peliculas.servicio;

import java.util.List;

import br.com.universidadjava.peliculas.datos.AccesoDatos;
import br.com.universidadjava.peliculas.datos.AccesoDatosImpl;
import br.com.universidadjava.peliculas.domain.Pelicula;
import br.com.universidadjava.peliculas.excepciones.AccesoDatosEx;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {

	private final AccesoDatos datos;

	public CatalogoPeliculasImpl() {
		this.datos = new AccesoDatosImpl();
	}

	@Override
	public void agregarPelicula(String nombrePelicula) {
		Pelicula pelicula = new Pelicula(nombrePelicula);
		boolean anexar = false;
		try {
			anexar = datos.existe(NOMBRE_RECURSO);
			datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
		} catch (AccesoDatosEx ex) {
			System.out.println("Error de acceso a datos");
			ex.printStackTrace();
		}
	}

	@Override
	public void listarPeliculas() {
		try {
			List<Pelicula> peliculas = this.datos.listar(NOMBRE_RECURSO);
			for (Pelicula pelicula : peliculas) {
				System.out.println("Pelicula =" + pelicula);
			}
		} catch (AccesoDatosEx ex) {
			System.out.println("Error de acceso datos");
			ex.printStackTrace(System.out);
		}

	}

	@Override
	public void buscarPeliculas(String buscar) {
		String resultado = null;
		try {
			resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
		} catch (AccesoDatosEx ex) {
			System.out.println("Error  de acceso dato");
			ex.printStackTrace();
		}
		System.out.println("Resultado" + resultado);
	}

	@Override
	public void inciarCatalogoPeliculas() {
		try {
			if (this.datos.existe(NOMBRE_RECURSO)) {
				datos.borrar(NOMBRE_RECURSO);
				datos.crear(NOMBRE_RECURSO);
			} else {
				datos.crear(NOMBRE_RECURSO);
			}
		} catch (AccesoDatosEx e) {
			System.out.println("Error al iniciar Catalogo de Películas");
			e.printStackTrace(System.out);
		}
	}

}
