package co.edu.eci.escuelaing.app.Spring.tests;

import java.net.MalformedURLException;

import co.edu.eci.escuelaing.app.Spring.*;
import co.edu.eci.escuelaing.app.persistence.services.*;

public class Controller {

    private static PersistenceImpl persistence = new PersistenceImpl();

    @RequestMapping("/hello")
    public static String getHello() {
        String outputLine = "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n"
                + "<title>WebApp</title>\n" + "</head>\n" + "<body>\n"
                + "<h1>muy bien ya has probado que funciona los paths :) ahora prueba el mas importante</h1>\n"
                + "<h2>se llama prueba de Persistencia y  tendras que ingresar de la siguiente forma</h2>\n"
                + "<h1>Apps/FechaActual.js</h1>\n" + "</body>\n" + "</html>\n";
        return outputLine;

    }

    @RequestMapping("/index")
    public static String getIndex() throws MalformedURLException {
        return persistence.getArchivo("FechaActual.js");

    }
    
    @RequestMapping("/prueba")
    public static String prueba(){
        String outputLine = 
        "<!DOCTYPE html>\n"
        + "<html>\n"
        + "<head>\n"
        + "<meta charset=\"UTF-8\">\n"
        + "<title>WebApp</title>\n"
        + "</head>\n"
        + "<body>\n"
        + "<h1>Ingresa al path hello</h1>\n"
        + "</body>\n"
        + "</html>\n";
                return outputLine;
    }
    
    @RequestMapping("/App")
    public static String principal() {
        String outputLine = 
                  "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>WebApp</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Ingresa al path prueba </h1>\n"
                + "</body>\n"
                + "</html>\n";
                return outputLine;
    }
    
}
