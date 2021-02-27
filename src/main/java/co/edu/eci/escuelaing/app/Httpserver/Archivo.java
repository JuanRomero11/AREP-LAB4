/*
 * 
 */
package co.edu.eci.escuelaing.app.Httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class Archivo.
 *
 * @author Juan Romero
 */
public class Archivo implements Response {
	
	/** The out. */
	private PrintWriter out;

	/**
	 * Instantiates a new archivo.
	 *
	 * @param out the out
	 */
	public Archivo(PrintWriter out) {
		this.out = out;
	}

	/**
	 * Solicitud archivo.
	 *
	 * @param path the path
	 * @param clientSocket the client socket
	 * @param req the req
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Override
	public void SolicitudArchivo(String path, Socket clientSocket, String req) throws IOException {
			System.out.println("++++++++++++++++++++++++++++++++++++");
			Path file = Paths.get("target/classes/public_html" + path);
			try (InputStream in = Files.newInputStream(file);
					BufferedReader reader
					= new BufferedReader(new InputStreamReader(in))) {
				String header = "HTTP/1.1 200 OK\r\n"
					+ "Content-Type: text/html\r\n"
					+ "\r\n";
				out.println(header);
				String line = null; 
				while ((line = reader.readLine()) != null) {
					out.println(line);
					System.out.println(line);
				}
			} catch (IOException ex) {
				Logger.getLogger(HttpServer.class.getName()).log(Level.SEVERE, null, ex);
			}
	
	}

	// /**
	//  * Hacer tabla carro.
	//  */
	// public void hacerTablaCarro() {
	// 	out.println("HTTP/1.1 200 \r\nContent-Type: html solicitud a base de datos\r\n\r\n");
	// 	String outputLine = "<!DOCTYPE html>" + "<html>" + "<head>" + "<title>Base de Datos</title>\n" + "</head>"
	// 			+ "<body>" + "<center>" + "<h1>Descripcion de carros</h1>" + "</center>"
	// 			+ "<table border=\"1\" style=\"margin: 0 auto;\">" + "<tr>" + "<td>Id</td>" + "<td>Nombre</td>"
	// 			+ "<td>Marca</td>" + "<td>Modelo</td>" + "</tr>";
	// 	CarroImpl carro = new CarroImpl(nuevaConexion);
	// 	ArrayList<Carro> lista = carro.getCarros();
	// 	// System.out.println("AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
	// 	// ->"+lista.size());
	// 	for (int i = 0; i < lista.size(); i++) {
	// 		outputLine += "<tr>" + "<td>" + lista.get(i).getId() + "</td>" + "<td>" + lista.get(i).getNombre() + "</td>"
	// 				+ "<td>" + lista.get(i).getMarca() + "</td>" + "<td>" + lista.get(i).getModelo() + "</td>"
	// 				+ "</tr>";
	// 	}

	// 	outputLine += "</table>" + "</body>" + "</html>";
	// 	out.println(outputLine);
	// }

}
