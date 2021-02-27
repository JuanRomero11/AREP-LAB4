package co.edu.eci.escuelaing.app.Httpserver;

import java.io.IOException;
import java.net.Socket;

public interface Response {
	void SolicitudArchivo(String file, Socket clientSocket,String var) throws IOException ;
}
