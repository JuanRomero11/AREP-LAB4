package co.edu.eci.escuelaing.app.persistence.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class PersistenceImpl {

    private final String URL = "https://immense-brook-58674.herokuapp.com/";

    public String getArchivo(String complemento) throws MalformedURLException {
        String greeting=null;

        URL url = new URL(URL+complemento);
        System.out.println(url.toString());

        System.out.println("ENTREEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        BufferedReader bufferedReader=null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            greeting = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
      
        greeting = greeting.replace("\"", "");
        System.out.println("");
        return greeting + "saludos desde archivo del despliegue del lab3" ;
    }
}
