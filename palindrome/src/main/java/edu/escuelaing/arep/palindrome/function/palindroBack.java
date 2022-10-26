package edu.escuelaing.arep.palindrome.function;

import java.util.List;

public class palindroBack {

    /**
     * Funcion generada para revisar si la cadena registrada por el usuario es palindrome
     * @param cadena
     * @return
     */
    public boolean isPalindrome(String cadena){
        List<String> chainSplitted = List.of(cadena.split(""));
        int count = 0;
        int finalCount = chainSplitted.size()-1;
        while(count != finalCount){
            if(chainSplitted.get(count) == chainSplitted.get(finalCount)){
                count +=1;
                finalCount -=1;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
