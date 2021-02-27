/*
 * 
 */
package co.edu.eci.escuelaing.app.Httpserver;

import java.io.IOException;
import java.net.Socket;

/**
 * The Interface Response.
 */
public interface Response {
	
	/**
	 * Solicitud archivo.
	 *
	 * @param file the file
	 * @param clientSocket the client socket
	 * @param var the var
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	void SolicitudArchivo(String file, Socket clientSocket,String var) throws IOException ;
}
