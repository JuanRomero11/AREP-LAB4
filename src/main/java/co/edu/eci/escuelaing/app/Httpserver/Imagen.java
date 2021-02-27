/*
 * 
 */
package co.edu.eci.escuelaing.app.Httpserver;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * The Class Imagen.
 */
public class Imagen implements Response {

	/** The out. */
	private PrintWriter out;

	/**
	 * Instantiates a new imagen.
	 *
	 * @param out the out
	 */
	public Imagen(PrintWriter out) {
		this.out = out;
	}

	/**
	 * Solicitud archivo.
	 *
	 * @param path the path
	 * @param clientSocket the client socket
	 * @param extension the extension
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Override
	public void SolicitudArchivo(String path, Socket clientSocket, String extension) throws IOException {
		try {
			File file = new File("target/classes/public_html" + path);
			// Path file = Paths.get("target/classes/public_html" + path);
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();

			
			// System.out.println("ENTREEEEEEEEEEEEEEEEEEEEEEEEEEEE 2
		
			DataOutputStream binaryOut = new DataOutputStream(clientSocket.getOutputStream());
			binaryOut.writeBytes("HTTP/1.0 200 OK\r\n");
			binaryOut.writeBytes("Content-Type: image/" + extension + "\r\n");
			binaryOut.writeBytes("Content-Length: " + data.length);
			binaryOut.writeBytes("\r\n\r\n");
			binaryOut.write(data);
			binaryOut.close();

		} catch (FileNotFoundException e) {
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			out.println("HTTP/1.1 200 \r\nAccess-Control-Allow-Origin: *\r\nContent-Type: text/html\r\n\r\n"
					+ "<html><head><title>404</title></head><body><h1>Error 404 no se encontro la imagen</h1></body></html>");
		}
	}

}
