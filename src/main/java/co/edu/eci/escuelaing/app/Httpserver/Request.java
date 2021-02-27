/*
 * 
 */
package co.edu.eci.escuelaing.app.Httpserver;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class Request.
 */
public class Request {

    /** The method. */
    private String method;
    
    /** The request URI. */
    private String requestURI;
    
    /** The HTTP version. */
    private String HTTPVersion;
    
    /** The theuri. */
    private URI theuri;
    
    /** The query. */
    private Map<String, String> query;

    /**
     * Instantiates a new request.
     *
     * @param requestLine the request line
     */
    public Request(String requestLine) {
        parseRequestLine(requestLine);
    }

    /**
     * Gets the request URI.
     *
     * @return the requestURI
     */
    public String getRequestURI() {
        return requestURI;
    }

    /**
     * Parses the request line.
     *
     * @param requestLine the request line
     */
    public void parseRequestLine(String requestLine) {
        try {
            String[] components = requestLine.split("\\s");
            method = components[0];
            requestURI = components[1];
            HTTPVersion = components[2];
            setTheuri(new URI(requestURI));
            query = parseQuery(theuri.getQuery());
        } catch (URISyntaxException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * To string.
     *
     * @return the string
     */
    public String toString() {
        return method + " " + requestURI + " " + HTTPVersion + "\n\r" + getTheuri() + "\n\r" + "Query: " + query;
    }

    /**
     * Gets the theuri.
     *
     * @return the theuri
     */
    public URI getTheuri() {
        return theuri;
    }

    /**
     * Sets the theuri.
     *
     * @param theuri the theuri to set
     */
    public void setTheuri(URI theuri) {
        this.theuri = theuri;
    }

    /**
     * Parses the query.
     *
     * @param query the query
     * @return the map
     */
    private Map<String, String> parseQuery(String query) {
        if (query == null)
            return null;
        Map<String, String> theQuery = new HashMap();
        String[] nameValuePairs = query.split("&");
        for (String nameValuePair : nameValuePairs) {
            int index = nameValuePair.indexOf("=");
            if (index != -1) {
                theQuery.put(nameValuePair.substring(0, index), nameValuePair.substring(index + 1));
            }
        }
        return theQuery;
    }

    /**
     * Gets the val from query.
     *
     * @param varname the varname
     * @return the val from query
     */
    public String getValFromQuery(String varname) {
        return query.get(varname);
    }

}
