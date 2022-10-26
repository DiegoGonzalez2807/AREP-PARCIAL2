

package edu.escuelaing.arep.palindrome;

import static spark.Spark.*;

import edu.escuelaing.arep.palindrome.function.palindroBack;

/**
 *
 * @author diego.gonzalez-g
 */
public class Palindrome {

    public static palindroBack palindromeBack = new palindroBack();

    public static void main(String[] args) {
        port(getPort());

        //path para traer valores 
        get("/*", (req, res) -> {
            res.status(200);
            res.type("application/json");
            System.out.println(getValue(req.queryString()));
            return "{'operation':'palindromo','input':"+getValue(req.queryString())+",'output':"+palindromeBack.isPalindrome(getValue(req.queryString()))+"}";            
        });
        
    }

    public static int getPort(){
        if(System.getenv("PORT")!=null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        else{
            return 4567;
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
