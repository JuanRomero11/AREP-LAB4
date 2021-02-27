/*
 * 
 */
package co.edu.eci.escuelaing.app.Spring.tests;

import java.net.MalformedURLException;

import co.edu.eci.escuelaing.app.Spring.*;
import co.edu.eci.escuelaing.app.persistence.services.*;

/**
 * The Class Controller.
 */
public class Controller {

    /** The persistence. */
    private static PersistenceImpl persistence = new PersistenceImpl();

    /**
     * Gets the hello.
     *
     * @return the hello
     */
    @RequestMapping("/hello")
    public static String getHello() {
        String outputLine = "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n"
                + "<title>WebApp</title>\n" + "</head>\n" + "<body>\n"
                + "<h1>muy bien ya has probado que funciona los paths :) ahora prueba el mas importante</h1>\n"
                + "<h2>se llama prueba de Persistencia y  tendras que ingresar de la siguiente forma</h2>\n"
                + "<h1>Apps/index</h1>\n" + "</body>\n" + "</html>\n";
        return outputLine;

    }

    /**
     * Gets the index.
     *
     * @return the index
     * @throws MalformedURLException the malformed URL exception
     */
    @RequestMapping("/index")
    public static String getIndex() throws MalformedURLException {
        return persistence.getArchivo("FechaActual.js");

    }
    
    /**
     * Prueba.
     *
     * @return the string
     */
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
    
    /**
     * Principal.
     *
     * @return the string
     */
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
