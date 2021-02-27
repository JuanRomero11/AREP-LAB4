/*
 * 
 */
package co.edu.eci.escuelaing.app.Httpserver;
import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import co.edu.eci.escuelaing.app.Spring.MicroSpring;

/**
 * The Class HttpServer.
 */
public class HttpServer {

    /** The port. */
    private int port = 4567;
    
    /** The spring. */
    MicroSpring spring;
    
    /** The client socket. */
    Socket clientSocket = null;

    /**
     * Instantiates a new http server.
     *
     * @param spring the spring
     */
    public HttpServer(MicroSpring spring) {
        this.spring = spring;
    }
    
    /**
     * Start.
     */
    public void start() {
        boolean running = false;
        try {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(port);
            } catch (IOException e) {
                System.err.println("Could not listen on port: " + port);
                System.exit(1);
            }

            running = true;
            while (running) {
                try {
                   
                    try {
                        System.out.println("Listo para recibir en puerto 4567 ...");
                        clientSocket = serverSocket.accept();
                    } catch (IOException e) {
                        System.err.println("Accept failed.");
                        System.exit(1);
                    }

                    procesoSolicitud(clientSocket);

                    clientSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(HttpServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(HttpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Proceso solicitud.
     *
     * @param clientSocket the client socket
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void procesoSolicitud(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        Map<String, String> request = new HashMap<>();
        boolean requestLineReady = false;
        while ((inputLine = in.readLine()) != null) {
       // System.out.println("++++++++++++++++++++4546465465465456++++++++++++++");
            if (!requestLineReady) {
                request.put("requestLine", inputLine);
                requestLineReady = true;
            } else {
                String[] entry =  inputLine.split(":");
                if (entry.length > 1) {
                    request.put(entry[0], entry[1]);
                }
            }
            if (!in.ready()) {
                break;
            }
        }
        
        Request req = new Request(request.get("requestLine"));
        System.out.println("RequestLine: " + req);
        solicitud(req, new PrintWriter(clientSocket.getOutputStream(), true));
        in.close();
    }


    /**
     * Solicitud.
     *
     * @param req the req
     * @param out the out
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void solicitud(Request req, PrintWriter out) throws IOException {
        URI uri = req.getTheuri();
        //StringBuilder stringBuilder = new StringBuilder();
       // Matcher matcher = Pattern.compile("GET /([^\\s]+)").matcher(stringBuilder.toString());
		//String[] partes = ;
        //System.out.println("sdasd "+ theuri.getPath().substring(5));
    //        System.out.println("sdasd *2"+ partes);

		String extension= uri.getPath().substring(5);
        System.out.println("Extension: " + extension);
        Response archivo;
		Response imagen;
        if (uri.getPath().startsWith("/Apps")) {
            getAppResponse(uri.getPath().substring(5),out);
        } else {
            if (extension.contains(".jpg") ||  extension.contains(".png")) {
                System.out.println("aquii estoy entrando a jpg ");
				imagen =new Imagen(out);
				imagen.SolicitudArchivo(uri.getPath(), clientSocket, extension);
			}else {
			    archivo =new Archivo(out);
				archivo.SolicitudArchivo(uri.getPath(), clientSocket,extension);
			}

        }
        out.close();
    }

    /**
     * Gets the app response.
     *
     * @param theuri the theuri
     * @param out the out
     * @return the app response
     */
    private void getAppResponse(String theuri, PrintWriter out) {
        String response = spring.executeService(theuri);
        String header = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n";
        out.println(header + response);
    }
}
