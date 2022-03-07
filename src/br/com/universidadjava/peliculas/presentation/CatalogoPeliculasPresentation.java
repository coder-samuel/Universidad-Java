package br.com.universidadjava.peliculas.presentation;

import java.util.Scanner;

import br.com.universidadjava.peliculas.servicio.CatalogoPeliculas;
import br.com.universidadjava.peliculas.servicio.CatalogoPeliculasImpl;

public class CatalogoPeliculasPresentation {
	
	public static void main(String[] args) {
		int opcion = -1;
		Scanner scanner = new Scanner(System.in);
		CatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
		
		while(opcion != 0) {
			System.out.println("Elige una opcion: \n"
					+"1. Iniciar catalogo de películas\n"
					+"2. Agregar películas\n"
					+"3. Listar películas\n"
					+"4. Buscar películas\n"
					+"0. Salir"); 
			opcion = Integer.parseInt(scanner.nextLine());
			switch(opcion) {
			case 1:
				catalogo.inciarCatalogoPeliculas();
				break;
			case 2:
				System.out.println("Introduce el nombre de la película");
				String nombrePelicula = scanner.nextLine();
				catalogo.agregarPelicula(nombrePelicula);
				break;
			case 3:
				catalogo.listarPeliculas();
			case 4:
				System.out.println("Introduce una película a buscar");
				String buscar = scanner.nextLine();
				catalogo.buscarPeliculas(buscar);
			case 0:
				System.out.println("Hasta pronto!");
				break;
			default:
				System.out.println("Opcion no reconocida");
			}
		}
	}
}
