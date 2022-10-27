package edu.escuelaing.arep.proxy.RoundRobin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class roundRobin {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static String GET_URL = "";
    String service1 = "http://ec2-3-87-4-92.compute-1.amazonaws.com:4567/espalindromo?value=";
    String service2 = "http://ec2-54-243-14-141.compute-1.amazonaws.com:4567/espalindromo?value=";
     int  flag = 0;

    public String connect(String cadena) throws IOException {
        URL obj = new URL(GET_URL+cadena);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        System.out.println(GET_URL);
        
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
    
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                    if(inputLine.contains("{")){
                        return inputLine;}
                }
                in.close();
    
                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }
            System.out.println("GET DONE");
            return null;
        }
        

    /**
 * Funcion generada para cambiar el servidor que esta dando el servicio de acuerdo a un contador
 */
public void changeServer(){
    this.flag+=1;
    if(flag%2==0){
        GET_URL = service1;
    }
    else{
        GET_URL = service2;
    }
}
}
