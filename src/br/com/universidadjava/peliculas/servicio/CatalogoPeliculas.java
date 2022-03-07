package br.com.universidadjava.peliculas.servicio;

public interface CatalogoPeliculas {
	
	String NOMBRE_RECURSO ="peliculas.txt";
	
	void agregarPelicula(String nombrePelicula);
	
	void listarPeliculas();
	
	void buscarPeliculas(String buscar);
	
	void inciarCatalogoPeliculas();
	
}
