

package edu.escuelaing.arep.palindrome;

import static spark.Spark.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


import edu.escuelaing.arep.palindrome.function.palindroBack;

/**
 *
 * @author diego.gonzalez-g
 */
public class Palindrome {

    public static palindroBack palindromeBack;

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "http://localhost:4567/";

    public static void main(String[] args) throws IOException {

        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        boolean flag = true;
        while(flag){
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
    
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
    
                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }
            System.out.println("GET DONE");
        }
    
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
