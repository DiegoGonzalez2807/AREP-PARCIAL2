

package edu.escuelaing.arep.proxy;

import spark.Service.StaticFiles;
import static spark.Spark.*;

/**
 *
 * @author diego.gonzalez-g
 */
public class Proxy {

    public static void main(String[] args) {
        port(getPort());
        StaticFilesLocation
    }

    public static int getPort(){
        if(System.getenv("PORT")!=null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        else{
            return 8080;
        }
    }

    /**
     * Funcion generada para retornar el valor que se encuentra en el endpoint 
     * @param endpoint
     * @return
     */
    public static String getValue(String endpoint){
        if(endpoint.contains("?")){
            String value = endpoint.split("?")[1].split("=")[1];
            System.out.println(value);
            return value;
        }
        else{
            return null;
        }
    }
}
