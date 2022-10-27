package edu.escuelaing.arep.palindrome.function;

import java.util.List;

public class palindroBack {

    /**
     * Funcion generada para revisar si la cadena registrada por el usuario es palindrome
     * @param cadena
     * @return
     */
    public String isPalindrome(String cadena){
        String[] chainSplitted = cadena.split("");
        System.out.println(chainSplitted);
        int count = 0;
        int finalCount = chainSplitted.length-1;
        for(int i = 0;i<chainSplitted.length;i++){
            if(chainSplitted[i].equals(chainSplitted[finalCount])){
                finalCount -=1;
                System.out.println(count+","+finalCount);
            }
            else{
                return "No es palindromo";
            }
        }
        return "Es palindromo";
    }
}
