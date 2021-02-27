/*
 * 
 */
package co.edu.eci.escuelaing.app.Spring;

import co.edu.eci.escuelaing.app.Httpserver.HttpServer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class MicroSpringBoot.
 */
public class MicroSpringBoot {
     
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args){
        try {
            MicroSpring microSpring = new MicroSpring();
            microSpring.mapService(args[0]);
            HttpServer server = new HttpServer(microSpring);
            server.start();
        } catch (Exception ex) {
            Logger.getLogger(MicroSpringBoot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
