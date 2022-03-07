package br.com.universidadjava.peliculas.datos;

import java.io.*;
import java.util.*;

import br.com.universidadjava.peliculas.domain.Pelicula;
import br.com.universidadjava.peliculas.excepciones.*;

public class AccesoDatosImpl implements AccesoDatos {

	@Override
	public boolean existe(String nombreRecurso) {
		File archivo = new File(nombreRecurso);
		return archivo.exists();
	}

	@Override
	public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
		File archivo = new File(nombreRecurso);
		List<Pelicula> peliculas = new ArrayList<>();
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String linea = null;
			linea = entrada.readLine();
			while (linea != null) {
				Pelicula pelicula = new Pelicula(linea);
				peliculas.add(pelicula);
				linea = entrada.readLine();
			}
			entrada.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			throw new LecturaDatosEx("Exception al listar peliculas:" + ex.getMessage());
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new LecturaDatosEx("Exception al listar peliculas:" + ex.getMessage());
		}
		return peliculas;
	}

	@Override
	public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
		File archivo = new File(nombreRecurso);
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
			salida.println(pelicula.toString());
			salida.close();
			System.out.println("Se ha escrito información al archivo: " + pelicula);
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new EscrituraDatosEx("Exception al escribir peliculas:" + ex.getMessage());
		}

	}

	@Override
	public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
		File archivo = new File(nombreRecurso);
		String resultado = null;
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String linea = null;
			linea = entrada.readLine();
			int indice = 1;
			while (linea != null) {
				if (buscar != null && buscar.equalsIgnoreCase(linea)) {
					resultado = "Pelicula" + linea + "encontrada en el indice" + indice;
					break;
				}
				linea = entrada.readLine();
				indice++;
			}
			entrada.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			throw new LecturaDatosEx("Exception al buscar peliculas:" + ex.getMessage());
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new LecturaDatosEx("Exception al buscar peliculas:" + ex.getMessage());
		}
		return resultado;
	}

	@Override
	public void crear(String nombreRecurso) throws AccesoDatosEx {
		File archivo = new File(nombreRecurso);
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo));
			salida.close();
			System.out.println("Se ha creado el archivo");
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new AccesoDatosEx("Exception al crear peliculas:" + ex.getMessage());
		}
	}

	@Override
	public void borrar(String nombreRecurso) {
		File archivo = new File(nombreRecurso);
		if (archivo.exists()) {
			archivo.delete();
			System.out.println("Se ha borrado el archivo");
		}

	}

}
