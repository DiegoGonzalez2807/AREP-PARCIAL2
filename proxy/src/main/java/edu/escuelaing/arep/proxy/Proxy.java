

package edu.escuelaing.arep.proxy;

import static spark.Spark.*;

import edu.escuelaing.arep.proxy.RoundRobin.roundRobin;

/**
 *
 * @author diego.gonzalez-g
 */
public class Proxy {

    public static roundRobin RR = new roundRobin();

    public static void main(String[] args) {
        port(getPort());
        staticFileLocation("/public");
        get("/", (req, res) -> {
            res.redirect("/index.html");
            return null;
        });
        get("/index.html", (req, res) -> {
            res.redirect("/index.html");
            return null;
        });
        //path para retornar la respuesta que viene de los servicios
        get("/*", (req, res) -> {
            res.status(200);
            res.type("application/json");
            RR.changeServer();
            return RR.getResponse(getValue(req.queryString()));
        });
        
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
        if(endpoint.contains("=")){
            String value = endpoint.split("=")[1];
            System.out.println(value);
            return value;
        }
        else{
            return null;
        }
    }
}
